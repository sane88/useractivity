package com.vr.useractivity.domain;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public enum Interval {
    YEAR("yyyy", Calendar.YEAR),
    MONTH("MM/yyyy",Calendar.MONTH),
    WEEK("dd/MM/yyyy",Calendar.WEEK_OF_MONTH),
    DAY("dd/MM/yyyy",Calendar.DAY_OF_MONTH),
    HOUR("dd/MM/yyyy HH",Calendar.HOUR);

    private String pattern;

    private int intValue;

    private Interval(String pattern, int intValue){
        this.pattern = pattern;
        this.intValue = intValue;
    }

    public String getPattern() {
        return pattern;
    }

    public int getIntValue() {
        return intValue;
    }

    public static Interval fromCode(int code){
        for (Interval interval : values()) {
            if(code == interval.getIntValue()){
                return interval;
            }
        }
        throw new IllegalArgumentException("Invalid code");
    }

    public static Map<Integer, String> asMap(){
        Map<Integer, String> map = new HashMap<Integer, String>();
        for (Interval interval : values()) {
            map.put(interval.getIntValue(), interval.toString());
        }
        return map;
    }
}
