package com.zayan.gened_researcher_tool.repository;

import com.zayan.gened_researcher_tool.entity.CourseInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseInformationRepository extends JpaRepository<CourseInformation, Integer>,
        JpaSpecificationExecutor<CourseInformation> {
}
