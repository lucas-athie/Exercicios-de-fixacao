package entities;

public class Conta {
    private String nome;
    private int id;
    private double saldo;

    public Conta(String nome, int id, double saldo) {
        this.nome = nome;
        this.id = id;
        depositar(saldo);
    }
    public Conta(String nome, int id) {
        this.nome = nome;
        this.id = id;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void depositar(double valor) {
        this.saldo += valor;
    }
    public void sacar(double valor) {
        this.saldo -= valor + 5;
    }

    @Override
    public String toString() {
        return nome
                + " - "
                + saldo
                +" - "
                + id;
    }
}
