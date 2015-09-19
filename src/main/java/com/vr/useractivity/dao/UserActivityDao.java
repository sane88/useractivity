package com.vr.useractivity.dao;


import com.vr.useractivity.domain.UserActivity;

import java.util.Collection;
import java.util.Date;

public interface UserActivityDao {
    Collection<UserActivity> getAll();

    Collection<UserActivity> getForPeriodAndForUsers(Date from, Date to, Collection<Integer> userIds);
}
