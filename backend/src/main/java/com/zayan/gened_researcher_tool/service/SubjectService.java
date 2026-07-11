package com.zayan.gened_researcher_tool.service;

import com.zayan.gened_researcher_tool.entity.Subject;
import com.zayan.gened_researcher_tool.repository.SubjectRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    private final SubjectRepository repository;

    public SubjectService(SubjectRepository repository) {
        this.repository = repository;
    }

    public List<Subject> searchSubjects(String code, String name) {

        Specification<Subject> spec = Specification.unrestricted();

        if (code != null && !code.isBlank()) {
            spec = spec.and((root, query, cb) ->
                    cb.like(
                            cb.lower(root.get("code")),
                            "%" + code.toLowerCase() + "%"
                    ));
        }

        if (name != null && !name.isBlank()) {
            spec = spec.and((root, query, cb) ->
                    cb.like(
                            cb.lower(root.get("name")),
                            "%" + name.toLowerCase() + "%"
                    ));
        }

        return repository.findAll(spec);
    }
}

