package br.com.fiap.util;

import br.com.fiap.model.Agendamento;
import br.com.fiap.model.Orcamento;

public class AgendamentoTo {
    private long id;
    private Orcamento orcamento;
    private String dataHorario;


    public Agendamento toAgendamento(){
        Agendamento a = new Agendamento();
        a.setId(id);
        a.setOrcamento(orcamento);
        a.setDataHorario(dataHorario);
        return a;
    }

    public long getId() {

        return id;
    }

    public void setId(long id) {

        this.id = id;
    }

    public Orcamento getOrcamento() {

        return orcamento;
    }

    public void setOrcamento(Orcamento orcamento) {

        this.orcamento = orcamento;
    }

    public String getDataHorario() {

        return dataHorario;
    }

    public void setDataHorario(String dataHorario) {

        this.dataHorario = dataHorario;
    }
}
