package com.payroll.views.commands;

import com.payroll.views.EmployeeView;

public class RegisterAdditionalServiceFeeCommand implements Command {

    @Override
    public boolean execute() {
        EmployeeView.registerAdditionalServiceFee();
        return true;
    }
}
