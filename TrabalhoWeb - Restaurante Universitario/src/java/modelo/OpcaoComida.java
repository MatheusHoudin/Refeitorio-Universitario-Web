/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import modelo.bean.InformacoesNutricionaisBean;
import modelo.bean.IngredienteBean;
import modelo.bean.OpcaoComidaBean;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mathe
 */
public class OpcaoComida {
    private int ID;
    private String nomeComida;
    private String categoria;
    private List<Ingrediente> ingredientes;

    public OpcaoComida() {
        super();
    }
    
    public OpcaoComida(OpcaoComidaBean opcBean) {
        this.setNomeComida(opcBean.getNomeComida());
        this.setCategoria(opcBean.getCategoria());
        this.setIngredientes(opcBean.getIngredientes());
    }

    public  String getNomeComida() {
        return nomeComida;
    }

    public void setNomeComida(String nomeComida) {
        if (nomeComida!=null) {
            this.nomeComida = nomeComida;
        }else{
            this.nomeComida="";
        }
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        if (categoria!=null) {
            this.categoria = categoria;
        }else{
            this.categoria="";
        }
        
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<IngredienteBean> ingredientes) {
        if(ingredientes!=null && ingredientes.size()>0){
            this.ingredientes = new ArrayList<>();
            for (IngredienteBean ingrediente : ingredientes) {
                this.ingredientes.add(new Ingrediente(ingrediente));
            }
        }else{
            throw new IllegalArgumentException("Ingredientes não foram expecificados");
        }
    }
    /**
     *
     * @return
     */
    public int getId(){
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "OpcaoComida{" + "ID=" + ID + ", nomeComida=" + nomeComida + ", categoria=" + categoria +'}';
    }
    
    
    
}
