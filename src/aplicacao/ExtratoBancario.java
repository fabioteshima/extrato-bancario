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
        System.out.println("Operações não duplicadas e ordenadas por titular e data/hora:");
        UI.imprimirTodasOperacoes(operacoes);
        System.out.println();

        System.out.println("Número inicial de operações lidas: " + ServicosOperacoes.linhasLidas);
        System.out.println("Número final de operações: " + operacoes.size());
        System.out.println();

        Map<String, List<Operacao>> mapOpercaoesPorTitular = ServicosOperacoes.getOperacaoPorTitular(operacoes);
        System.out.println("Operações por titular:");
        UI.imprimirPorTitular(mapOpercaoesPorTitular);


        Map<String, Double> mapSaldoFinalTitular = ServicosOperacoes.getSaldoFinalTitular(mapOpercaoesPorTitular);
        System.out.println("Saldo final por titular:");
        UI.imprimirSaldoFinal(mapSaldoFinalTitular);
    }
}
