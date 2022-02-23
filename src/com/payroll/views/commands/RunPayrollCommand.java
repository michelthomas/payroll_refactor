package com.payroll.views.commands;

import com.payroll.views.EditEmployeeView;

public class RunPayrollCommand implements Command {

    @Override
    public boolean execute() {
        EditEmployeeView.runPayroll();
        return true;
    }
}
