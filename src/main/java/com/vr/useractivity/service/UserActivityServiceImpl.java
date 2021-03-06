package com.vr.useractivity.service;

import com.vr.useractivity.dao.UserActivityDao;
import com.vr.useractivity.dao.UserDao;
import com.vr.useractivity.domain.Interval;
import com.vr.useractivity.entity.User;
import com.vr.useractivity.entity.UserActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.vr.useractivity.util.DateUtil.truncateDate;
import static com.vr.useractivity.util.DateUtil.incrementDate;
import static com.vr.useractivity.util.DateUtil.asString;

import java.util.*;

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
    public Map<String, Map<String, Integer>> getUsersActivityForPeriod(Date from, Date to, Interval interval, List<Integer> userIds) {

        Collection<UserActivity> userActivities = userActivityDao.getForPeriodAndForUsers(from, to, userIds);
        return transform(userActivities, from, interval);
    }

    private Map<String, Map<String, Integer>> transform(Collection<UserActivity> userActivities, Date from, Interval interval){
        Date intervalStartDate = truncateDate(from, interval);
        String startDateAsString = asString(intervalStartDate, interval);
        Date intervalEndDate = incrementDate(intervalStartDate, interval);
        Map<String, Map<String, Integer>> result = new LinkedHashMap<String, Map<String, Integer>>();
        for (UserActivity userActivity : userActivities) {
            Date activityDate = userActivity.getActivityDate();
            if(!activityDate.before(intervalEndDate)){
                intervalStartDate = truncateDate(activityDate, interval);
                startDateAsString = asString(intervalStartDate, interval);
                intervalEndDate = incrementDate(intervalStartDate, interval);
            }

            Map<String, Integer> usersActivitiesForInterval = result.get(startDateAsString);
            if(usersActivitiesForInterval == null){
                usersActivitiesForInterval = new TreeMap<String, Integer>();
                result.put(startDateAsString, usersActivitiesForInterval);
            }
            String username = userActivity.getUser().getUsername();
            Integer currentDateCount = userActivity.getActivityCount();
            Integer overallCount = usersActivitiesForInterval.get(username);
            if(overallCount == null){
                overallCount = 0;
            }
            if(currentDateCount != null){
                overallCount += currentDateCount;
            }
            usersActivitiesForInterval.put(username, overallCount);

        }

        return result;
    }

    public void setUserActivityDao(UserActivityDao userActivityDao){
        this.userActivityDao = userActivityDao;
    }

}
