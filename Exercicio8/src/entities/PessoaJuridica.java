package entities;

public final class PessoaJuridica extends Pessoas{
    private int funcionarios;

    public PessoaJuridica(int funcionarios) {
        this.funcionarios = funcionarios;
    }
    public PessoaJuridica() {

    }

    public PessoaJuridica(String nome, Double rendaAnual, int funcionarios) {
        super(nome, rendaAnual);
        this.funcionarios = funcionarios;
    }

    public int getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(int funcionarios) {
        this.funcionarios = funcionarios;
    }

    @Override
    public Double calcularImposto() {
        if(funcionarios > 10){
            return rendaAnual * 0.14;
        } else{
            return rendaAnual * 0.16;
        }
    }

    public String toString(){
        return nome + " $" + String.format("%.2f",calcularImposto());
    }
}
