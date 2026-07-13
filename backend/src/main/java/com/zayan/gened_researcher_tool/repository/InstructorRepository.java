package com.zayan.gened_researcher_tool.repository;

import com.zayan.gened_researcher_tool.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Integer>,
        JpaSpecificationExecutor<Instructor> {
}
