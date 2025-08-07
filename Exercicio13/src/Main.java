import model.entities.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome!");

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o caminho do arquivo: ");
        String path = sc.nextLine();

        try(BufferedReader br = new BufferedReader(new FileReader(path))) {

            List<Employee> list = new ArrayList<>();

            String linha = br.readLine();
            while(linha != null) {
                String[] data = linha.split(",");
                list.add(new Employee(data[0], data[1], Double.parseDouble(data[2])));
                linha = br.readLine();

            }

            System.out.println("Enter Salary: ");
            double salary = sc.nextDouble();

            List<String> emails = list.stream()
                    .filter(p -> p.getSalary() > salary)
                    .map(p -> p.getEmail())
                    .sorted()
                    .collect(Collectors.toList());

            emails.forEach(System.out::println);

            String word = "M";

            double names = list.stream()
                    .filter(p -> p.getName().startsWith(word))
                    .mapToDouble(p -> p.getSalary())
                    .reduce(0.0, (x,y) -> x + y);

            System.out.println("Sum of salary of people whose name starts with '" + word + "': " + names);

        }
        catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
        sc.close();
    }
}