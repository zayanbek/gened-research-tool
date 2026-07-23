package com.zayan.gened_researcher_tool.controller;

import com.zayan.gened_researcher_tool.dto.CourseDescriptionResultDto;
import com.zayan.gened_researcher_tool.dto.CourseDescriptionResultDto;
import com.zayan.gened_researcher_tool.dto.CourseSearchRequestDto;
import com.zayan.gened_researcher_tool.dto.CourseSearchResultDto;
import com.zayan.gened_researcher_tool.service.CourseService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<CourseSearchResultDto> getCourses(
            @RequestParam(required = false) String subject,
            @RequestParam(required = false) Integer number,
            @RequestParam(required = false) Integer level,
            @RequestParam(required = false) Double minGpa,
            @RequestParam(required = false) Double maxGpa,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) List<String> genEdCodes,
            @RequestParam(required = false) Boolean wasOffered,
            @RequestParam(defaultValue = "courseTitle") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDirection
    ) {
        return courseService.searchCourses(new CourseSearchRequestDto(
                    subject,
                    number,
                    level,
                    minGpa,
                    maxGpa,
                    title,
                    genEdCodes,
                    wasOffered,
                    sortBy,
                    sortDirection
                )
        );
    }

    @GetMapping("/{id}")
    public CourseDescriptionResultDto getCourseDescription(
            @PathVariable Integer id
    ) {
        return courseService.getCourse(id);
    }
}
