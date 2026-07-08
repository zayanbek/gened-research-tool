package com.zayan.gened_researcher_tool.repository;


import com.zayan.gened_researcher_tool.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, String> {

    Optional<Subject> findByCode(String code);

}
