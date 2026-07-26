package com.zayan.gened_researcher_tool.dto;

public class TeacherInformationDto {
    
    private String name;
    private int excellent;
    private int outstanding;
    private RateMyProfessorDto rateMyProfessor;

    public TeacherInformationDto() {
    }

    public TeacherInformationDto(String name, int excellent, int outstanding, RateMyProfessorDto rateMyProfessor) {
        this.name = name;
        this.excellent = excellent;
        this.outstanding = outstanding;
        this.rateMyProfessor = rateMyProfessor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExcellent() {
        return excellent;
    }

    public void setExcellent(int excellent) {
        this.excellent = excellent;
    }

    public int getOutstanding() {
        return outstanding;
    }

    public void setOutstanding(int outstanding) {
        this.outstanding = outstanding;
    }

    public RateMyProfessorDto getRateMyProfessor() {
        return rateMyProfessor;
    }

    public void setRateMyProfessor(RateMyProfessorDto rateMyProfessor) {
        this.rateMyProfessor = rateMyProfessor;
    }
}

