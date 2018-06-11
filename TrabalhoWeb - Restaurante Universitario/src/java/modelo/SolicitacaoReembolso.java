/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import modelo.bean.SolicitacaoReembolsoBean;
import modelo.bean.UsuarioBean;
import java.sql.Time;
import java.util.Date;

/**
 *
 * @author mathe
 */
public class SolicitacaoReembolso {
    private int id;
    private Usuario usuario;
    private Date date;
    private Time horario;

    public SolicitacaoReembolso(SolicitacaoReembolsoBean srb) {
        this.setDate(srb.getDate());
        this.setHorario(srb.getHorario());
        this.setId(srb.getId());
        this.setUsuario(srb.getUsuario());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioBean usuario) {
        if(usuario != null){
            this.usuario = new Usuario(usuario);
        }  
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        if(date != null){
            this.date = date;
        }
    }

    public Time getHorario() {
        return horario;
    }

    public void setHorario(Time horario) {
        if(horario != null){
            this.horario = horario;
        }  
    }
    
    
}
