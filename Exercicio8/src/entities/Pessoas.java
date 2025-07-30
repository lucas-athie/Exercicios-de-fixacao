package entities;

public abstract class Pessoas {
    protected String nome;
    protected Double rendaAnual;

    public Pessoas() {

    }

    public Pessoas(String nome, Double rendaAnual) {
        this.nome = nome;
        this.rendaAnual = rendaAnual;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getRendaAnual() {
        return rendaAnual;
    }

    public void setRendaAnual(Double rendaAnual) {
        this.rendaAnual = rendaAnual;
    }

    public abstract Double calcularImposto();
    @Override
    public abstract String toString();
}
