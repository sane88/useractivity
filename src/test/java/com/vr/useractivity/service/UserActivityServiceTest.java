package com.vr.useractivity.service;

import com.vr.useractivity.dao.UserActivityDao;
import com.vr.useractivity.domain.Interval;
import com.vr.useractivity.entity.User;
import org.junit.Assert;
import org.junit.Test;
import com.vr.useractivity.entity.UserActivity;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.*;


@RunWith(MockitoJUnitRunner.class)
public class UserActivityServiceTest {

    @Mock
    private UserActivityDao userActivityDao;

    @Test
    public void shouldTransformRecordsIntoMapWithDAYInterval() {
        //GIVEN
        Date from = getDate(2014, 8, 25, 0);
        Date to = getDate(2014, 10, 25, 0);
        User user = new User();
        user.setUserId(1);
        user.setUsername("user1");
        UserActivity userActivity1 = new UserActivity();
        userActivity1.setActivityDate(getDate(2014, 9, 1, 5));
        userActivity1.setActivityCount(1);
        userActivity1.setUser(user);
        UserActivity userActivity2 = new UserActivity();
        userActivity2.setActivityDate(getDate(2014, 9, 1, 1));
        userActivity2.setActivityCount(3);
        userActivity2.setUser(user);
        UserActivity userActivity3 = new UserActivity();
        userActivity3.setActivityDate(getDate(2014, 9, 5, 8));
        userActivity3.setActivityCount(2);
        userActivity3.setUser(user);
        Mockito.when(userActivityDao.getForPeriodAndForUsers(Mockito.any(Date.class), Mockito.any(Date.class), Mockito.anyCollection())).thenReturn(Arrays.asList(userActivity1, userActivity2, userActivity3));
        //WHEN
        UserActivityServiceImpl activityService = new UserActivityServiceImpl();
        activityService.setUserActivityDao(userActivityDao);
        Map<String, Map<String, Integer>> result = activityService.getUsersActivityForPeriod(from, to, Interval.DAY, Arrays.asList(1));
        //THEN
        Assert.assertNotNull(result);
        Assert.assertFalse(result.isEmpty());
        Assert.assertTrue(result.keySet().contains("01/09/2014"));
        Assert.assertTrue(result.keySet().contains("05/09/2014"));
        Assert.assertTrue(result.get("01/09/2014").keySet().contains("user1"));
        Assert.assertTrue(result.get("01/09/2014").get("user1").equals(4));
        Assert.assertTrue(result.get("05/09/2014").keySet().contains("user1"));
        Assert.assertTrue(result.get("05/09/2014").get("user1").equals(2));
    }

    private static Date getDate(int year, int month, int day, int hour) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DATE, day);
        calendar.set(Calendar.HOUR, hour);
        return calendar.getTime();
    }

}