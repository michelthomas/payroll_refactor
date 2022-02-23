package com.payroll.views.commands;

import com.payroll.views.EditEmployeeView;

public class EditEmployeeMenuCommand implements Command {

    @Override
    public boolean execute() {
        EditEmployeeView.menu();
        return true;
    }
}
