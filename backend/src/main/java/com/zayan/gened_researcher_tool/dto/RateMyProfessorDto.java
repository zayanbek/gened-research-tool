package com.zayan.gened_researcher_tool.dto;

public class RateMyProfessorDto {

    private String formattedName;

    private double avgRating;

    private double avgDifficulty;

    private int numRatings;

    private int wouldTakeAgainPercent;

    private String department;

    private String link;

    public RateMyProfessorDto() {
    }

    public RateMyProfessorDto(String formattedName, double avgRating, double avgDifficulty, int numRatings, int wouldTakeAgainPercent, String department, String link) {
        this.formattedName = formattedName;
        this.avgRating = avgRating;
        this.avgDifficulty = avgDifficulty;
        this.numRatings = numRatings;
        this.wouldTakeAgainPercent = wouldTakeAgainPercent;
        this.department = department;
        this.link = link;
    }

    public static RateMyProfessorDto empty(String instructorName) {
        return new RateMyProfessorDto(
                instructorName,
                -1,
                -1,
                -1,
                0,
                "",
                ""
        );
    }

    public String getFormattedName() {
        return formattedName;
    }

    public void setFormattedName(String formattedName) {
        this.formattedName = formattedName;
    }

    public double getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(double avgRating) {
        this.avgRating = avgRating;
    }

    public double getAvgDifficulty() {
        return avgDifficulty;
    }

    public void setAvgDifficulty(double avgDifficulty) {
        this.avgDifficulty = avgDifficulty;
    }

    public int getNumRatings() {
        return numRatings;
    }

    public void setNumRatings(int numRatings) {
        this.numRatings = numRatings;
    }

    public int getWouldTakeAgainPercent() {
        return wouldTakeAgainPercent;
    }

    public void setWouldTakeAgainPercent(int wouldTakeAgainPercent) {
        this.wouldTakeAgainPercent = wouldTakeAgainPercent;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}