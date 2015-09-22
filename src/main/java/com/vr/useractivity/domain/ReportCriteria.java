package com.vr.useractivity.domain;

import java.util.List;


public class ReportCriteria {
    private String from;
    private String to;
    private List<Integer> users;
    private Integer interval;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public List<Integer> getUsers() {
        return users;
    }

    public void setUsers(List<Integer> users) {
        this.users = users;
    }

    public Integer getInterval() {
        return interval;
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
    }

    @Override
    public String toString() {
        return "ReportCriteria{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", users=" + users +
                ", interval=" + interval +
                '}';
    }
}
