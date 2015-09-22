package com.vr.useractivity.util;

import com.vr.useractivity.domain.Interval;
import org.apache.commons.lang3.time.DateUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public final class DateUtil {
    private DateUtil(){}

    public static Date incrementDate(Date date, Interval interval){
        switch (interval.getIntValue()){
            case Calendar.YEAR:
                return DateUtils.addYears(date, 1);
            case Calendar.MONTH:
                return DateUtils.addMonths(date, 1);
            case Calendar.WEEK_OF_MONTH:
                return DateUtils.addWeeks(date, 1);
            case Calendar.DAY_OF_MONTH:
                return DateUtils.addDays(date, 1);
            default:
                return DateUtils.addHours(date, 1);

        }
    }

    public static Date truncateDate(Date date, Interval interval){
        if(Calendar.WEEK_OF_MONTH == interval.getIntValue()){
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(DateUtils.truncate(date, Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek());
            return calendar.getTime();
        }
        return DateUtils.truncate(date, interval.getIntValue());
    }

    public static String asString(Date date, Interval interval){
        SimpleDateFormat sdf = new SimpleDateFormat(interval.getPattern());
        return sdf.format(date);
    }
}
