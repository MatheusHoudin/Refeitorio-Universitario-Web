/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.bean;

import modelo.InformacoesNutricionais;
import modelo.Ingrediente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mathe
 */
public class OpcaoComidaBean {
    private int id;
    private String nomeComida;
    private String categoria;
    private ArrayList<IngredienteBean> ingredientes;
    
    public OpcaoComidaBean(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeComida() {
        return nomeComida;
    }

    public void setNomeComida(String nomeComida) {
        this.nomeComida = nomeComida;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public List<IngredienteBean> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(ArrayList<IngredienteBean> ingredientes) {
        this.ingredientes = ingredientes;
    }
    
    
}
