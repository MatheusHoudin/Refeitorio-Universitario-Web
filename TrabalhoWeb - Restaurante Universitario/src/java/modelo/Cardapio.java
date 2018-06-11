/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import modelo.bean.CardapioBean;
import modelo.bean.OpcaoDiariaBean;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author mathe
 */
public class Cardapio {
    private int ID;
    private Date dataInicial;
    private Date dataFinal;
    private ArrayList<OpcaoDiaria> opcoesDiarias;

    Cardapio(CardapioBean cardapio) {
        this.setID(cardapio.getId());
        this.setDataInicial(cardapio.getDataInicial());
        this.setDataFinal(cardapio.getDataFinal());
        this.setOpcoesDiarias(cardapio.getOpcoesDiarias());
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        if (dataInicial!=null) {
            this.dataInicial = dataInicial;
        }else{
            throw new IllegalArgumentException("Data inválida");
        }
        
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        if (dataFinal!=null) {
            this.dataFinal = dataFinal;
        }else{
            throw new IllegalArgumentException("Data inválida");
        }
    }

    public ArrayList<OpcaoDiaria> getOpcoesDiarias() {
        return opcoesDiarias;
    }

    public void setOpcoesDiarias(ArrayList<OpcaoDiariaBean> opcoesDiarias) {
        if (opcoesDiarias!=null) {
            this.opcoesDiarias = new ArrayList<>();
            for (OpcaoDiariaBean opcoesDiaria : opcoesDiarias) {
                this.opcoesDiarias.add(new OpcaoDiaria(opcoesDiaria));
            }
        }else{
            throw new IllegalArgumentException("Opções diárias vazias");
        }
        
    }
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "Cardapio{" + "ID=" + ID + ", dataInicial=" + dataInicial + ", dataFinal=" + dataFinal + ", opcoesDiarias=" + opcoesDiarias +'}';
    }
    
    
}
