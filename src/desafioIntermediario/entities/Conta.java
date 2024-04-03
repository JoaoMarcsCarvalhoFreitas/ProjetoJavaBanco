package desafioIntermediario.entities;

public class Conta {

    private Cliente dono;
    private double saldo;
    private String senha;
    private String chaveTransferencia;

    private boolean status;

    public Conta(Cliente dono, double saldo, String senha, String chaveTransferencia) {
        this.dono = dono;
        this.saldo = saldo;
        this.senha = senha;
        this.chaveTransferencia = chaveTransferencia;
        this.status = true;
    }

    public Cliente getDono() {
        return dono;
    }

    public void setDono(Cliente dono) {
        this.dono = dono;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getChaveTransferencia() {
        return chaveTransferencia;
    }

    public void setChaveTransferencia(String chaveTransferencia) {
        this.chaveTransferencia = chaveTransferencia;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
