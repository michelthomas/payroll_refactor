package com.payroll.models.payment.schedule;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class LastWorkingDayOfTheMonth implements PaymentScheduleStrategy {

    @Override
    public List<Integer> getPaydaysInTheMonth(PaymentSchedule paymentSchedule, LocalDate date) {

        int lastDayOfMonth;

        if (date.getMonth() == Month.FEBRUARY && !date.isLeapYear()) {
            lastDayOfMonth = 28;
        } else {
            lastDayOfMonth = date.getMonth().maxLength();
        }

        DayOfWeek dayOfWeek = LocalDate.of(date.getYear(), date.getMonth(), lastDayOfMonth).getDayOfWeek();

        switch (dayOfWeek) {
            case SUNDAY -> lastDayOfMonth -= 2;
            case SATURDAY -> lastDayOfMonth -= 1;
        }

        ArrayList<Integer> paydays = new ArrayList<>();
        paydays.add(lastDayOfMonth);

        return paydays;
    }

    @Override
    public String toString(PaymentSchedule paymentSchedule) {
        return "Último dia útil do mês, dia " + this.getPaydaysInTheMonth(paymentSchedule, LocalDate.now()).get(0);
    }
}
