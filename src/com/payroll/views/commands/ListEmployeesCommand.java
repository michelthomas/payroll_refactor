package com.payroll.views.commands;

import com.payroll.views.EmployeeView;

public class ListEmployeesCommand implements Command {

    @Override
    public boolean execute() {
        EmployeeView.listEmployees();
        return true;
    }
}
