package br.memoria;

import java.util.ArrayList;

public class Registradores {

    private int id;
    private String registrador;
    private int valor;

    public Registradores(){

    }

    Registradores(int id, String registrador, int valor){

        this.id = id;
        this.registrador = registrador;
        this.valor = valor;

    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getId() {

        return id;
    }

    public String getRegistrador() {
        return registrador;
    }

    public int getValor() {
        return valor;
    }

    public ArrayList<Registradores> setMemoria(ArrayList<Registradores> registradores){

        registradores.add(new Registradores(0,"$zero",0));
        registradores.add(new Registradores(1,"$at",0));
        registradores.add(new Registradores(2,"$v0",0));
        registradores.add(new Registradores(3,"$v1",0));
        registradores.add(new Registradores(4,"$a0",0));
        registradores.add(new Registradores(5,"$a1",0));
        registradores.add(new Registradores(6,"$a2",0));
        registradores.add(new Registradores(7,"$a3",0));
        registradores.add(new Registradores(8,"$t0",0));
        registradores.add(new Registradores(9,"$t1",0));
        registradores.add(new Registradores(10,"$t2",0));
        registradores.add(new Registradores(11,"$t3",0));
        registradores.add(new Registradores(12,"$t4",0));
        registradores.add(new Registradores(13,"$t5",0));
        registradores.add(new Registradores(14,"$t6",0));
        registradores.add(new Registradores(15,"$t7",0));
        registradores.add(new Registradores(16,"$s0",0));
        registradores.add(new Registradores(17,"$s1",0));
        registradores.add(new Registradores(18,"$s2",0));
        registradores.add(new Registradores(19,"$s3",0));
        registradores.add(new Registradores(20,"$s4",0));
        registradores.add(new Registradores(21,"$s5",0));
        registradores.add(new Registradores(22,"$s6",0));
        registradores.add(new Registradores(23,"$s7",0));
        registradores.add(new Registradores(24,"$t8",0));
        registradores.add(new Registradores(25,"$t9",0));
        registradores.add(new Registradores(26,"$k0",0));
        registradores.add(new Registradores(27,"$k1",0));
        registradores.add(new Registradores(28,"$gp",0));
        registradores.add(new Registradores(29,"$sp",0));
        registradores.add(new Registradores(30,"$fp",0));
        registradores.add(new Registradores(31,"$ra",0));
        registradores.add(new Registradores(32,"$pc",0));
        registradores.add(new Registradores(33,"$hi",0));
        registradores.add(new Registradores(34,"$lo",0));

        return registradores;
    }
}
