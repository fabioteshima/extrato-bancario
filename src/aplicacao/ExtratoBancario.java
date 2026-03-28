package aplicacao;

import entidades.Operacao;
import servicos.ServicosOperacoes;
import interfaces.UI;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ExtratoBancario {

    public static void main(String[] args) throws FileNotFoundException {

        String path = "operacoes_100.csv";

        Set<Operacao> operacoes = ServicosOperacoes.getOperacoes(path);
        UI.imprimir(operacoes);
        System.out.println();
        System.out.println("Número inicial de operações lidas: " + ServicosOperacoes.linhasLidas);
        System.out.println("Número final de operações: " + operacoes.size());
        System.out.println();
        Map<String, List<Operacao>> mapOpercaoesPorTitular = ServicosOperacoes.getOperacaoPorTitular(operacoes);
        Map<String, Double> mapSaldoFinalTitular = ServicosOperacoes.getSaldoFinalTitular(mapOpercaoesPorTitular);
        UI.imprimir(mapSaldoFinalTitular);
    }
}
