package com.payroll.views.commands;

public class Invoker {

    private Command[] commands;

    public Invoker() {
        this.commands = new Command[]{
                new ListEmployeesCommand(),
                new RegisterEmployeeCommand(),
                new DeleteEmployeeCommand(),
                new RegisterTimeCardCommand(),
                new RegisterSaleResultCommand(),
                new RegisterAdditionalServiceFeeCommand(),
                new EditEmployeeMenuCommand(),
                new RunPayrollCommand()
        };
    }

    public boolean executeCommand(int option) {
        try {
            return this.commands[option].execute();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Opção inválida!\n");
            return true;
        }
    }

}
