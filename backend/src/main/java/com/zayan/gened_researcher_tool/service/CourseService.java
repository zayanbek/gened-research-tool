package com.zayan.gened_researcher_tool.service;

import com.zayan.gened_researcher_tool.dto.*;

import com.zayan.gened_researcher_tool.entity.CourseInformation;
import com.zayan.gened_researcher_tool.entity.DistinctCourse;
import com.zayan.gened_researcher_tool.entity.CourseGenEd;

import com.zayan.gened_researcher_tool.entity.Instructor;
import com.zayan.gened_researcher_tool.repository.DistinctCourseRepository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import jakarta.persistence.criteria.Join;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CourseService {
    
    private final DistinctCourseRepository distinctCourseRepository;
    private final RateMyProfessorService rateMyProfessorService;

    public CourseService(DistinctCourseRepository distinctCourseRepository, RateMyProfessorService rateMyProfessorService) {
        this.distinctCourseRepository = distinctCourseRepository;
        this.rateMyProfessorService = rateMyProfessorService;
    }

    public List<CourseSearchResultDto> searchCourses(CourseSearchRequestDto request) {

        Specification<DistinctCourse> spec = buildSpecification(request);

        Sort sort = buildSort(request.getSortBy(), request.getSortDirection());

        List<DistinctCourse> courses = distinctCourseRepository.findAll(spec, sort);

        return courses.stream()
                .map(this::toCourseSearchDto)
                .toList();
    }

    public CourseDescriptionResultDto getCourse(int id) {
        DistinctCourse course = distinctCourseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        List<GpaHistoryDto> gpaHistory = getSortedGpaHistory(course);
        List<TeacherInformationDto> teacherInformation = getSortedTeacherInformation(course);
        return new CourseDescriptionResultDto(
                course.getDescription(),
                course.getCreditHours(),
                course.getSectionInfo(),
                course.getSectionTitle(),
                course.getSectionCreditHours(),
                gpaHistory,
                teacherInformation
        );
    }

    private List<GpaHistoryDto> getSortedGpaHistory(DistinctCourse course) {
        return course.getStatistics()
                .stream()
                .collect(   Collectors.groupingBy(
                        stat -> stat.getYear() + "|" + stat.getTerm()
                ))
                .values()
                .stream()
                .map(group -> {
                    CourseInformation first = group.getFirst();

                    double averageGpa = group.stream()
                            .mapToDouble(CourseInformation::getGpa)
                            .average()
                            .orElse(0.0);

                    return new GpaHistoryDto(
                            first.getYear(),
                            first.getTerm(),
                            averageGpa
                    );
                })
                .sorted(
                        Comparator
                                .comparing(GpaHistoryDto::getYear)
                                .thenComparing(dto -> switch (dto.getTerm()) {
                                    case "Spring" -> 0;
                                    case "Summer" -> 1;
                                    case "Fall" -> 2;
                                    default -> 3;
                                })
                )
                .toList();
    }

    private List<TeacherInformationDto> getSortedTeacherInformation(DistinctCourse course) {
        return course.getStatistics().stream()
                .map(CourseInformation::getInstructor)
                .filter(Objects::nonNull)
                .collect(Collectors.toMap(
                        Instructor::getId,
                        i -> new TeacherInformationDto(
                                i.getName(),
                                i.getTimesExcellent(),
                                i.getTimesOutstanding(),
                                rateMyProfessorService.getProfessor(i.getName())
                        ),
                        (a, b) -> a
                ))
                .values()
                .stream()
                .sorted(
                        Comparator.comparingInt(
                                        (TeacherInformationDto t) -> t.getExcellent() + t.getOutstanding()
                                )
                                .reversed()
                                .thenComparing(TeacherInformationDto::getName)
                )
                .toList();
    }

    private CourseSearchResultDto toCourseSearchDto(DistinctCourse course) {

        List<String> genEdCodes = course.getGenEds()
                .stream()
                .map(g -> g.getCategory().getCode())
                .toList();

        return new CourseSearchResultDto(
                course.getId(),
                course.getSubject(),
                course.getNumber(),
                course.getCourseTitle(),
                course.getAverageGpa(),
                genEdCodes,
                course.isWasOffered()
        );
    }

    private Specification<DistinctCourse> buildSpecification(CourseSearchRequestDto request) {

        Specification<DistinctCourse> spec = Specification.unrestricted();

        if (request.getSubject() != null && !request.getSubject().isBlank()) {
            spec = spec.and((root, query, cb) ->
                    cb.equal(
                            cb.lower(root.get("subject")),
                            request.getSubject().toLowerCase()
                    ));
        }

        if (request.getNumber() != null) {
            spec = spec.and((root, query, cb) ->
                    cb.equal(
                            root.get("number"),
                            request.getNumber()
                    ));
        }

        if (request.getLevel() != null) {
            int min = request.getLevel();
            int max = request.getLevel() + 99;

            spec = spec.and((root, query, cb) ->
                    cb.between(
                            root.get("number"),
                            min,
                            max
                    ));
        }

        if (request.getMinGpa() != null) {
            spec = spec.and((root, query, cb) ->
                    cb.greaterThanOrEqualTo(
                            root.get("averageGpa"),
                            request.getMinGpa()
                    ));
        }

        if (request.getMaxGpa() != null) {
            spec = spec.and((root, query, cb) ->
                    cb.lessThanOrEqualTo(
                            root.get("averageGpa"),
                            request.getMaxGpa()
                    ));
        }

        if (request.getTitle() != null && !request.getTitle().isBlank()) {
            spec = spec.and((root, query, cb) ->
                    cb.like(
                            cb.lower(root.get("courseTitle")),
                            "%" + request.getTitle().toLowerCase() + "%"
                    ));
        }

        if (request.getGenEdCodes() != null && !request.getGenEdCodes().isEmpty()) {

            spec = spec.and((root, query, cb) -> {

                Join<DistinctCourse, CourseGenEd> genEd =
                        root.join("genEds");

                query.distinct(true);

                return genEd.get("category")
                        .get("code")
                        .in(request.getGenEdCodes());
            });
        }

        if (request.getWasOffered() != null) {
            spec = spec.and((root, query, cb) ->
                    cb.equal(
                            root.get("wasOffered"),
                            request.getWasOffered()
                    ));
        }

        return spec;
    }

    private Sort buildSort(String sortBy, String sortDirection) {

        String field = switch (sortBy == null ? "" : sortBy.toLowerCase()) {
            case "subject" -> "subject";
            case "number" -> "number";
//            case "title" -> "courseTitle";
            case "gpa" -> "averageGpa";
            case "offered" -> "wasOffered";
            case "level" -> "level";
            default -> "courseTitle";
        };

        Sort.Direction direction =
                "desc".equalsIgnoreCase(sortDirection)
                        ? Sort.Direction.DESC
                        : Sort.Direction.ASC;

        return Sort.by(direction, field);
    }



}
