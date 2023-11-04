package com.pluralsight;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class FormatDates {
    public static void main(String[] args) {
        //Testing in local time
        LocalDateTime today = LocalDateTime.now();
        System.out.println(today);
        DayOfWeek dayOfWeek = DayOfWeek.from(today);
        System.out.println(dayOfWeek);

        //Format Month/Day/Year
        DateTimeFormatter MDY = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formattedMDY = today.format(MDY);
        System.out.println(formattedMDY);
        DateTimeFormatter YMD = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedYMD = today.format(YMD);
        System.out.println(formattedYMD);
        DateTimeFormatter monthDY = DateTimeFormatter.ofPattern("MMM dd, yyyy");
        String formattedMonthDY = today.format(monthDY);
        System.out.println(formattedMonthDY);
        DateTimeFormatter time = DateTimeFormatter.ofPattern("hh:mm");
        String formattedTime = today.format(time);
        System.out.println(dayOfWeek + formattedMonthDY + formattedTime.clone(ZoneId.of("GMT")));

    }
}
