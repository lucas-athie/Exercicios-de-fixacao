import entities.Conta;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String nome, opcao;
        int id;
        double saldo, valor;
        Conta conta;
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite seu nome: ");
        nome = sc.nextLine();
        System.out.println("Digite o número da conta: ");
        id = sc.nextInt();
        sc.nextLine();
        System.out.println("Deseja realizar um depósito inicial?  (y/n)");
        opcao = sc.nextLine();

        if (opcao.equals("y")) {
            System.out.println("Qual o valor que deseja depositar? ");
            saldo = sc.nextDouble();
            conta = new Conta(nome, id, saldo);

        } else {
            System.out.println("Tudo bem");
            conta = new Conta(nome, id);
        }
        
        System.out.println("Entre com um valor de depósito: ");
        valor = sc.nextDouble();
        conta.depositar(valor);

        System.out.println("Entre com um valor de saque: ");
        valor = sc.nextDouble();
        conta.sacar(valor);

        System.out.println(conta);

        sc.close();
    }
}