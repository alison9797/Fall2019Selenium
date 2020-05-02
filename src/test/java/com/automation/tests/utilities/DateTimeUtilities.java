package com.automation.tests.utilities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateTimeUtilities {

    public static String getCurrentDate(String format){
        return LocalDate.now().format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));

    }
}
//left at 2 hours 09 minutes