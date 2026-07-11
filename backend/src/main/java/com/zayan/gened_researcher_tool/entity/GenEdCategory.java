package com.zayan.gened_researcher_tool.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="gen_ed_categories")
public class GenEdCategory {

    @Id
    @Column(name="code")
    private String code;

    @Column(name="name")
    private String name;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "parent_code")
    private GenEdCategory parent;

    @JsonIgnore
    @OneToMany(mappedBy = "parent")
    private List<GenEdCategory> children;

    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private List<CourseGenEd> courses;

    public GenEdCategory() {
    }

    public GenEdCategory(String code, String name, GenEdCategory parent, List<GenEdCategory> children, List<CourseGenEd> courses) {
        this.code = code;
        this.name = name;
        this.parent = parent;
        this.children = children;
        this.courses = courses;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GenEdCategory getParent() {
        return parent;
    }

    public void setParent(GenEdCategory parent) {
        this.parent = parent;
    }

    public List<GenEdCategory> getChildren() {
        return children;
    }

    public void setChildren(List<GenEdCategory> children) {
        this.children = children;
    }

    public List<CourseGenEd> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseGenEd> courses) {
        this.courses = courses;
    }
}
