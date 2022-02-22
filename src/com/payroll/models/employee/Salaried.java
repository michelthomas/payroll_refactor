package com.payroll.models.employee;

import com.payroll.DB;
import com.payroll.models.payment.PaymentInfo;

import java.util.UUID;

public class Salaried extends Employee {

    private Double monthlySalary;

    public Salaried(String documentNumber, String name, String address, Double monthlySalary) {
        this(documentNumber, name, address, monthlySalary,
                new PaymentInfo(DB.getInstance().paymentSchedules.get("mensal-$"),
                        DB.getInstance().paymentMethods.get("deposito"))
        );
    }

    public Salaried(UUID id, String documentNumber, String name, String address, Double monthlySalary) {
        this(id, documentNumber, name, address, monthlySalary,
                new PaymentInfo(DB.getInstance().paymentSchedules.get("mensal-$"),
                        DB.getInstance().paymentMethods.get("deposito"))
        );
    }

    public Salaried(String documentNumber, String name, String address, Double monthlySalary, PaymentInfo paymentInfo) {
        super(documentNumber, name, address, paymentInfo);
        this.monthlySalary = monthlySalary;
    }

    public Salaried(UUID id, String documentNumber, String name, String address, Double monthlySalary, PaymentInfo paymentInfo) {
        super(id, documentNumber, name, address, paymentInfo);
        this.monthlySalary = monthlySalary;
    }

    public Double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(Double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    @Override
    public Double calculateGrossSalary(int payday) {
        return this.monthlySalary / this.getPaymentInfo().getSchedule().getPaydaysInTheMonth().size();
    }

    @Override
    public String toString() {
        return "\nSalaried{\n\t" +
                super.toString() +
                "\tmonthlySalary=" + monthlySalary +
                "\n}\n";
    }
}
