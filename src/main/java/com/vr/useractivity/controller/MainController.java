package com.vr.useractivity.controller;

import com.vr.useractivity.domain.Interval;
import com.vr.useractivity.domain.Request;
import com.vr.useractivity.domain.User;
import com.vr.useractivity.domain.UserActivity;
import com.vr.useractivity.service.UserActivityService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class MainController {

    private static Logger logger = Logger.getLogger(MainController.class);

    @Autowired
    private UserActivityService userActivityService;

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String getViewActivities(@ModelAttribute("view") Request request, Model model){
        logger.info(request);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        try {
//            Date from = df.parse("2014-09-01 11:23");
            Date to = df.parse("2015-06-01 02:30");
//            Map<String, Map<String, Integer>> usersActivityForPeriod = userActivityService.getUsersActivityForPeriod(from, to, Interval.DAY, Arrays.asList(1, 2));
//            for (Map.Entry<String, Map<String, Integer>> dateMapEntry : usersActivityForPeriod.entrySet()) {
//                logger.info(dateMapEntry.getKey());
//                for (Map.Entry<String, Integer> stringIntegerEntry : dateMapEntry.getValue().entrySet()) {
//                    logger.info(stringIntegerEntry.getKey());
//                    logger.info(stringIntegerEntry.getValue());
//                }
//            }
//            model.addAttribute("users", Arrays.asList("user2"));
//            model.addAttribute("userActivities", usersActivityForPeriod);
        } catch (ParseException e) {
            logger.error(e);
        }
        return "index";
    }

    @RequestMapping(value = "/")
    public String home(){
        return "index";
    }

}
