package com.zayan.gened_researcher_tool.service;

import com.zayan.gened_researcher_tool.dto.CourseDescriptionDto;
import com.zayan.gened_researcher_tool.dto.CourseSearchDto;
import com.zayan.gened_researcher_tool.dto.GpaHistoryDto;
import com.zayan.gened_researcher_tool.entity.CourseInformation;
import com.zayan.gened_researcher_tool.entity.DistinctCourse;
import com.zayan.gened_researcher_tool.repository.DistinctCourseRepository;
import org.springframework.stereotype.Service;
import org.springframework.data.jpa.domain.Specification;
import com.zayan.gened_researcher_tool.entity.CourseGenEd;
import jakarta.persistence.criteria.Join;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {
    
    private final DistinctCourseRepository distinctCourseRepository;

    public CourseService(DistinctCourseRepository distinctCourseRepository) {
        this.distinctCourseRepository = distinctCourseRepository;
    }

    public List<CourseSearchDto> searchCourses(
            String subject,
            Integer number,
            Integer level,
            Double minGpa,
            Double maxGpa,
            String title,
            List<String> genEdCodes,
            Boolean wasOffered)
    {

        Specification<DistinctCourse> spec = Specification.unrestricted();

        if (subject != null && !subject.isBlank()) {
            spec = spec.and((root, query, cb) ->
                    cb.equal(
                            cb.lower(root.get("subject")),
                            subject.toLowerCase()
                    ));
        }

        if (number != null) {
            spec = spec.and((root, query, cb) ->
                    cb.equal(
                            root.get("number"),
                            number
                    ));
        }

        if (level != null) {
            int min = level;
            int max = level + 99;

            spec = spec.and((root, query, cb) ->
                    cb.between(
                            root.get("number"),
                            min,
                            max
                    ));
        }

        if (minGpa != null) {
            spec = spec.and((root, query, cb) ->
                    cb.greaterThanOrEqualTo(
                            root.get("averageGpa"),
                            minGpa
                    ));
        }

        if (maxGpa != null) {
            spec = spec.and((root, query, cb) ->
                    cb.lessThanOrEqualTo(
                            root.get("averageGpa"),
                            maxGpa
                    ));
        }

        if (title != null && !title.isBlank()) {
            spec = spec.and((root, query, cb) ->
                    cb.like(
                            cb.lower(root.get("courseTitle")),
                            "%" + title.toLowerCase() + "%"
                    ));
        }

        if (genEdCodes != null && !genEdCodes.isEmpty()) {

            spec = spec.and((root, query, cb) -> {

                Join<DistinctCourse, CourseGenEd> genEd =
                        root.join("genEds");

                query.distinct(true);

                return genEd.get("category")
                        .get("code")
                        .in(genEdCodes);
            });
        }

        if (wasOffered != null) {
            spec = spec.and((root, query, cb) ->
                    cb.equal(
                            root.get("wasOffered"),
                            wasOffered
                    ));
        }

        List<DistinctCourse> courses = distinctCourseRepository.findAll(spec);

        return courses.stream()
                .map(this::toCourseSearchDto)
                .toList();
    }

    public CourseDescriptionDto getCourse(int id) {

        DistinctCourse course = distinctCourseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        List<GpaHistoryDto> gpaHistory = course.getStatistics()
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

        return new CourseDescriptionDto(
                course.getDescription(),
                course.getCreditHours(),
                course.getSectionInfo(),
                course.getSectionTitle(),
                course.getSectionCreditHours(),
                gpaHistory
        );
    }

    private CourseSearchDto toCourseSearchDto(DistinctCourse course) {

        List<String> genEdCodes = course.getGenEds()
                .stream()
                .map(g -> g.getCategory().getCode())
                .toList();

        return new CourseSearchDto(
                course.getId(),
                course.getSubject(),
                course.getNumber(),
                course.getCourseTitle(),
                course.getAverageGpa(),
                genEdCodes,
                course.isWasOffered()
        );
    }



}
