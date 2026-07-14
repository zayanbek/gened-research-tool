package com.zayan.gened_researcher_tool.controller;

import com.zayan.gened_researcher_tool.dto.CourseSearchDto;
import com.zayan.gened_researcher_tool.service.CourseService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<CourseSearchDto> getCourses(
            @RequestParam(required = false) String subject,
            @RequestParam(required = false) Integer number,
            @RequestParam(required = false) Integer level,
            @RequestParam(required = false) Double minGpa,
            @RequestParam(required = false) Double maxGpa,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) List<String> genEdCodes,
            @RequestParam(required = false) Boolean wasOffered
    ) {
        return courseService.searchCourses(subject, number, level, minGpa, maxGpa, title, genEdCodes, wasOffered);
    }
}
