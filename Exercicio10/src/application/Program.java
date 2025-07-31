package application;

import model.entities.Produto;
import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {

        String baseDir = System.getProperty("user.home")
                + "\\OneDrive - Fatec Centro Paula Souza\\Área de Trabalho\\exercicio10";
        String inputFilePath    = baseDir + "\\exercicio10.csv";
        String outDirPath       = baseDir + "\\out";
        String summaryFilePath  = outDirPath + "\\summary.csv";

        List<Produto> initialProdutos = Arrays.asList(
                new Produto("TV LED", 1290.99, 1),
                new Produto("Video Game Chair", 350.50, 3),
                new Produto("Samsung Galaxy 9", 850.00, 2)
        );

        try {
            File baseDirFile = new File(baseDir);
            if (!baseDirFile.exists()) {
                baseDirFile.mkdirs();
            }

            File inputFile = new File(inputFilePath);
            if (!inputFile.exists()) {
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(inputFile))) {
                    for (Produto p : initialProdutos) {
                        bw.write(p.toCsv());
                        bw.newLine();
                    }
                }
                System.out.println("Arquivo de entrada criado em: " + inputFilePath);
            }

            List<Produto> produtos = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(",");
                    String name       = data[0];
                    double valor      = Double.parseDouble(data[1]);
                    int quantidade    = Integer.parseInt(data[2]);
                    produtos.add(new Produto(name, valor, quantidade));
                }
            }

            File outDir = new File(outDirPath);
            if (!outDir.exists()) {
                outDir.mkdirs();
            }

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(summaryFilePath))) {
                for (Produto p : produtos) {
                    bw.write(p.getNome() + "," + p.valorTotal());
                    bw.newLine();
                }
                System.out.println("Arquivo summary.csv criado em: " + summaryFilePath);
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}