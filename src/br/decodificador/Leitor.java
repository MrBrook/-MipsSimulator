package br.decodificador;

import br.memoria.Instrucoes;
import br.memoria.Programa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Leitor {

    private  ArrayList<Programa> codigo = new ArrayList<Programa>();

    private Programa programa = new Programa( );

    public void leitorDados() throws IOException {

        String instrucao;
        String[] comando;

        BufferedReader arquivo = null;
        try {

            arquivo = new BufferedReader( new FileReader( "/home/lucas/Documentos/dados.txt" ) );

            while (arquivo.ready()) {

                instrucao = arquivo.readLine().replace( "("," " );
                instrucao = (instrucao.replace( ")"," " )).replace( ":","" );

                comando = instrucao.replace( ",","" ).split( " " );

                try {
                    interpretador( comando, true );
                } catch (EnumConstantNotPresentException a) {
                    interpretador( comando, false );
                }
            }
        } catch (Exception e) {
            System.out.println( e );
        } finally {
            arquivo.close();
        }
    }
    public void interpretador(String[] comando,boolean flag) {

        String op = "000000", rt,
                rs, rd = "00000", shamt = "00000", funct , offset ,label;

        if (comando[0].equalsIgnoreCase( "j" ) ) {

            op = decodificador( 6, comando[0] );
            label = decodificador( 26,buscaLabel( comando[1]) );

            codigo.add(programa.addCodigo( "",op , label.substring(0,5) , label.substring(5,10) ,
                    label.substring(10,15),label.substring(15,20),label.substring(20,26)));

        }else if(comando[0].equalsIgnoreCase( "jr" )) {

            funct = decodificador( 6, comando[0] );
            rs = decodificador( 6, comando[1] );

            codigo.add(programa.addCodigo( "","000000" , rs , "00000" , "00000" , "00000" , funct ));

        }else if (comando[0].equalsIgnoreCase( "lw" ) || comando[0].equalsIgnoreCase( "sw" )) {

            op = decodificador( 6,comando[0] );
            rs = decodificador(5,comando[3]);
            rt = decodificador(5,comando[1]);
            offset = decodificador( 16,comando[2] );

            codigo.add(programa.addCodigo( "",op , rs , rt , offset.substring(0, 5) ,offset.substring(5, 10)  , offset.substring(10, 16) ));

        } else if (comando[0].equalsIgnoreCase( "mult" ) || comando[0].equalsIgnoreCase( "div" )) {

            funct = decodificador( 6, comando[0] );
            rs = decodificador( 5, comando[1] );
            rt = decodificador( 5, comando[2] );

            codigo.add(programa.addCodigo( "",op , rs , rt , rd , shamt , funct ));

        } else if (comando[0].equalsIgnoreCase( "bne" ) || comando[0].equalsIgnoreCase( "beq" )) {

            op = decodificador( 6, comando[0] );
            rs = decodificador( 5, comando[1] );
            rt = decodificador( 5, comando[2] );
            label  = decodificador( 16,buscaLabel( comando[3]) );

            codigo.add(programa.addCodigo( "",op , rs , rt , label.substring(0,5) , label.substring(5,10) , label.substring(10,16)));

        } else if (comando[0].equalsIgnoreCase( "add" ) || comando[0].equalsIgnoreCase( "sub" )) {

            funct = decodificador( 6, comando[0] );
            rs = decodificador( 5, comando[2] );
            rt = decodificador( 5, comando[3] );
            rd = decodificador( 5, comando[1] );

            codigo.add(programa.addCodigo( "",op , rs , rt , rd , shamt , funct ));

        }else if(comando[0].equalsIgnoreCase( "blez" ) || comando[0].equalsIgnoreCase( "bgtz" )){

            op = decodificador( 6, comando[0] );
            rs = decodificador( 5, comando[1] );
            label = decodificador( 16,buscaLabel( comando[2]) );

            codigo.add(programa.addCodigo( "",op , rs , "00000" , label.substring(0,5) , label.substring(5,10) , label.substring(10,16) ));

        }else{ //label

            codigo.add(programa.addCodigo( comando[0],"" , "" , "" , "" , "" , "" ));
        }
    }

    private String decodificador(int controle,String comando) {

        try{
            return String.format("%"+controle+"s", Integer.toBinaryString(
                    Instrucoes.valueOf(comando).getIndice()) ).replace( ' ','0' );
        }catch (Exception a){
            return String.format("%"+controle+"s", Integer.toBinaryString(Integer.parseInt( comando))).replace( ' ','0' );
        }
    }

    private String buscaLabel(String label){

        for (int i=0;i<codigo.size();i++){
            if(codigo.get( i ).getLabel().equals(  label)) return Integer.toString(i);
        }

        return "-1";
    }

    public ArrayList <Programa> getCodigo() {
        return codigo;
    }
}
