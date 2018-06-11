/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.bean;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author mathe
 */
public class RelatorioBean {
    private int id;
    private Date dataCriado;
    private Time horarioCriado;
    private UsuarioBean gerador;
    private CardapioBean cardapioBean;
    private ArrayList<PagamentoBean> pagamentos;
    
    public RelatorioBean(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataCriado() {
        return dataCriado;
    }

    public void setDataCriado(Date dataCriado) {
        this.dataCriado = dataCriado;
    }

    public Time getHorarioCriado() {
        return horarioCriado;
    }

    public void setHorarioCriado(Time horarioCriado) {
        this.horarioCriado = horarioCriado;
    }

    public UsuarioBean getGerador() {
        return gerador;
    }

    public void setGerador(UsuarioBean gerador) {
        this.gerador = gerador;
    }

    public CardapioBean getCardapioBean() {
        return cardapioBean;
    }

    public void setCardapioBean(CardapioBean cardapioBean) {
        this.cardapioBean = cardapioBean;
    }

    public ArrayList<PagamentoBean> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(ArrayList<PagamentoBean> pagamentos) {
        this.pagamentos = pagamentos;
    }
    
    
}
