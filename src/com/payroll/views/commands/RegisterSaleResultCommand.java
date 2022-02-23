package com.payroll.views.commands;

import com.payroll.views.EmployeeView;

public class RegisterSaleResultCommand implements Command {

    @Override
    public boolean execute() {
        EmployeeView.registerSalesResult();
        return true;
    }
}
