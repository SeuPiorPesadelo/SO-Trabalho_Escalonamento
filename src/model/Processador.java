
package model;

import java.util.ArrayList;


public class Processador {

    private int qtd;
    private ArrayList<Processo> processos;

    public Processador() {
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public ArrayList<Processo> getProcessos() {
        return processos;
    }

    public void setProcessos(ArrayList<Processo> processos) {
        this.processos = processos;
    }


    @Override
    public String toString() {
        return "Quantidade de Processos" + qtd + ", Processos=" + processos;
    }
}

