package com.acem.jobscrapper.dto;

import java.util.Date;

public class Job {
    private String name;
    private Company company;
    private Date deadline;

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Job{" +
                "name='" + name + '\'' +
                ", company=" + company +
                ", deadline=" + deadline +
                '}';
    }
}