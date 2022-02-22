package com.payroll.models.employee;

import com.payroll.DB;
import com.payroll.models.payment.PaymentCheck;
import com.payroll.models.payment.PaymentInfo;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.UUID;

public class Commissioned extends Employee {

    private Double baseSalary;
    private Double percentage;
    private List<SaleResult> salesResults;

    public Commissioned(String documentNumber, String name, String address, Double baseSalary, Double percentage) {
        this(documentNumber, name, address, baseSalary, percentage,
                new PaymentInfo(DB.getInstance().paymentSchedules.get("semanal-2-sexta"),
                        DB.getInstance().paymentMethods.get("deposito"))
        );
    }

    public Commissioned(UUID id, String documentNumber, String name, String address, Double baseSalary, Double percentage) {
        this(id, documentNumber, name, address, baseSalary, percentage,
                new PaymentInfo(DB.getInstance().paymentSchedules.get("semanal-2-sexta"),
                        DB.getInstance().paymentMethods.get("deposito"))
        );
    }

    public Commissioned(String documentNumber, String name, String address, Double baseSalary, Double percentage, PaymentInfo paymentInfo) {
        super(documentNumber, name, address, paymentInfo);
        this.baseSalary = baseSalary;
        this.percentage = percentage;
    }

    public Commissioned(UUID id, String documentNumber, String name, String address, Double baseSalary, Double percentage, PaymentInfo paymentInfo) {
        super(id, documentNumber, name, address, paymentInfo);
        this.baseSalary = baseSalary;
        this.percentage = percentage;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    public List<SaleResult> getSalesResults() {
        return salesResults;
    }

    public List<SaleResult> getSalesResultsByDate(LocalDate begin, LocalDate end) {
        return salesResults.stream().filter(saleResult -> {
            return (saleResult.getDate().isAfter(begin))
                    && (saleResult.getDate().isBefore(end) || saleResult.getDate().isEqual(end));
        }).toList();
    }

    public void setSalesResults(List<SaleResult> salesResults) {
        this.salesResults = salesResults;
    }

    @Override
    public Double calculateGrossSalary(int payday) {
        if (this.getSalesResults() == null) {
            return baseSalary;
        }

        LocalDate begin = this.getLastPaydayDateToCalculatePeriod();
        LocalDate end = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), payday);

        Double sumSalesResults = this.getSalesResultsByDate(begin, end).stream().mapToDouble(SaleResult::getValue).sum();

        return (this.baseSalary / this.getPaymentInfo().getSchedule().getPaydaysInTheMonth().size()) +
                (sumSalesResults * (this.percentage / 100));
    }

    @Override
    public String toString() {
        return "\nCommissioned{\n\t" +
                super.toString() +
                "\tbaseSalary=" + baseSalary +
                ", percentage=" + percentage +
                ", salesResults=" + salesResults +
                "\n}\n";
    }
}
