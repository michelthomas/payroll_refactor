package com.payroll.views.commands;

import com.payroll.views.EmployeeView;

public class RegisterTimeCardCommand implements Command {

    @Override
    public boolean execute() {
        EmployeeView.registerTimeCard();
        return true;
    }
}
