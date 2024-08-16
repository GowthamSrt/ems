package com.ideas2it.ems.util;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.Period;

public class DateUtil {

    public static String calculateAge(LocalDate dob) {
        return Period.between(dob, LocalDate.now()).getYears() + "y" + Period.between(dob, LocalDate.now()).getMonths() + "m";
    }
}
