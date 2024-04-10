package desafioIntermediario.entities;

public class Conta {

    private int idDono;
    private double saldo;
    private String senha;
    private String chaveTransferencia;

    private boolean status;

    public Conta(int dono, double saldo, String senha, String chaveTransferencia) {
        this.idDono = dono;
        this.saldo = saldo;
        this.senha = senha;
        this.chaveTransferencia = chaveTransferencia;
        this.status = true;
    }

    public int getDono() {
        return idDono;
    }

    public void setDono(int dono) {
        this.idDono = dono;
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
