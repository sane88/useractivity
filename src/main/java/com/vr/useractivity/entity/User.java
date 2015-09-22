package com.vr.useractivity.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "T_USER")
public class User {

    private Integer userId;

    private String username;

    private Collection<UserActivity> userActivities = new ArrayList<UserActivity>();

    @Id
    @Column(name = "USER_ID")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Column(name = "USER_NAME")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @OneToMany(mappedBy = "id.user")
    public Collection<UserActivity> getUserActivities() {
        return userActivities;
    }

    public void setUserActivities(Collection<UserActivity> userActivities) {
        this.userActivities = userActivities;
    }
}
