package applications;
import entities.PessoaFisica;
import entities.PessoaJuridica;
import entities.Pessoas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Pessoas juridica = new PessoaJuridica();
        Pessoas fisica = new PessoaFisica();
        Scanner sc = new Scanner(System.in);

        List<Pessoas> pessoas = new ArrayList<>();

        System.out.println("Enter the number of tax payer: ");
        int payer = sc.nextInt();
        sc.nextLine();

        for(int i = 1; i <= payer; i++) {
            System.out.println("Tax payer # " + i + ": ");
            System.out.println("Individual or company (i/c) ? ");
            String type = sc.nextLine();

            System.out.println("Name: ");
            String nome = sc.nextLine();
            System.out.println("Anual income: ");
            double rendaAnual = sc.nextDouble();
            sc.nextLine();

            if(type.equals("c")) {
                System.out.println("Number of employees: ");
                int funcionarios = sc.nextInt();
                sc.nextLine();
                pessoas.add(juridica = new PessoaJuridica(nome, rendaAnual, funcionarios));
            }else if(type.equals("i")) {
                System.out.println("Health Expenditures: ");
                double gastosSaude = sc.nextDouble();
                sc.nextLine();
                pessoas.add(fisica = new PessoaFisica(nome, rendaAnual, gastosSaude));
            } else{
                System.out.println("Option dont't exist! ");
                break;
            }
        }
        System.out.println("TAX PAID: ");
        for(Pessoas p : pessoas) {
            System.out.println(p);
        }
        sc.close();
    }
}