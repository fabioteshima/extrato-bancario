package entidades;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Operacao implements Comparable<Operacao> {

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
        int comp = this.nomeTitular.compareTo(o.nomeTitular);
        if(comp == 0)
        {
            comp = this.dataHoraOperacao.compareTo(o.dataHoraOperacao);
        }
        return comp;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Operacao operacao)) return false;
        return numAgencia == operacao.numAgencia && numConta == operacao.numConta && Double.compare(valorOperacao, operacao.valorOperacao) == 0 && Objects.equals(nomeBanco, operacao.nomeBanco) && Objects.equals(nomeTitular, operacao.nomeTitular) && Objects.equals(tipoOperacao, operacao.tipoOperacao) && Objects.equals(dataHoraOperacao, operacao.dataHoraOperacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numAgencia, numConta, nomeBanco, nomeTitular, tipoOperacao, dataHoraOperacao, valorOperacao);
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String dataHora = dataHoraOperacao.format(dtf);

        return String.format("%-10d %-10d %-12s %-15s %-10s %-20s %-20.2f",
                numAgencia,
                numConta,
                nomeBanco,
                nomeTitular,
                tipoOperacao,
                dataHora,
                valorOperacao);

    }
}
