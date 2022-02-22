package com.payroll.models.employee;

import com.payroll.models.payment.PaymentCheck;
import com.payroll.models.payment.PaymentInfo;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

public abstract class Employee {

    private UUID id;
    private String documentNumber;
    private String name;
    private String address;
    private PaymentInfo paymentInfo;
    private List<PaymentCheck> paymentChecks;

    public Employee(String documentNumber, String name, String address, PaymentInfo paymentInfo) {
        this(UUID.randomUUID(), documentNumber, name, address, paymentInfo);
    }

    public Employee(UUID id, String documentNumber, String name, String address, PaymentInfo paymentInfo) {
        this.id = id;
        this.documentNumber = documentNumber;
        this.name = name;
        this.address = address;
        this.paymentInfo = paymentInfo;
    }

    public UUID getId() {
        return this.id;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public abstract Double calculateGrossSalary(int payday);

    public PaymentInfo getPaymentInfo() {
        return this.paymentInfo;
    }

    public void setPaymentInfo(PaymentInfo paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public List<PaymentCheck> getPaymentChecks() {
        return paymentChecks;
    }

    public void setPaymentChecks(List<PaymentCheck> paymentChecks) {
        this.paymentChecks = paymentChecks;
    }

    public PaymentCheck getLastPaymentCheck() {
        if (this.paymentChecks == null) {
            return null;
        }
        return this.paymentChecks.stream()
                .max(Comparator.comparing(PaymentCheck::getDate))
                .orElse(null);
    }

    public LocalDate getLastPaydayDateToCalculatePeriod() {
        if (this.paymentChecks == null) {
            // If there are no paychecks, decrease one day to count from the first of the month
            return  LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), 1).minusDays(1);
        }

        return this.getLastPaymentCheck().getDate();
    }

    @Override
    public String toString() {
        return "Employee{\n\t\t" +
                "id=" + id +
                ", documentNumber='" + documentNumber + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", paymentInfo=" + paymentInfo +
                ", paymentChecks=" + paymentChecks +
                "}\n";
    }
}
