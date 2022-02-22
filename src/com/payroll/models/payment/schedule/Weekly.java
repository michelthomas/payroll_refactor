package com.payroll.models.payment.schedule;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Weekly implements PaymentSchedule {

    private int timesInTheMonth;
    private DayOfWeek dayOfWeek;

    public Weekly(int timesInTheMonth, DayOfWeek dayOfWeek) {
        this.timesInTheMonth = timesInTheMonth;
        this.dayOfWeek = dayOfWeek;
    }

    public int getTimesInTheMonth() {
        return timesInTheMonth;
    }

    public void setTimesInTheMonth(int timesInTheMonth) {
        this.timesInTheMonth = timesInTheMonth;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    @Override
    public List<Integer> getPaydaysInTheMonth() {
        return getPaydaysInTheMonthByDate(LocalDate.now());
    }

    @Override
    public List<Integer> getPaydaysInTheMonthByDate(LocalDate date) {

        ArrayList<Integer> paydaysList = new ArrayList<>();

        int firstDay = date.with(TemporalAdjusters.firstInMonth(this.dayOfWeek)).getDayOfMonth();

        for (int i = 0; i < this.timesInTheMonth; i++) {
            paydaysList.add(firstDay + (7 * i * 4 / this.timesInTheMonth));
        }
        return paydaysList;
    }

    @Override
    public String toString() {
        // TODO Change to pt-br
        return timesInTheMonth + " vezes no mês, em um dia de " +
                dayOfWeek.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
    }
}
