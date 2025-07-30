package entities;

public final class PessoaFisica extends Pessoas{

    private Double gastosSaude;

    public PessoaFisica() {
    }

    public PessoaFisica(String nome, Double rendaAnual, double gastosSaude) {
        super(nome, rendaAnual);
        this.gastosSaude = gastosSaude;
    }

    public Double getGastosSaude() {
        return gastosSaude;
    }

    public void setGastosSaude(Double gastosSaude) {
        this.gastosSaude = gastosSaude;
    }

    public Double valorTaxa() {
        double imposto;
        if(rendaAnual < 20000) {
            imposto = 0.15;
        }else{
            imposto = 0.25;
        }
        return imposto;
    }

    @Override
    public Double calcularImposto() {
        if(gastosSaude != null) {
            return rendaAnual*valorTaxa() - gastosSaude/2 ;
        }else{
            return rendaAnual*valorTaxa();
        }
    }

    @Override
    public String toString() {
        return nome + " $" +String.format("%.2f",calcularImposto());
    }
}
