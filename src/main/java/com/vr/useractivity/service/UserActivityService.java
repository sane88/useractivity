package com.vr.useractivity.service;


import com.vr.useractivity.domain.User;
import com.vr.useractivity.domain.UserActivity;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public interface UserActivityService {

    Collection<User> getUsers();

    Collection<UserActivity> getActivities();

    Collection<UserActivity> getUsersActivityForPeriod(Date from, Date to, String interval, List<Integer> userIds);
}
