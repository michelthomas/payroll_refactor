package com.payroll.models.payment.method;

public class BankCheckHand implements PaymentMethod {

    @Override
    public String getDescription() {
        return "Cheque em mãos.";
    }

    @Override
    public String toString() {
        return this.getDescription();
    }
}
