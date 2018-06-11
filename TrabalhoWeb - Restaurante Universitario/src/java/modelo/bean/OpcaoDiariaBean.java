/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.bean;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author mathe
 */
public class OpcaoDiariaBean {
    private int id;
    private ArrayList<OpcaoComidaBean> opcoesComida;
    private Date dataRefeicao;
    private String diaSemana;
    private String turno;
    public OpcaoDiariaBean(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataRefeicao() {
        return dataRefeicao;
    }

    public void setDataRefeicao(Date dataRefeicao) {
        this.dataRefeicao = dataRefeicao;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public ArrayList<OpcaoComidaBean> getOpcoesComida() {
        return opcoesComida;
    }

    public void setOpcoesComida(ArrayList<OpcaoComidaBean> opcoesComida) {
        this.opcoesComida = opcoesComida;
    }

    public String getTurno() {
        return this.turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
    
    
}
