package com.zayan.gened_researcher_tool.repository;

import com.zayan.gened_researcher_tool.entity.DistinctCourse;
import com.zayan.gened_researcher_tool.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DistinctCourseRepository extends JpaRepository<DistinctCourse, Integer>,
        JpaSpecificationExecutor<DistinctCourse> {
}
