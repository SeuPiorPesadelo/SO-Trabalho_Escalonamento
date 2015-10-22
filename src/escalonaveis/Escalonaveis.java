package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import model.Prioridade;
import model.Processo;

public class Escalonaveis {

    private static Scanner e = new Scanner(System.in);
    private static int timeLine;

    public static void main(String args[]) {

        int opcao = 666;
        while (opcao != 0) {

            System.out.println("ALGORITMOS DE ESCALONAMENTO");
            System.out.println("1 - FIFO");
            System.out.println("2 - PRIORIDADE");
            System.out.print("Escolha uma opção: ");
            opcao = e.nextInt();

            if (opcao == 1) {

                System.out.println("PROCESSOS POR FIFO");
                System.out.println("Quantos processos deseja criar ?");
                int numProc = e.nextInt();

                Processador cpu = new Processador();
                cpu.setQtd(numProc);

                ArrayList<Processo> p = new ArrayList<>();
                for (int i = 0; i < cpu.getQtd(); i++) {
                    System.out.println("Digite o nome do " + (i + 1) + "º processo");
                    String nomeProc = e.next();
                    System.out.println("Digite o Tempo de Execucao do Processo");
                    int timeProc = e.nextInt();
                    Processo proc = new Processo();
                    proc.setNome(nomeProc);
                    proc.setTempoExe(timeProc);
                    p.add(proc);
                }

                cpu.setProcessos(p);

                System.out.println("quantidade de processos na fila dos “prontos”: " + cpu.getProcessos().size());
                timeLine = 0;
                for (int i = 0; i < cpu.getProcessos().size(); i++) {
                    System.out.println("");
                    System.out.println((i + 1) + "° Processo INICIADO");
                    System.out.println("Tempo de execução do " + (i + 1) + "° processo: " + cpu.getProcessos().get(i).getTempoExe());
                    if (i == 0) {
                        System.out.println("Tempo que começou a ser executado: " + timeLine);
                    } else {
                        System.out.println("Tempo que começou a ser executado: " + (timeLine += cpu.getProcessos().get(i - 1).getTempoExe()));
                    }
                    System.out.println("Processo EXECUTADO");
                }
                int tempoTotal = 0;
                for (int i = 0; i < cpu.getProcessos().size(); i++) {
                    tempoTotal += cpu.getProcessos().get(i).getTempoExe();
                }
                System.out.println("Média de Tempo: " + (tempoTotal / (double) cpu.getProcessos().size()));
                //Prioridade           
            } else if (opcao == 2) {
                Processador cpu = new Processador();

                System.out.println("PROCESSOS POR PRIORIDADE");
                System.out.println("Quantos processos deseja criar ?");
                cpu.setQtd(e.nextInt());

                ArrayList<Processo> p = new ArrayList<>();
                for (int i = 0; i < cpu.getQtd(); i++) {
                    System.out.print("Digite o nome do " + (i + 1) + "º processo: ");
                    String nomeProc = e.next();
                    System.out.print("Digite o Tempo de Execucao do " + (i + 1) + "º Processo: ");
                    int timeProc = e.nextInt();
                    System.out.print("Digite a prioridade do " + (i + 1) + "º Processo: ");
                    int prioridadeN = e.nextInt();
                    System.out.println("");

                    Processo proc = new Processo();
                    proc.setNome(nomeProc);
                    proc.setTempoExe(timeProc);
                    proc.setPrioridade(prioridadeN);
                    p.add(proc);
                }
                Collections.sort(p);
                cpu.setProcessos(p);
                System.out.println("Quantidade de processos na fila dos “prontos”: " + cpu.getProcessos().size());

                timeLine = 0;
                for (int i = 0; i < cpu.getProcessos().size(); i++) {
                    System.out.println("");
                    System.out.println("Processo " + cpu.getProcessos().get(i).getNome()
                            + " de Prioridade " + cpu.getProcessos().get(i).getPrioridade() + " INICIADO");
                    System.out.println("Tempo de execução do " + cpu.getProcessos().get(i).getNome() + ": "
                            + cpu.getProcessos().get(i).getTempoExe());
                    if (i == 0) {
                        System.out.println("Tempo que começou a ser executado: " + timeLine);
                    } else {
                        System.out.println("Tempo que começou a ser executado: " + (timeLine += cpu.getProcessos().get(i - 1).getTempoExe()));
                    }
                    System.out.println("Processo EXECUTADO");
                }
                int tempoTotal = 0;
                for (int i = 0; i < cpu.getProcessos().size(); i++) {
                    tempoTotal += cpu.getProcessos().get(i).getTempoExe();
                }
                System.out.println("");
                System.out.println("Média de tempo: " + (tempoTotal / (double) cpu.getProcessos().size()));
            } else {
                System.out.println("Escolha um opção valida!!!");
            }
        }
    }
}
