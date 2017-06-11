package br.memoria;

public class Programa {

    private int indice=0;
    private String label;
    private String op,rs,rt,rd,shamt,funct;

    public Programa(){

    }

   public Programa(int indice,String label, String op, String rs, String rt, String rd, String shamt,String funct){
        this.indice = indice;
        this.label = label;
        this.op = op;
        this.rs = rs;
        this.rt = rt;
        this.rt = rt;
        this.rd = rd;
        this.shamt = shamt;
        this.funct = funct;
    }

    public Programa addCodigo(String label,String op,String rs,String rt,String rd,String shamt,String funct){

        Programa a  = new Programa(indice,label,op, rs, rt, rd, shamt, funct );
        indice++;

        return a;
    }

    public int getIndice() {

        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public String getRs() {
        return rs;
    }

    public void setRs(String rs) {
        this.rs = rs;
    }

    public String getRt() {
        return rt;
    }

    public void setRt(String rt) {
        this.rt = rt;
    }

    public String getRd() {
        return rd;
    }

    public void setRd(String rd) {
        this.rd = rd;
    }

    public String getShamt() {
        return shamt;
    }

    public void setShamt(String shamt) {
        this.shamt = shamt;
    }

    public String getFunct() {
        return funct;
    }

    public void setFunct(String funct) {
        this.funct = funct;
    }
}
