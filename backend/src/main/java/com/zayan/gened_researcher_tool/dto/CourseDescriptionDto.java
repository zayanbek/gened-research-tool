package com.zayan.gened_researcher_tool.dto;

import java.util.List;

public class CourseDescriptionDto {

    private String description;
    private String creditHours;
    private String sectionInfo;
    private String sectionTitle;
    private String sectionCreditHours;
    private List<Double> gpaHistory;


    public CourseDescriptionDto() {
    }

    public CourseDescriptionDto(String description, String creditHours, String sectionInfo, String sectionTitle, String sectionCreditHours, List<Double> gpaHistory) {
        this.description = description;
        this.creditHours = creditHours;
        this.sectionInfo = sectionInfo;
        this.sectionTitle = sectionTitle;
        this.sectionCreditHours = sectionCreditHours;
        this.gpaHistory = gpaHistory;
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

    public List<Double> getGpaHistory() {
        return gpaHistory;
    }

    public void setGpaHistory(List<Double> gpaHistory) {
        this.gpaHistory = gpaHistory;
    }
}
