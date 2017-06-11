import br.decodificador.Leitor;
import br.memoria.Programa;
import br.memoria.Registradores;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        Registradores registradores = new Registradores();
        Leitor ler = new Leitor();

        ArrayList <Registradores> registrador = new ArrayList <Registradores>();
        ArrayList<Programa> dados = new ArrayList <Programa>(  );

        registrador = registradores.setMemoria(registrador);

         //System.out.println(registrador.get( 6 ).getRegistrador());

       ler.leitorDados();
       dados = ler.getCodigo();

        for (int i = 0; i < dados.size(); i++) {
            System.out.println(dados.get( i ).getLabel()+" "+
                    dados.get( i).getOp()+" "+dados.get( i).getRs()+" "+dados.get( i).getRt()+" "+dados.get( i ).getRd()+" "+dados.get( i ).getShamt()+" "+dados.get( i ).getFunct());
        }
    }
}
