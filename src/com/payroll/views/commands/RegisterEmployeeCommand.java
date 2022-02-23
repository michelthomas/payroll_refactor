package com.payroll.views.commands;

import com.payroll.views.EmployeeView;

public class RegisterEmployeeCommand implements Command {

    @Override
    public boolean execute() {
        EmployeeView.registerEmployee();
        return true;
    }
}
