package com.vr.useractivity.service;


import com.vr.useractivity.domain.Interval;
import com.vr.useractivity.entity.User;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface UserActivityService {

    Collection<User> getUsers();

    Map<String, Map<String, Integer>> getUsersActivityForPeriod(Date from, Date to, Interval interval, List<Integer> userIds);
}
