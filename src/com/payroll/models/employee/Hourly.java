package com.payroll.models.employee;

import com.payroll.DB;
import com.payroll.models.payment.PaymentCheck;
import com.payroll.models.payment.PaymentInfo;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.UUID;

public class Hourly extends Employee {

    private Double hourlySalary;
    private List<TimeCard> timeCards;

    public Hourly(String documentNumber, String name, String address, Double hourlySalary) {
        this(documentNumber, name, address, hourlySalary,
                new PaymentInfo(DB.getInstance().paymentSchedules.get("semanal-1-sexta"),
                        DB.getInstance().paymentMethods.get("deposito"))
        );
    }

    public Hourly(UUID id, String documentNumber, String name, String address, Double hourlySalary) {
        this(id, documentNumber, name, address, hourlySalary,
                new PaymentInfo(DB.getInstance().paymentSchedules.get("semanal-1-sexta"),
                        DB.getInstance().paymentMethods.get("deposito"))
        );
    }

    public Hourly(String documentNumber, String name, String address, Double hourlySalary, PaymentInfo paymentInfo) {
        super(documentNumber, name, address, paymentInfo);
        this.hourlySalary = hourlySalary;
    }

    public Hourly(UUID id, String documentNumber, String name, String address, Double hourlySalary, PaymentInfo paymentInfo) {
        super(id, documentNumber, name, address, paymentInfo);
        this.hourlySalary = hourlySalary;
    }

    public Double getHourlySalary() {
        return hourlySalary;
    }

    public void setHourlySalary(Double hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    @Override
    public Double calculateGrossSalary(int payday) {
        if (this.getTimeCards() == null) {
            return 0.0;
        }

        LocalDate begin = this.getLastPaydayDateToCalculatePeriod();
        LocalDate end = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), payday);

        return this.getTimeCardsByDate(begin, end).stream().mapToDouble(timeCard -> {
            Double dailySalary = timeCard.getDailyHours() > 8 ?
                    (timeCard.getDailyHours() - 8) * this.hourlySalary * 1.5 + 8 * this.hourlySalary
                    : timeCard.getDailyHours() * this.hourlySalary;
            return dailySalary;
        }).sum();
    }

    public List<TimeCard> getTimeCards() {
        return timeCards;
    }

    public List<TimeCard> getTimeCardsByDate(LocalDate begin, LocalDate end) {
        return timeCards.stream().filter(timeCard -> {
            return (timeCard.getDate().isAfter(begin))
                    && (timeCard.getDate().isBefore(end) || timeCard.getDate().isEqual(end));
        }).toList();
    }

    public void setTimeCards(List<TimeCard> timeCards) {
        this.timeCards = timeCards;
    }

    @Override
    public String toString() {
        return "\nHourly{\n\t" +
                super.toString() +
                "\thourlySalary=" + hourlySalary +
                ", timeCards=" + timeCards +
                "\n}\n";
    }
}
