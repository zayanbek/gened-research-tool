package com.zayan.gened_researcher_tool.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "instructors")
public class Instructor {

    @Id
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "instructor")
    private List<CourseInformation> courses;

    public Instructor() {
    }

    public Instructor(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CourseInformation> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseInformation> courses) {
        this.courses = courses;
    }
}