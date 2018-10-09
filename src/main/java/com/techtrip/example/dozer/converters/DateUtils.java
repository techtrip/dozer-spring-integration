package com.techtrip.example.dozer.converters;

import java.time.*;
import java.util.Date;

public class DateUtils {

    public static LocalDateTime localDateTimeFromDate(Date source) {
        Instant instant = Instant.ofEpochMilli(source.getTime());
        LocalDateTime res = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        return res;
    }

    public static LocalDate localDateFromDate(Date source) {
        Instant instant = Instant.ofEpochMilli(source.getTime());
        LocalDate res = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
        return res;
    }

    public static LocalTime localTimeFromDate(Date source) {
        Instant instant = Instant.ofEpochMilli(source.getTime());
        LocalTime res = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalTime();
        return res;
    }

    public static Date dateFromLocalDateTime(LocalDateTime source) {
        Instant instant = source.atZone(ZoneId.systemDefault()).toInstant();
        Date res = Date.from(instant);
        return res;
    }

    public static Date dateFromLocalDate(LocalDate source) {
        Instant instant = source.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
        Date res = Date.from(instant);
        return res;
    }

    public static Date dateFromLocalTime(LocalTime source, int year, int month, int day) {
        Instant instant = source.atDate(LocalDate.of(year, month, day)).
                atZone(ZoneId.systemDefault()).toInstant();
        Date res = Date.from(instant);
        return res;
    }

    public static Date dateFromLocalTime(LocalTime source) {
        Instant instant = Instant.from(source);
        Date res = Date.from(instant);
        return res;
    }

}
