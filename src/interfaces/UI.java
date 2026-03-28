package interfaces;

import entidades.Operacao;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class UI {

    public static void imprimirTodasOperacoes(Set<Operacao> operacoes) {
        System.out.printf("%-10s %-10s %-12s %-15s %-10s %-20s %-20s %n",
                "Agência", "Conta", "Banco", "Titular", "Operação", "Data/Hora", "Valor");
        for(Operacao o : operacoes){
            System.out.println(o);
        }
    }

    public static void imprimirPorTitular(Map<String, List<Operacao>> mapOperacoes){
        for(Map.Entry<String, List<Operacao>> entry : mapOperacoes.entrySet()){
            String nome = entry.getKey();
            List<Operacao> operacoes = entry.getValue();
            System.out.printf("Titular: %-20s%n", nome);
            for(Operacao o : operacoes){
                System.out.println(o);
            }
            System.out.println();
        }
    }

    public static void imprimirSaldoFinal(Map<String, Double> mapSaldoTitularFinal) {
        for (Map.Entry<String, Double> entry : mapSaldoTitularFinal.entrySet()) {
            String nome = entry.getKey();
            double saldo = entry.getValue();
            System.out.printf("%-20s R$ %.2f%n", nome, saldo);
        }
    }
}
