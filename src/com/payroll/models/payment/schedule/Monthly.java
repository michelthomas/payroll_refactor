package com.payroll.models.payment.schedule;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Monthly implements PaymentScheduleStrategy {

    @Override
    public List<Integer> getPaydaysInTheMonth(PaymentSchedule paymentSchedule, LocalDate date) {
        ArrayList<Integer> paydays = new ArrayList<>();
        paydays.add(paymentSchedule.getExactDay());
        return paydays;
    }

    @Override
    public String toString(PaymentSchedule paymentSchedule) {
        return "Mensalmente, no dia " + paymentSchedule.getExactDay();
    }
}
