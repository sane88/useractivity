package com.vr.useractivity.dao;


import com.vr.useractivity.entity.UserActivity;

import java.util.Collection;
import java.util.Date;

public interface UserActivityDao {

    Collection<UserActivity> getForPeriodAndForUsers(Date from, Date to, Collection<Integer> userIds);
}
