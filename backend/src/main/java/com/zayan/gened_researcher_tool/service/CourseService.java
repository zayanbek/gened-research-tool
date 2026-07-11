package com.zayan.gened_researcher_tool.service;

import com.zayan.gened_researcher_tool.entity.CourseInformation;
import com.zayan.gened_researcher_tool.entity.DistinctCourse;
import com.zayan.gened_researcher_tool.repository.CourseInformationRepository;
import org.springframework.stereotype.Service;
import org.springframework.data.jpa.domain.Specification;
import com.zayan.gened_researcher_tool.entity.CourseGenEd;
import com.zayan.gened_researcher_tool.entity.CourseInformation;
import com.zayan.gened_researcher_tool.entity.DistinctCourse;
import com.zayan.gened_researcher_tool.repository.CourseInformationRepository;
import jakarta.persistence.criteria.Join;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {
    
    private final CourseInformationRepository courseInformationRepository;

    public CourseService(CourseInformationRepository courseInformationRepository) {
        this.courseInformationRepository = courseInformationRepository;
    }

    public List<DistinctCourse> searchCourses(
            String subject,
            Integer number,
            Integer level,
            Double minGpa,
            Double maxGpa,
            String title,
            List<String> genEdCodes)
    {

        Specification<CourseInformation> spec = Specification.unrestricted();

        if (subject != null && !subject.isBlank()) {
            spec = spec.and((root, query, cb) ->
                    cb.equal(
                            cb.lower(root.get("course").get("subject")),
                            subject.toLowerCase()
                    ));
        }

        if (number != null) {
            spec = spec.and((root, query, cb) ->
                    cb.equal(
                            root.get("course").get("number"),
                            number
                    ));
        }

        if (level != null) {
            int min = level;
            int max = level + 99;

            spec = spec.and((root, query, cb) ->
                    cb.between(
                            root.get("course").get("number"),
                            min,
                            max
                    ));
        }

        if (minGpa != null) {
            spec = spec.and((root, query, cb) ->
                    cb.greaterThanOrEqualTo(
                            root.get("gpa"),
                            minGpa
                    ));
        }

        if (maxGpa != null) {
            spec = spec.and((root, query, cb) ->
                    cb.lessThanOrEqualTo(
                            root.get("gpa"),
                            maxGpa
                    ));
        }

        if (title != null && !title.isBlank()) {
            spec = spec.and((root, query, cb) ->
                    cb.like(
                            cb.lower(root.get("course").get("courseTitle")),
                            "%" + title.toLowerCase() + "%"
                    ));
        }

        if (genEdCodes != null && !genEdCodes.isEmpty()) {

            spec = spec.and((root, query, cb) -> {

                Join<CourseInformation, DistinctCourse> course =
                        root.join("course");

                Join<DistinctCourse, CourseGenEd> genEd =
                        course.join("genEds");

                query.distinct(true);

                return genEd.get("category")
                        .get("code")
                        .in(genEdCodes);
            });
        }

        return courseInformationRepository.findAll(spec)
                .stream()
                .map(CourseInformation::getCourse)
                .distinct()
                .collect(Collectors.toList());
    }



}
