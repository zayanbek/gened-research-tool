package com.zayan.gened_researcher_tool.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "course_gen_eds")
public class CourseGenEd {

    @EmbeddedId
    private CourseGenEdId id;

    @JsonIgnore
    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    private DistinctCourse course;

    @ManyToOne
    @MapsId("categoryCode")
    @JoinColumn(name = "category_code")
    private GenEdCategory category;

    public CourseGenEd() {
    }

    public CourseGenEdId getId() {
        return id;
    }

    public void setId(CourseGenEdId id) {
        this.id = id;
    }

    public DistinctCourse getCourse() {
        return course;
    }

    public void setCourse(DistinctCourse course) {
        this.course = course;
    }

    public GenEdCategory getCategory() {
        return category;
    }

    public void setCategory(GenEdCategory category) {
        this.category = category;
    }
}