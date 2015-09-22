package com.vr.useractivity.controller;

import com.vr.useractivity.domain.Interval;
import com.vr.useractivity.domain.ReportCriteria;
import com.vr.useractivity.entity.User;
import com.vr.useractivity.service.UserActivityService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class MainController {

    private static final String pattern = "dd/MM/yyyy";
    private static Logger logger = Logger.getLogger(MainController.class);

    private Map<Integer, String> allUsersMap = new LinkedHashMap<Integer, String>();

    @Autowired
    private UserActivityService userActivityService;

    @RequestMapping(value = "/")
    public String getViewActivities(@ModelAttribute("reportcriteria") ReportCriteria reportCriteria, Model model) throws ParseException{

        model.addAttribute("allUsers", loadUsers());
        model.addAttribute("intervals", Interval.asMap());
        if (!isRequestFilled(reportCriteria)) {
            return "index";
        }

        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date from = sdf.parse(reportCriteria.getFrom());
        Date to = sdf.parse(reportCriteria.getTo());

        Map<String, Map<String, Integer>> usersActivities = userActivityService.getUsersActivityForPeriod(from, to, Interval.fromCode(reportCriteria.getInterval()), reportCriteria.getUsers());
        model.addAttribute("users", extractUsersFromActivitiesRecords(usersActivities));
        model.addAttribute("userActivities", usersActivities);
        return "index";
    }

    private Set<String> extractUsersFromActivitiesRecords(Map<String, Map<String, Integer>> usersActivities){
        Set<String> users = new TreeSet<String>();
        for (Map<String, Integer> userActivity : usersActivities.values()) {
            users.addAll(userActivity.keySet());
        }
        return users;
    }

    private boolean isRequestFilled(ReportCriteria reportCriteria) {
        if (null == reportCriteria.getFrom() || null == reportCriteria.getTo() ||
                null == reportCriteria.getInterval() || null == reportCriteria.getUsers()) {
            return false;
        }
        return true;
    }

    private Map<Integer, String> loadUsers() {
        if (allUsersMap.isEmpty()) {
            Collection<User> users = userActivityService.getUsers();
            for (User user : users) {
                allUsersMap.put(user.getUserId(), user.getUsername());
            }
        }
        return allUsersMap;
    }



    @ExceptionHandler(ParseException.class)
    public ModelAndView handleParseException(ParseException pe) {
        logger.warn("From or To value entered incorrectly", pe);
        ModelAndView modelAndView = getModelAndView();
        modelAndView.getModelMap().addAttribute("message", "From or To value is entered incorrectly");
        return modelAndView;
    }

    @ExceptionHandler
    public ModelAndView handleException(Throwable throwable){
        logger.error("Something bad has happened", throwable);
        ModelAndView modelAndView = getModelAndView();
        modelAndView.getModelMap().addAttribute("message", "Internal Server Error");
        return modelAndView;
    }

    private ModelAndView getModelAndView(){
        ModelAndView modelAndView = new ModelAndView("/index");
        ModelMap modelMap = modelAndView.getModelMap();
        modelMap.addAttribute("reportcriteria", new ReportCriteria());
        modelMap.addAttribute("allUsers", loadUsers());
        modelMap.addAttribute("intervals", Interval.asMap());
        return modelAndView;
    }

}
