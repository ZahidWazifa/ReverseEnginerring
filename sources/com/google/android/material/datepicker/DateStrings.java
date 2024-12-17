package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Build;
import android.text.format.DateUtils;
import androidx.core.util.Pair;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import mt.Log390828;
import mt.Log3FA212;
import mt.Log952E92;
import mt.LogEB28DF;

/* compiled from: 00ED */
class DateStrings {
    private DateStrings() {
    }

    static Pair<String, String> getDateRangeString(Long start, Long end) {
        return getDateRangeString(start, end, (SimpleDateFormat) null);
    }

    static Pair<String, String> getDateRangeString(Long start, Long end, SimpleDateFormat userDefinedDateFormat) {
        if (start == null && end == null) {
            return Pair.create(null, null);
        }
        if (start == null) {
            String dateString = getDateString(end.longValue(), userDefinedDateFormat);
            Log3FA212.a((Object) dateString);
            LogEB28DF.a((Object) dateString);
            Log390828.a((Object) dateString);
            Log952E92.a((Object) dateString);
            return Pair.create(null, dateString);
        } else if (end == null) {
            String dateString2 = getDateString(start.longValue(), userDefinedDateFormat);
            Log3FA212.a((Object) dateString2);
            LogEB28DF.a((Object) dateString2);
            Log390828.a((Object) dateString2);
            Log952E92.a((Object) dateString2);
            return Pair.create(dateString2, null);
        } else {
            Calendar todayCalendar = UtcDates.getTodayCalendar();
            Calendar utcCalendar = UtcDates.getUtcCalendar();
            utcCalendar.setTimeInMillis(start.longValue());
            Calendar utcCalendar2 = UtcDates.getUtcCalendar();
            utcCalendar2.setTimeInMillis(end.longValue());
            if (userDefinedDateFormat != null) {
                return Pair.create(userDefinedDateFormat.format(new Date(start.longValue())), userDefinedDateFormat.format(new Date(end.longValue())));
            } else if (utcCalendar.get(1) != utcCalendar2.get(1)) {
                String yearMonthDay = getYearMonthDay(start.longValue(), Locale.getDefault());
                Log3FA212.a((Object) yearMonthDay);
                LogEB28DF.a((Object) yearMonthDay);
                Log390828.a((Object) yearMonthDay);
                Log952E92.a((Object) yearMonthDay);
                String yearMonthDay2 = getYearMonthDay(end.longValue(), Locale.getDefault());
                Log3FA212.a((Object) yearMonthDay2);
                LogEB28DF.a((Object) yearMonthDay2);
                Log390828.a((Object) yearMonthDay2);
                Log952E92.a((Object) yearMonthDay2);
                return Pair.create(yearMonthDay, yearMonthDay2);
            } else if (utcCalendar.get(1) == todayCalendar.get(1)) {
                String monthDay = getMonthDay(start.longValue(), Locale.getDefault());
                Log3FA212.a((Object) monthDay);
                LogEB28DF.a((Object) monthDay);
                Log390828.a((Object) monthDay);
                Log952E92.a((Object) monthDay);
                String monthDay2 = getMonthDay(end.longValue(), Locale.getDefault());
                Log3FA212.a((Object) monthDay2);
                LogEB28DF.a((Object) monthDay2);
                Log390828.a((Object) monthDay2);
                Log952E92.a((Object) monthDay2);
                return Pair.create(monthDay, monthDay2);
            } else {
                String monthDay3 = getMonthDay(start.longValue(), Locale.getDefault());
                Log3FA212.a((Object) monthDay3);
                LogEB28DF.a((Object) monthDay3);
                Log390828.a((Object) monthDay3);
                Log952E92.a((Object) monthDay3);
                String yearMonthDay3 = getYearMonthDay(end.longValue(), Locale.getDefault());
                Log3FA212.a((Object) yearMonthDay3);
                LogEB28DF.a((Object) yearMonthDay3);
                Log390828.a((Object) yearMonthDay3);
                Log952E92.a((Object) yearMonthDay3);
                return Pair.create(monthDay3, yearMonthDay3);
            }
        }
    }

    static String getMonthDay(long timeInMillis, Locale locale) {
        return Build.VERSION.SDK_INT >= 24 ? UtcDates.getAbbrMonthDayFormat(locale).format(new Date(timeInMillis)) : UtcDates.getMediumNoYear(locale).format(new Date(timeInMillis));
    }

