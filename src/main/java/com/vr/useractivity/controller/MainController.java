package com.vr.useractivity.controller;

import com.vr.useractivity.domain.User;
import com.vr.useractivity.domain.UserActivity;
import com.vr.useractivity.service.UserActivityService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

@Controller
public class MainController {

    private static Logger logger = Logger.getLogger(MainController.class);

    @Autowired
    private UserActivityService userActivityService;

    @RequestMapping(value = "/")
    public String getMainPage(Model model){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        try {
            Date from = df.parse("2014-09-01 11:23");
            Date to = df.parse("2015-06-01 02:30");
            Collection<UserActivity> userActivities = userActivityService.getUsersActivityForPeriod(from, to, null, Arrays.asList(1, 2));
            for (UserActivity userActivity : userActivities) {
                logger.info(userActivity.getUser().getUsername());
                logger.info(userActivity.getActivityDate());
            }

        } catch (ParseException e) {
            logger.error(e);
        }
        return "index";
    }
}
