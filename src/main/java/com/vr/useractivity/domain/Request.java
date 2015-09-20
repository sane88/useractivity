package com.vr.useractivity.domain;

import java.util.List;

/**
 * Created by valentyn on 20/09/15.
 */
public class Request {
    private String from;
    private String to;
    private List<String> users;

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

    public List<String> getUsers() {
        return users;
    }

    public void setUsers(List<String> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Request{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", users=" + users +
                '}';
    }
}
