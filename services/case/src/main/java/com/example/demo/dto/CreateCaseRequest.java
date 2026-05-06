package com.example.demo.dto;

public class CreateCaseRequest {
    private String name;
    private Boolean due;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getDue() {
        return due;
    }

    public void setDue(Boolean due) {
        this.due = due;
    }
}
