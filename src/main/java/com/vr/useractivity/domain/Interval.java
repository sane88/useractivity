package com.vr.useractivity.domain;

import java.util.Calendar;

/**
 * Created by valentyn on 19/09/15.
 */
public enum Interval {
    YEAR("yyyy", Calendar.YEAR),
    MONTH("MM/yyyy",Calendar.MONTH),
    WEEK("dd/MM/yyyy",Calendar.WEEK_OF_MONTH),
    DAY("dd/MM/yyyy",Calendar.DAY_OF_MONTH),
    HOUR("dd/MM/yyyy hh",Calendar.HOUR);

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
}
