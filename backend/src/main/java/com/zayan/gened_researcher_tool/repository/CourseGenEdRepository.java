package com.zayan.gened_researcher_tool.repository;

import com.zayan.gened_researcher_tool.entity.CourseGenEd;
import com.zayan.gened_researcher_tool.entity.CourseGenEdId;
import com.zayan.gened_researcher_tool.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseGenEdRepository extends JpaRepository<CourseGenEd, CourseGenEdId>,
        JpaSpecificationExecutor<CourseGenEd> {
}
