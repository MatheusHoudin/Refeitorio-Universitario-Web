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
public class IngredienteBean {
    private int id;
    private String nome;
    private InformacoesNutricionaisBean informacoesNutricionaisBean;
    public IngredienteBean(){
        
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public InformacoesNutricionaisBean getInformacoesNutricionaisBean() {
        return informacoesNutricionaisBean;
    }

    public void setInformacoesNutricionaisBean(InformacoesNutricionaisBean informacoesNutricionaisBean) {
        this.informacoesNutricionaisBean = informacoesNutricionaisBean;
    }
    
}
