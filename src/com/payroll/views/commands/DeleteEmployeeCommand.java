package com.payroll.views.commands;

import com.payroll.views.EmployeeView;

public class DeleteEmployeeCommand implements Command {

    @Override
    public boolean execute() {
        EmployeeView.deleteEmployee();
        return true;
    }
}
