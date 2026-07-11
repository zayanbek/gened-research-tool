package com.zayan.gened_researcher_tool.dto;

import java.util.List;

public class CourseSearchDto {

    private Integer id;
    private String subject;
    private Integer number;
    private String title;
    private Double averageGpa;
    private List<String> genEdCodes;

    public CourseSearchDto() {
    }

    public CourseSearchDto(Integer id, String subject, Integer number, String title, Double averageGpa, List<String> genEdCodes) {
        this.id = id;
        this.subject = subject;
        this.number = number;
        this.title = title;
        this.averageGpa = averageGpa;
        this.genEdCodes = genEdCodes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getAverageGpa() {
        return averageGpa;
    }

    public void setAverageGpa(Double averageGpa) {
        this.averageGpa = averageGpa;
    }

    public List<String> getGenEdCodes() {
        return genEdCodes;
    }

    public void setGenEdCodes(List<String> genEdCodes) {
        this.genEdCodes = genEdCodes;
    }
}
