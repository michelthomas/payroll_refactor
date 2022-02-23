package com.payroll;

import com.payroll.views.commands.Invoker;

import java.util.Scanner;

public class Menu {


    public static Scanner scanner = new Scanner(System.in);

    public static void show() {
        System.out.println("0. Listar todos os empregados");
        System.out.println("1. Adição de um empregado");
        System.out.println("2. Remoção de um empregado");
        System.out.println("3. Lançar um Cartão de Ponto");
        System.out.println("4. Lançar um resultado de venda");
        System.out.println("5. Lançar uma taxa de serviço");
        System.out.println("6. Alterar detalhes de um empregado");
        System.out.println("7. Rodar a folha de pagamento");
        System.out.println("8. Sair");

        Invoker invoker = new Invoker();

        if (invoker.executeCommand(Integer.parseInt(scanner.nextLine()))) {
            show();
        }
    }

}
