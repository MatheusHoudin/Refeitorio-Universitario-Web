/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.bean;

/**
 *
 * @author mathe
 */
public class PagamentoBean {
    private int id;
    private VendaBean venda;
    private UsuarioBean cliente;
    
    public PagamentoBean(){
        
    }

    public VendaBean getVenda() {
        return venda;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setVenda(VendaBean venda) {
        this.venda = venda;
    }

    public UsuarioBean getCliente() {
        return cliente;
    }

    public void setCliente(UsuarioBean cliente) {
        this.cliente = cliente;
    }
}
