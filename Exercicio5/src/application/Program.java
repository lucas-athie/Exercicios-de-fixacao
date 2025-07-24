package application;

import entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Employee> funcionarios = new ArrayList<>();

        System.out.println("quantos funcionários serão registrados? ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Funcionário #" + (i + 1) + ":");
            System.out.println("Id: ");
            int id = sc.nextInt();
            System.out.println("Nome: ");
            sc.nextLine();
            String nome = sc.nextLine();
            System.out.println("Salario: ");
            double salario = sc.nextDouble();

            Employee emp = new Employee(id, nome, salario);
            funcionarios.add(emp);
        }

        System.out.println("Entre com o id do funcionário que terá o salário aumentado: ");
        double idEscolha = sc.nextDouble();

        Employee emp = funcionarios.stream().filter(x -> x.getId() == idEscolha).findFirst().orElse(null);

        if (emp == null) {
            System.out.println("funcionário não encontrado");
        } else {
            System.out.println("Entre com a porcentagem de aumneto de salario: ");
            double porcentagem = sc.nextDouble();
            emp.increaseSalary(porcentagem);
        }

        System.out.println("Lista de funcionários: ");
        for (Employee e : funcionarios) {
            System.out.println(e);
        }

        sc.close();
    }

}