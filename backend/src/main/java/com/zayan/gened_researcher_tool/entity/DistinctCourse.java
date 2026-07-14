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

    @Column(name="average_gpa")
    private double averageGpa;

    // New Columns

    @Column(name="was_offered_spring_2026")
    private boolean wasOffered;

    @Column(name="description")
    private String description;

    @Column(name="credit_hours")
    private String creditHours;

    @Column(name="section_info")
    private String sectionInfo;

    @Column(name="section_title")
    private String sectionTitle;

    @Column(name="section_credit_hours")
    private String sectionCreditHours;

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

    public double getAverageGpa() {
        return averageGpa;
    }

    public void setAverageGpa(double averageGpa) {
        this.averageGpa = averageGpa;
    }

    public boolean isWasOffered() {
        return wasOffered;
    }

    public void setWasOffered(boolean wasOffered) {
        this.wasOffered = wasOffered;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(String creditHours) {
        this.creditHours = creditHours;
    }

    public String getSectionInfo() {
        return sectionInfo;
    }

    public void setSectionInfo(String sectionInfo) {
        this.sectionInfo = sectionInfo;
    }

    public String getSectionTitle() {
        return sectionTitle;
    }

    public void setSectionTitle(String sectionTitle) {
        this.sectionTitle = sectionTitle;
    }

    public String getSectionCreditHours() {
        return sectionCreditHours;
    }

    public void setSectionCreditHours(String sectionCreditHours) {
        this.sectionCreditHours = sectionCreditHours;
    }
}
