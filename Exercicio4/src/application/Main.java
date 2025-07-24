package application;
import entities.Pessoas;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Pessoas[] p = new Pessoas[n];

        for (int i = 0; i < p.length; i++) {
            sc.nextLine();
            String nome = sc.nextLine();
            double altura = sc.nextDouble();
            int idade = sc.nextInt();
            p[i] = new Pessoas(nome, idade, altura);
        }
        double somaAltura = 0;
        for (int i = 0; i < p.length; i++) {
            somaAltura += p[i].getAltura();
        }

        double mediaAltura = somaAltura / n;
        int quantidadeMenores = 0;

        for (int i = 0; i < p.length; i++) {
            int x = p[i].getIdade();

            if (x < 17){
                quantidadeMenores++;
            }
        }
        double x = (double) (quantidadeMenores * 100) / n;

        System.out.printf("A média das alturas das pessoas é de: %.2f%n,A quantidade de pessoas com 16 anos ou menos é de: %.2f%n %n", mediaAltura, x);
    }
}