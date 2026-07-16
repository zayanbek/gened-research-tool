package com.zayan.gened_researcher_tool.dto;

public class GpaHistoryDto {

    private int year;
    private String term;
    private double gpa;

    public GpaHistoryDto(int year, String term, double gpa) {
        this.year = year;
        this.term = term;
        this.gpa = gpa;
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

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
}
