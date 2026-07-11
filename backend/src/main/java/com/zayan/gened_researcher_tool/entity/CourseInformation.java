package com.zayan.gened_researcher_tool.entity;

import jakarta.persistence.*;

@Entity
@Table(name="course_information")
public class CourseInformation {

    @Id
    @Column(name="id")
    private int id;

    @Column(name="year")
    private int year;

    @Column(name="term")
    private String term;

    @Column(name="w")
    private int w;

    @Column(name="students")
    private int students;

    @Column(name="gpa")
    private double gpa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private DistinctCourse course;

    public CourseInformation() {
    }

    public CourseInformation(int year, String term, int w, int students, double gpa, Instructor instructor, DistinctCourse course) {
        this.year = year;
        this.term = term;
        this.w = w;
        this.students = students;
        this.gpa = gpa;
        this.instructor = instructor;
        this.course = course;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getStudents() {
        return students;
    }

    public void setStudents(int students) {
        this.students = students;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public DistinctCourse getCourse() {
        return course;
    }

    public void setCourse(DistinctCourse course) {
        this.course = course;
    }
}


