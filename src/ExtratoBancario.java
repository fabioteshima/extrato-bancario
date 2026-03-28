import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class ExtratoBancario {

    public static void main(String[] args) throws FileNotFoundException {

        String path = "operacoes_100.csv";
        Set<Operacao> operacoes = new HashSet<>();

        try(BufferedReader bf = new BufferedReader(new FileReader(path))){
            bf.readLine();
            String linha = bf.readLine();
            while(linha != null){
                String[] campos = linha.split(",");
                int agencia = Integer.parseInt(campos[0]);
                int conta = Integer.parseInt(campos[1]);
                String banco = campos[2];
                String titular = campos[3];
                String operacao = campos[4];
                LocalDateTime dataHora = LocalDateTime.parse(campos[5]);
                double valor = Double.parseDouble(campos[6]);
                Operacao op = new Operacao(agencia, conta, banco, titular, operacao, dataHora, valor);
                operacoes.add(op);
                linha = bf.readLine();
            }
        } catch(IOException e ){
            throw new RuntimeException(e.getMessage());
        }

        for(Operacao o : operacoes){
            System.out.println(o);
        }
        System.out.println();
    }
}
