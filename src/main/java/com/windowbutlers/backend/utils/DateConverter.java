package com.windowbutlers.backend.utils;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateConverter {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    public static Date convertStringToSqlDate(String dateString) {
        
        if (dateString == null || dateString.isEmpty()) {
            return null; // or throw an exception, depending on your use case
        }

        LocalDate localDate = LocalDate.parse(dateString, FORMATTER);
        return Date.valueOf(localDate);
    }
}
