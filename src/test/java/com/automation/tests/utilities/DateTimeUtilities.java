package com.automation.tests.utilities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateTimeUtilities {

    public static String getCurrentDate(String format){
        return LocalDate.now().format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));

    }

    public long getTimeDifference(String start, String end, String format){
        LocalTime startTime = LocalTime.parse(start, DateTimeFormatter.ofPattern(format));
        LocalTime endTime = LocalTime.parse(end, DateTimeFormatter.ofPattern(format));
        return ChronoUnit.HOURS.between(endTime, startTime);
    }



    /***
     * This method returns difference between end and start time
     * @param start
     * @param end
     * @param format
     * @return difference between end and start time as a long
     */

}
