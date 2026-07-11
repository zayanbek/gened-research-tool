package com.zayan.gened_researcher_tool.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="distinct_courses")
public class DistinctCourse {

    @Id
    @Column(name="id")
    private int id;

    @Column(name="subject")
    private String subject;

    @Column(name="number")
    private int number;

    @Column(name="course_title")
    private String courseTitle;

    @OneToMany(mappedBy = "course")
    private List<CourseInformation> statistics;

    @OneToMany(mappedBy = "course")
    private List<CourseGenEd> genEds;

    public DistinctCourse() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public List<CourseInformation> getStatistics() {
        return statistics;
    }

    public void setStatistics(List<CourseInformation> statistics) {
        this.statistics = statistics;
    }

    public List<CourseGenEd> getGenEds() {
        return genEds;
    }

    public void setGenEds(List<CourseGenEd> genEds) {
        this.genEds = genEds;
    }
}
