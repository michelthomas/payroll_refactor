package com.payroll.models.payment.schedule;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Weekly implements PaymentScheduleStrategy {

    @Override
    public List<Integer> getPaydaysInTheMonth(PaymentSchedule paymentSchedule, LocalDate date) {

        ArrayList<Integer> paydaysList = new ArrayList<>();

        int firstDay = date.with(TemporalAdjusters.firstInMonth(paymentSchedule.getDayOfWeek())).getDayOfMonth();

        for (int i = 0; i < paymentSchedule.getTimesInTheMonth(); i++) {
            paydaysList.add(firstDay + (7 * i * 4 / paymentSchedule.getTimesInTheMonth()));
        }
        return paydaysList;
    }

    @Override
    public String toString(PaymentSchedule paymentSchedule) {
        // TODO Change to pt-br
        return paymentSchedule.getTimesInTheMonth() + " vezes no mês, em um dia de " +
                paymentSchedule.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
    }
}
