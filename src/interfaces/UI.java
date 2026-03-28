package interfaces;

import entidades.Operacao;
import java.util.Map;
import java.util.Set;

public class UI {

    public static void imprimir(Set<Operacao> operacoes) {
        System.out.printf("%-10s %-10s %-12s %-15s %-10s %-20s %-20s %n",
                "Agência", "Conta", "Banco", "Titular", "Operação", "Data/Hora", "Valor");
        for(Operacao o : operacoes){
            System.out.println(o);
        }
    }

    public static void imprimir(Map<String, Double> mapSaldoTitularFinal) {
        System.out.println("Saldo final por titular:");
        for (Map.Entry<String, Double> entry : mapSaldoTitularFinal.entrySet()) {
            String nome = entry.getKey();
            double saldo = entry.getValue();
            System.out.printf("%-20s R$ %.2f%n", nome, saldo);
        }
    }
}
