package com.payroll.views;

import com.payroll.controllers.EmployeesController;
import com.payroll.models.employee.Employee;

import java.util.List;
import java.util.Scanner;

public abstract class View {


    public static Scanner scanner = new Scanner(System.in);
    public static EmployeesController employeesController = new EmployeesController();

    public static void printEmployeeNumberedList(List<Employee> employeeList) {

        System.out.println("Lista de Empregados:");

        int i = 0;
        for (Employee employee : employeeList) {
            System.out.println("[" + i + "] - " + employee.getName() + " - " + employee.getId());
            i++;
        }

        System.out.println("---------------------------");
    }

}
