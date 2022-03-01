package com.payroll.views;

import com.payroll.controllers.SyndicatesController;
import com.payroll.exceptions.EmployeeDoesNotBelongToTheSyndicateException;
import com.payroll.models.employee.Employee;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeView extends View {

    public static SyndicatesController syndicatesController = new SyndicatesController();

    public static void listEmployees() {

        List<Employee> employeeList = employeesController.index();

        System.out.println("Lista de Empregados:");

        for (Employee employee : employeeList) {
            System.out.println(employee);
        }

        System.out.println("---------------------------");
    }

    public static void registerEmployee(){

        Map<String, String> data = new HashMap<>();

        System.out.println("Digite o nome:");
        data.put("name", scanner.nextLine());

        System.out.println("Digite o número do documento:");
        data.put("documentNumber", scanner.nextLine());

        System.out.println("Digite o endereço:");
        data.put("address", scanner.nextLine());

        System.out.println("Digite o tipo:");
        System.out.println("1 - Horista\n2 - Assalariado\n3 - Comissionado");
        String type = scanner.nextLine();
        data.put("type", type);

        switch (Integer.parseInt(type)) {
            case 1:
                System.out.println("Digite o valor da hora:");
                data.put("hourlySalary", scanner.nextLine());
                break;
            case 2:
                System.out.println("Digite o salário:");
                data.put("salary", scanner.nextLine());
                break;
            case 3:
                System.out.println("Digite o salário base:");
                data.put("baseSalary", scanner.nextLine());
                System.out.println("Digite a porcentagem:");
                data.put("percentage", scanner.nextLine());
                break;
        }

        employeesController.store(data);

        System.out.println("---------------------------");
    }

    public static void deleteEmployee() {

        List<Employee> employeeList = employeesController.index();

        printEmployeeNumberedList(employeeList);

        System.out.println("\nSelecione o empregado que será removido: ");
        int n = Integer.parseInt(scanner.nextLine());

        employeesController.delete(employeeList.get(n).getId());

        System.out.println("---------------------------");
    }

    public static void registerTimeCard() {

        Map<String, String> data = new HashMap<>();

        List<Employee> employeeList = employeesController.getHourlyEmployees();

        System.out.println("Lista de Empregados:");

        int i = 0;
        for (Employee employee : employeeList) {
            System.out.println("[" + i + "] - " + employee.getName() + " - " + employee.getId());
            i++;
        }

        System.out.println("\nSelecione o empregado para submeter o cartão de ponto:");
        String n = scanner.nextLine();

        System.out.println("Digite a data do cartão de ponto:");
        data.put("date", scanner.nextLine());

        System.out.println("Digite a quantidade de horas trabalhadas: ");
        data.put("dailyHours", scanner.nextLine());

        employeesController.registerTimeCard(employeeList.get(Integer.parseInt(n)), data);

        System.out.println("---------------------------");
    }

    public static void registerSalesResult() {

        Map<String, String> data = new HashMap<>();

        List<Employee> employeeList = employeesController.getCommissionedEmployees();

        System.out.println("Lista de Empregados:");

        int i = 0;
        for (Employee employee : employeeList) {
            System.out.println("[" + i + "] - " + employee.getName() + " - " + employee.getId());
            i++;
        }

        System.out.println("\nSelecione o empregado para submeter o resultado de vendas:");
        String n = scanner.nextLine();

        System.out.println("Digite a data da venda:");
        data.put("date", scanner.nextLine());

        System.out.println("Digite o valor da venda: ");
        data.put("value", scanner.nextLine());

        employeesController.registerSalesResult(employeeList.get(Integer.parseInt(n)), data);

        System.out.println("---------------------------");
    }

    public static void registerAdditionalServiceFee() {
        Map<String, String> data = new HashMap<>();

        List<Employee> employeeList = employeesController.index();

        printEmployeeNumberedList(employeeList);

        System.out.println("\nSelecione o empregado para lançar uma taxa de serviço:");
        String n = scanner.nextLine();

        System.out.println("Descrição: ");
        String description = scanner.nextLine();

        System.out.println("Valor: ");
        Double fee = Double.valueOf(scanner.nextLine());

        System.out.println("Data: ");
        String date = scanner.nextLine();

        try {
            syndicatesController.registerAdditionalServiceFee(employeeList.get(Integer.parseInt(n)).getDocumentNumber(), description, fee, date);
        } catch (EmployeeDoesNotBelongToTheSyndicateException e) {
            System.out.println("Não foi possível lançar a taxa de serviço: " + e.getMessage());
        }

        System.out.println("---------------------------");
    }
}
