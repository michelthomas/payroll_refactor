package com.payroll.models.payment.schedule;

import java.time.LocalDate;
import java.util.List;

public interface PaymentScheduleStrategy {

    List<Integer> getPaydaysInTheMonth(PaymentSchedule paymentSchedule, LocalDate date);

    String toString(PaymentSchedule paymentSchedule);
}
