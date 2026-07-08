package com.zayan.gened_researcher_tool.service;

import com.zayan.gened_researcher_tool.entity.Subject;
import com.zayan.gened_researcher_tool.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SubjectService {

    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public List<Subject> getSubjects() {
        return subjectRepository.findAll();
    }

    public List<Subject> getSubjectByCode(String code) {
        return subjectRepository.findAll().stream()
                .filter(subject -> subject.getCode().toLowerCase().contains(code.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Subject> getSubjectByName(String name) {
        return subjectRepository.findAll().stream()
                .filter(subject -> subject.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Subject> getSubjectByCodeAndName(String code, String name) {
        return subjectRepository.findAll().stream()
                .filter(subject ->
                        subject.getCode().toLowerCase().contains(code.toLowerCase())
                    && subject.getName().toLowerCase().contains(name.toLowerCase())
                )
                .collect(Collectors.toList());
    }
}

