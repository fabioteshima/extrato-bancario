package servicos;

import entidades.Operacao;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

public class ServicosOperacoes {

    public static int linhasLidas;

/*  Lê o arquivo e guarda no TreeSet todas as operações sem duplicidade e
  ordena os objetos de forma crescente por nome e data e hora da operação */
    public static Set<Operacao> getOperacoes(String path) {
        Set<Operacao> setOperacoes = new TreeSet<>();
        try(BufferedReader bf = new BufferedReader(new FileReader(path))){
            bf.readLine();
            String linha = bf.readLine();
            while(linha != null){
                linhasLidas++;
                Operacao op = ServicosOperacoes.getOperacao(linha);
                setOperacoes.add(op);
                linha = bf.readLine();
            }
        } catch(IOException e ){
            System.out.println("Arquivo não encontrado.");;
        }
        return setOperacoes;
    }

/*  Cria um objeto Operacao a partir de uma linha do arquivo */
    private static Operacao getOperacao (String linha) {
        String[] campo = linha.split(",");
        int numAgencia = Integer.parseInt(campo[0]);
        int numConta = Integer.parseInt(campo[1]);
        String nomeBanco = campo[2];
        String nomeTitular = campo[3];
        String tipoOperacao = campo[4];
        LocalDateTime dataHora = LocalDateTime.parse(campo[5]);
        double valor = Double.parseDouble(campo[6]);
        Operacao operacao = new Operacao(numAgencia, numConta, nomeBanco,
                nomeTitular, tipoOperacao, dataHora, valor);
        return operacao;
    }

/* Map para separar cada titular e suas respectivas operações */
    public static Map<String, List<Operacao>> getOperacaoPorTitular(Set<Operacao> operacoes) {
        Map<String, List<Operacao>> mapOperacoes = new TreeMap<>();
        for (Operacao op : operacoes) {
            String titular = op.getTitular();
            if (!mapOperacoes.containsKey(titular)) {
                mapOperacoes.put(titular, new ArrayList<>());
            }
            mapOperacoes.get(titular).add(op);
        }
        return mapOperacoes;
    }

/*  Calcula o saldo final de cada titular */
    public static Map<String, Double> getSaldoFinalTitular(Map<String, List<Operacao>> mapOperacoes) {
        Map<String, Double> mapSaldoTitularFinal = new TreeMap<>();
        for(Map.Entry<String, List<Operacao>> entry : mapOperacoes.entrySet()) {
            String nome = entry.getKey();
            double deposito = 0;
            double saque = 0;
            List<Operacao> operacao = entry.getValue();
            for (Operacao op : operacao) {
                if (op.getOperacao().equalsIgnoreCase("DEPOSITO")) {
                    deposito += op.getValor();
                }
                if (op.getOperacao().equalsIgnoreCase("SAQUE")) {
                    saque += op.getValor();
                }
            }
            mapSaldoTitularFinal.put(nome, deposito - saque);
        }
        return mapSaldoTitularFinal;
    }
}
