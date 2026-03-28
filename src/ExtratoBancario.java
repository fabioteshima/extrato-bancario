import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExtratoBancario {

    public static void main(String[] args) throws FileNotFoundException {

        String path = "operacoes_100.csv";

        try(BufferedReader bf = new BufferedReader(new FileReader(path))){
            while(bf.ready()){
            String[] linha = bf.readLine().split(",");
                for(int i = 0; i < linha.length; i++){
                    System.out.print(linha[i] + " ");
                }
                System.out.println();
            }
        }
        catch(IOException e ){
            throw new RuntimeException(e.getMessage());
        }
    }
}
