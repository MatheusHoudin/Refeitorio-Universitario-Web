/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import modelo.bean.PagamentoBean;
import modelo.bean.UsuarioBean;
import modelo.bean.VendaBean;

/**
 *
 * @author mathe
 */
public class Pagamento {

    private int ID;
    private Venda venda;
    private Usuario cliente;

    public Pagamento() {
        super();
    }
    
    public Pagamento(PagamentoBean pagamento) {
        this.setVenda(pagamento.getVenda());
        this.setCliente(pagamento.getCliente());
        this.setID(pagamento.getId());
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(VendaBean venda) {
        if (venda!=null) {
             this.venda = new Venda(venda);
        }else{
            throw new IllegalArgumentException("Venda invalida");
        }
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(UsuarioBean cliente) {
        if (cliente!=null) {
            this.cliente = new Usuario(cliente);
        }else{
            throw new IllegalArgumentException("Cliente invalido");
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
        return "Pagamento{" + "ID=" + ID + ", venda=" + venda +  ", cliente=" + cliente + '}';
    }
    
    
}
