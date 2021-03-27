package com.mycompany.edu.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author yosrixp
 */
public class Employee {

    private Long id;
    private String name;
    private String title;

    public Employee() {

    }

    public Employee(Long id, String name, String title) {
        this.id = id;
        this.name = name;
        this.title = title;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty(value = "employeeId")
    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty(value = "employeeName")
    public String getName() {
        return name;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty(value = "title")
    public String getTitle() {
        return title;
    }

}
