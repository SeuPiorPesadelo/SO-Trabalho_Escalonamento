/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author marcus.rodrigues
 */
public class Processo implements Comparable<Processo>{

    private String nome;
    private int tempoExe;
    private int prioridade;

    public Processo() {
    }

    public Processo(String nome, int tempoExe) {
        this.nome = nome;
        this.tempoExe = tempoExe;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTempoExe() {
        return tempoExe;
    }

    public void setTempoExe(int tempoExe) {
        this.tempoExe = tempoExe;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Tempo Execucao:" + tempoExe;
    }

    @Override
    public int compareTo(Processo o) {
        if(this.prioridade < o.prioridade){
            return -1;
        }else if (this.prioridade > o.prioridade) {
            return 1;
        }else {
            return 0;
        }
    }
}
