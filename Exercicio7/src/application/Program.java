package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        Date date;
        Product product = new Product();
        Product importedProduct = new ImportedProduct();
        Product productUsed = new UsedProduct();

        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Pruduct #" + (i + 1) + "data: ");
            System.out.print("Common, used or imported (c/u/i)? ");
            char ch = sc.next().charAt(0);

            switch (ch){
                case 'c':
                    System.out.print("\nName: ");
                    String name = sc.next();
                    System.out.print("\nPrice: ");
                    double price = sc.nextDouble();
                    product = new Product(name, price);
                    break;
                case 'i':
                    System.out.print("\nName: ");
                    String nameImp = sc.next();
                    System.out.print("\nPrice: ");
                    double priceImp = sc.nextDouble();
                    System.out.print("\nCustom Fee: ");
                    double customFee = sc.nextDouble();
                    importedProduct = new ImportedProduct(nameImp, priceImp, customFee);
                    break;
                case 'u':
                    System.out.print("\nName: ");
                    String nameUsed = sc.next();
                    System.out.print("\nPrice: ");
                    double priceUsed = sc.nextDouble();
                    System.out.print("\nManufactured Date: (DD/MM/YYYY): ");
                    date = sdf.parse(sc.next());
                    productUsed = new UsedProduct(nameUsed, priceUsed, date);
                    break;
                default:
                    System.out.println("\nInvalid input");
                    break;
            }
        }

        System.out.println("PRICE TAGS: ");
        System.out.println(product.priceTag() + "\n" + importedProduct.priceTag() + "\n" + productUsed.priceTag());
        sc.close();

    }
}