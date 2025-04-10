package org.lol.entity;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoPeriod;
import java.time.temporal.TemporalUnit;
//import java.time.temporal.ChronoUnit;

public record Birthday(LocalDate birthday) {
    public long getAge() {
        return (birthday.getYear() - LocalDate.now().getYear());
    }
}
