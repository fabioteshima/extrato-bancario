import java.time.LocalDateTime;

public class Operacao implements Comparable<Operacao>{

    private int numAgencia;
    private int numConta;
    private String nomeBanco;
    private String nomeTitular;
    private String tipoOperacao;
    private LocalDateTime dataHoraOperacao;
    private double valorOperacao;

    public Operacao(int agencia, int conta, String banco, String titular, String operacao, LocalDateTime dataHora, double valor) {
        this.numAgencia = agencia;
        this.numConta = conta;
        this.nomeBanco = banco;
        this.nomeTitular = titular;
        this.tipoOperacao = operacao;
        this.dataHoraOperacao = dataHora;
        this.valorOperacao = valor;
    }

    public int getAgencia() {
        return numAgencia;
    }

    public void setAgencia(int agencia) {
        this.numAgencia = agencia;
    }

    public int getConta() {
        return numConta;
    }

    public void setConta(int conta) {
        this.numConta = conta;
    }

    public String getBanco() {
        return nomeBanco;
    }

    public void setBanco(String banco) {
        this.nomeBanco = banco;
    }

    public String getTitular() {
        return nomeTitular;
    }

    public void setTitular(String titular) {
        this.nomeTitular = titular;
    }

    public String getOperacao() {
        return tipoOperacao;
    }

    public void setOperacao(String operacao) {
        this.tipoOperacao = operacao;
    }

    public LocalDateTime getDataHora() {
        return dataHoraOperacao;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHoraOperacao = dataHora;
    }

    public double getValor() {
        return valorOperacao;
    }

    public void setValor(double valor) {
        this.valorOperacao = valor;
    }

    @Override
    public int compareTo(Operacao o) {
        return o.dataHoraOperacao.compareTo(this.dataHoraOperacao);
    }

    @Override
    public String toString() {
        return String.format("%-10d%-10d%-10s%-20s%-10s%-10s%-10.2f", numAgencia, numConta, nomeBanco, nomeTitular, tipoOperacao, dataHoraOperacao, valorOperacao);
    }
}
