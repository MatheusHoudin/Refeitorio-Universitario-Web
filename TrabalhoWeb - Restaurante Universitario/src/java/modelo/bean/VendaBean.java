/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.bean;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author mathe
 */
public class VendaBean {
    private int ID;
    private UsuarioBean vendedor;
    private Date dataVenda;
    private Time horarioVenda;
    private Double valorVenda;
    
    public VendaBean(){
        
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public UsuarioBean getVendedor() {
        return vendedor;
    }

    public void setVendedor(UsuarioBean vendedor) {
        this.vendedor = vendedor;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Time getHorarioVenda() {
        return horarioVenda;
    }

    public void setHorarioVenda(Time horarioVenda) {
        this.horarioVenda = horarioVenda;
    }

    public Double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(Double valorVenda) {
        this.valorVenda = valorVenda;
    }
    
    
            
}
