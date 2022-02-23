package com.payroll.models.payment.schedule;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

public class PaymentSchedule {

    private Integer exactDay;
    private int timesInTheMonth;
    private DayOfWeek dayOfWeek;
    private PaymentScheduleStrategy paymentScheduleStrategy;

    public PaymentSchedule(int timesInTheMonth, DayOfWeek dayOfWeek, PaymentScheduleStrategy paymentScheduleStrategy) {
        this(null, timesInTheMonth, dayOfWeek, paymentScheduleStrategy);
    }

    public PaymentSchedule(Integer exactDay, int timesInTheMonth, DayOfWeek dayOfWeek, PaymentScheduleStrategy paymentScheduleStrategy) {
        this.exactDay = exactDay;
        this.timesInTheMonth = timesInTheMonth;
        this.dayOfWeek = dayOfWeek;
        this.paymentScheduleStrategy = paymentScheduleStrategy;
    }


    public Integer getExactDay() {
        return exactDay;
    }

    public void setExactDay(int exactDay) {
        this.exactDay = exactDay;
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

    public PaymentScheduleStrategy getPaymentScheduleStrategy() {
        return paymentScheduleStrategy;
    }

    public void setPaymentScheduleStrategy(PaymentScheduleStrategy paymentScheduleStrategy) {
        this.paymentScheduleStrategy = paymentScheduleStrategy;
    }

    public List<Integer> getPaydaysInTheMonth() {
        return this.paymentScheduleStrategy.getPaydaysInTheMonth(this, LocalDate.now());
    }

}
