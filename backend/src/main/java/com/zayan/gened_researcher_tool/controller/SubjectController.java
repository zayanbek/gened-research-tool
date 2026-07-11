package com.zayan.gened_researcher_tool.controller;

import com.zayan.gened_researcher_tool.entity.Subject;
import com.zayan.gened_researcher_tool.service.SubjectService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping
    public List<Subject> getSubjects(
            @RequestParam(required = false) String code,
            @RequestParam(required = false) String name) {

        return subjectService.searchSubjects(code, name);
    }
}
