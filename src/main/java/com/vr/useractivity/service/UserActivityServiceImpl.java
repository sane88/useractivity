package com.vr.useractivity.service;

import com.vr.useractivity.dao.UserActivityDao;
import com.vr.useractivity.dao.UserDao;
import com.vr.useractivity.domain.User;
import com.vr.useractivity.domain.UserActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service
public class UserActivityServiceImpl implements UserActivityService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserActivityDao userActivityDao;

    @Transactional
    public Collection<User> getUsers() {
        return userDao.getAll();
    }

    @Transactional
    public Collection<UserActivity> getActivities(){
        return userActivityDao.getAll();
    }

    @Transactional
    public Collection<UserActivity> getUsersActivityForPeriod(Date from, Date to, String interval, List<Integer> userIds) {

        Collection<UserActivity> userActivities = userActivityDao.getForPeriodAndForUsers(from, to, userIds);

        return userActivities;
    }


}