    static String getMonthDayOfWeekDay(long timeInMillis, Locale locale) {
        return Build.VERSION.SDK_INT >= 24 ? UtcDates.getAbbrMonthWeekdayDayFormat(locale).format(new Date(timeInMillis)) : UtcDates.getFullFormat(locale).format(new Date(timeInMillis));
    }

    static String getYearMonthDay(long timeInMillis, Locale locale) {
        return Build.VERSION.SDK_INT >= 24 ? UtcDates.getYearAbbrMonthDayFormat(locale).format(new Date(timeInMillis)) : UtcDates.getMediumFormat(locale).format(new Date(timeInMillis));
    }

    static String getYearMonthDayOfWeekDay(long timeInMillis, Locale locale) {
        return Build.VERSION.SDK_INT >= 24 ? UtcDates.getYearAbbrMonthWeekdayDayFormat(locale).format(new Date(timeInMillis)) : UtcDates.getFullFormat(locale).format(new Date(timeInMillis));
    }

    static String getDateString(long timeInMillis) {
        String dateString = getDateString(timeInMillis, (SimpleDateFormat) null);
        Log3FA212.a((Object) dateString);
        LogEB28DF.a((Object) dateString);
        Log390828.a((Object) dateString);
        Log952E92.a((Object) dateString);
        return dateString;
    }

    static String getDateString(long timeInMillis, SimpleDateFormat userDefinedDateFormat) {
        Calendar todayCalendar = UtcDates.getTodayCalendar();
        Calendar utcCalendar = UtcDates.getUtcCalendar();
        utcCalendar.setTimeInMillis(timeInMillis);
        if (userDefinedDateFormat != null) {
            return userDefinedDateFormat.format(new Date(timeInMillis));
        }
        if (todayCalendar.get(1) == utcCalendar.get(1)) {
            String monthDay = getMonthDay(timeInMillis);
            Log3FA212.a((Object) monthDay);
            LogEB28DF.a((Object) monthDay);
            Log390828.a((Object) monthDay);
            Log952E92.a((Object) monthDay);
            return monthDay;
        }
        String yearMonthDay = getYearMonthDay(timeInMillis);
        Log3FA212.a((Object) yearMonthDay);
        LogEB28DF.a((Object) yearMonthDay);
        Log390828.a((Object) yearMonthDay);
        Log952E92.a((Object) yearMonthDay);
        return yearMonthDay;
    }

    static String getMonthDay(long timeInMillis) {
        String monthDay = getMonthDay(timeInMillis, Locale.getDefault());
        Log3FA212.a((Object) monthDay);
        LogEB28DF.a((Object) monthDay);
        Log390828.a((Object) monthDay);
        Log952E92.a((Object) monthDay);
        return monthDay;
    }

    static String getMonthDayOfWeekDay(long timeInMillis) {
        String monthDayOfWeekDay = getMonthDayOfWeekDay(timeInMillis, Locale.getDefault());
        Log3FA212.a((Object) monthDayOfWeekDay);
        LogEB28DF.a((Object) monthDayOfWeekDay);
        Log390828.a((Object) monthDayOfWeekDay);
        Log952E92.a((Object) monthDayOfWeekDay);
        return monthDayOfWeekDay;
    }

    static String getYearMonth(long timeInMillis) {
        String formatDateTime = DateUtils.formatDateTime((Context) null, timeInMillis, 8228);
        Log3FA212.a((Object) formatDateTime);
        LogEB28DF.a((Object) formatDateTime);
        Log390828.a((Object) formatDateTime);
        Log952E92.a((Object) formatDateTime);
        return formatDateTime;
    }

    static String getYearMonthDay(long timeInMillis) {
        String yearMonthDay = getYearMonthDay(timeInMillis, Locale.getDefault());
        Log3FA212.a((Object) yearMonthDay);
        LogEB28DF.a((Object) yearMonthDay);
        Log390828.a((Object) yearMonthDay);
        Log952E92.a((Object) yearMonthDay);
        return yearMonthDay;
    }

    static String getYearMonthDayOfWeekDay(long timeInMillis) {
        String yearMonthDayOfWeekDay = getYearMonthDayOfWeekDay(timeInMillis, Locale.getDefault());
        Log3FA212.a((Object) yearMonthDayOfWeekDay);
        LogEB28DF.a((Object) yearMonthDayOfWeekDay);
        Log390828.a((Object) yearMonthDayOfWeekDay);
        Log952E92.a((Object) yearMonthDayOfWeekDay);
        return yearMonthDayOfWeekDay;
    }
}
