/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import modelo.bean.CardapioBean;
import modelo.bean.PagamentoBean;
import modelo.bean.RelatorioBean;
import modelo.bean.UsuarioBean;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author mathe
 */
public class Relatorio {
    private int ID;
    private Date dataEmissao;
    private Time horarioEmissao;
    private ArrayList<Pagamento> registroPagamentos;
    private Usuario gerador;
    private Cardapio cardapio;

    public Relatorio() {
        super();
    }

    public Relatorio(RelatorioBean relatorio) {
        this.setID(relatorio.getId());
        this.setDataEmissao(relatorio.getDataCriado());
        this.setCardapio(relatorio.getCardapioBean());
        this.setHorarioEmissao(relatorio.getHorarioCriado());
        this.setGerador(relatorio.getGerador());
        this.setRegistroPagamentos(relatorio.getPagamentos());
    }
    
    public Usuario getGerador() {
        return gerador;
    }

    public void setGerador(UsuarioBean gerador) {
        if (gerador!=null) {
            this.gerador = new Usuario(gerador);
        }else{
            throw new IllegalArgumentException("Usuario gerador invalido");
        }
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        if (dataEmissao!=null) {
            this.dataEmissao = dataEmissao;
        }else{
            throw new IllegalArgumentException("Data de emissao do relatorio invalida");
        }
        
    }

    public Time getHorarioEmissao() {
        return horarioEmissao;
    }

    public void setHorarioEmissao(Time horarioEmissao) {
        if (horarioEmissao!=null) {
            this.horarioEmissao = horarioEmissao;
        }else{
            throw new IllegalArgumentException("Horário de emissao do relatorio invalido");
        }
        
    }

    public ArrayList<Pagamento> getRegistroPagamentos() {
        return registroPagamentos;
    }

    public void setRegistroPagamentos(ArrayList<PagamentoBean> registroPagamentos) {
        if (registroPagamentos!=null) {
            this.registroPagamentos = new ArrayList<>();
            for (PagamentoBean registroPagamento : registroPagamentos) {
                this.registroPagamentos.add(new Pagamento(registroPagamento));
            }
        }else{
            throw new IllegalArgumentException("Lista de pagamentos inválida");
        }
        
    }

    public Cardapio getCardapio() {
        return cardapio;
    }

    public void setCardapio(CardapioBean cardapio) {
        this.cardapio = new Cardapio(cardapio);
    }
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
}
