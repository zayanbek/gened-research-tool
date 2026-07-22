package com.zayan.gened_researcher_tool.dto;

import java.util.List;

public class CourseSearchRequestDto {
    private String subject;
    private Integer number;
    private Integer level;
    private Double minGpa;
    private Double maxGpa;
    private String title;
    private List<String> genEdCodes;
    private Boolean wasOffered;
    private String sortBy;
    private String sortDirection;

    public CourseSearchRequestDto(String subject, Integer number, Integer level, Double minGpa, Double maxGpa, String title, List<String> genEdCodes, Boolean wasOffered, String sortBy, String sortDirection) {
        this.subject = subject;
        this.number = number;
        this.level = level;
        this.minGpa = minGpa;
        this.maxGpa = maxGpa;
        this.title = title;
        this.genEdCodes = genEdCodes;
        this.wasOffered = wasOffered;
        this.sortBy = sortBy;
        this.sortDirection = sortDirection;
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

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Double getMinGpa() {
        return minGpa;
    }

    public void setMinGpa(Double minGpa) {
        this.minGpa = minGpa;
    }

    public Double getMaxGpa() {
        return maxGpa;
    }

    public void setMaxGpa(Double maxGpa) {
        this.maxGpa = maxGpa;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getGenEdCodes() {
        return genEdCodes;
    }

    public void setGenEdCodes(List<String> genEdCodes) {
        this.genEdCodes = genEdCodes;
    }

    public Boolean getWasOffered() {
        return wasOffered;
    }

    public void setWasOffered(Boolean wasOffered) {
        this.wasOffered = wasOffered;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public String getSortDirection() {
        return sortDirection;
    }

    public void setSortDirection(String sortDirection) {
        this.sortDirection = sortDirection;
    }
}
