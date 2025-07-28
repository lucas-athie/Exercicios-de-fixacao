package application;
import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;


public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.US);

        String name, department;
        double baseSalary;
        int contracts, hour;
        Date date;


        System.out.println("Enter department's name: ");
        department = sc.nextLine();

        System.out.println("Enter worker data: ");
        System.out.println("Name: ");
        name = sc.nextLine();
        System.out.println("Level:  ");
        String workerLevel = sc.nextLine();
        System.out.println("Base salary: ");
        baseSalary = sc.nextDouble();

        Worker worker = new Worker(baseSalary, name, new Department(department), WorkerLevel.valueOf(workerLevel));

        System.out.println("How many contracts to this worker? ");
        contracts = sc.nextInt();

        for (int i = 0; i < contracts; i++) {
            System.out.println("Enter contract " + (i + 1) + "data: ");
            System.out.println("Date (DD/MM/YYYY): ");
            date = sdf.parse(sc.next());
            System.out.println("Value per hour: ");
            double valuePerHour = sc.nextDouble();
            System.out.println("Duration (hours): ");
            hour = sc.nextInt();

            HourContract contract = new HourContract(date, valuePerHour, hour);
            worker.addContract(contract);
        }

        System.out.println("Enter month and year to calculate income (MM/YYYY): ");
        String monthAndYear = sc.next();
        int month = Integer.parseInt(monthAndYear.substring(0, 2));
        int year = Integer.parseInt(monthAndYear.substring(3));

        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName());
        System.out.println("Income for: " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));

        sc.close();
    }
}