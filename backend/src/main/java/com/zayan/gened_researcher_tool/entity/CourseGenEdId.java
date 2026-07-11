package com.zayan.gened_researcher_tool.entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class CourseGenEdId implements Serializable {

    private Integer courseId;

    private String categoryCode;

    public CourseGenEdId() {
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }
}