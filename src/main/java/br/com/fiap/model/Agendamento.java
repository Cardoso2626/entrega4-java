package br.com.fiap.model;

import java.util.Scanner;

public class Agendamento {
    private long id;
    private Orcamento orcamento;
    private String dataHorario;

    public Agendamento() {
    }

    public Agendamento(Orcamento orcamento) {
        this.orcamento = orcamento;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



    public String getDataHorario() {
        return dataHorario;
    }

    public void setDataHorario(String dataHorario) {
        this.dataHorario = dataHorario;


    }




    public Orcamento getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(Orcamento orcamento) {
        this.orcamento = orcamento;
    }

    //Método de marcar horário;
    public void marcaHorario() {
        Scanner tec = new Scanner(System.in);
        System.out.println("Insira o dia e o horário que deseja agendar, do jeito que preferir: ");
        String hora = tec.nextLine();
        setDataHorario(hora);
    }


}
