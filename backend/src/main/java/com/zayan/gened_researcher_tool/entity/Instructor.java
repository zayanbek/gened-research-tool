package com.zayan.gened_researcher_tool.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "instructors")
public class Instructor {

    @Id
    private Integer id;

    private String name;

    @Column(name="times_excellent")
    private Integer timesExcellent;

    @Column(name="times_outstanding")
    private Integer timesOutstanding;

    @OneToMany(mappedBy = "instructor")
    private List<CourseInformation> courses;

    public Instructor() {
    }

    public Instructor(Integer id, String name, Integer timesExcellent, Integer timesOutstanding, List<CourseInformation> courses) {
        this.id = id;
        this.name = name;
        this.timesExcellent = timesExcellent;
        this.timesOutstanding = timesOutstanding;
        this.courses = courses;
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

    public Integer getTimesExcellent() {
        return timesExcellent;
    }

    public void setTimesExcellent(Integer timesExcellent) {
        this.timesExcellent = timesExcellent;
    }

    public Integer getTimesOutstanding() {
        return timesOutstanding;
    }

    public void setTimesOutstanding(Integer timesOutstanding) {
        this.timesOutstanding = timesOutstanding;
    }
}