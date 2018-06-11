/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import modelo.bean.InformacoesNutricionaisBean;
import modelo.bean.IngredienteBean;

/**
 *
 * @author mathe
 */
public class Ingrediente  {
    private int id;
    private String nomeComida;
    private InformacoesNutricionais informacoesNutricionais;

    public Ingrediente(IngredienteBean ingrediente) {
        this.setNomeComida(ingrediente.getNome());
        this.setId(ingrediente.getId());
        this.setInformacoesNutricionais(ingrediente.getInformacoesNutricionaisBean());
    }

    public InformacoesNutricionais getInformacoesNutricionais() {
        return informacoesNutricionais;
    }

    public void setInformacoesNutricionais(InformacoesNutricionaisBean informacoesNutricionais) {
        this.informacoesNutricionais = new InformacoesNutricionais(informacoesNutricionais);
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
        if(nomeComida != null){
           this.nomeComida = nomeComida; 
        }
    }  
}
