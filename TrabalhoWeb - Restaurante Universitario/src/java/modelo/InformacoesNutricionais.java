/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import modelo.bean.InformacoesNutricionaisBean;

/**
 *
 * @author mathe
 */
public class InformacoesNutricionais {
    private int ID;
    private Double porcaoGramas;
    private Double quantidadeProteinas;
    private Boolean comidaLactosa;
    private Double quantidadeLipidio;

    public InformacoesNutricionais(){
        super();
    }
    public InformacoesNutricionais(InformacoesNutricionaisBean infoNutri) {
        this.setPorcaoGramas(infoNutri.getPorcaoGramas());
        this.setQuantidadeProteinas(infoNutri.getQuantidadeProteinas());
        this.setComidaLactosa(infoNutri.getLactosa());
        this.setQuantidadeLipidio(infoNutri.getLipidios());
        this.setID(infoNutri.getId());
    }

    public Double getPorcaoGramas() {
        return porcaoGramas;
    }

    public void setPorcaoGramas(Double porcaoGramas) {
        this.porcaoGramas = porcaoGramas;
    }

    public Double getQuantidadeProteinas() {
        return quantidadeProteinas;
    }

    public void setQuantidadeProteinas(Double quantidadeProteinas) {
        this.quantidadeProteinas = quantidadeProteinas;
    }

    public Boolean getComidaLactosa() {
        return comidaLactosa;
    }

    public void setComidaLactosa(Boolean comidaLactosa) {
        this.comidaLactosa = comidaLactosa;
    }

    public Double getQuantidadeSodio() {
        return quantidadeLipidio;
    }


    public void setQuantidadeLipidio(Double quantidadeLipidio) {
        if (quantidadeLipidio>0) {
           this.quantidadeLipidio = quantidadeLipidio; 
        }  
    } 
    
    public int getID() {
        return ID;
    }

    private void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "InformacoesNutricionais{" + "ID=" + ID + ", porcaoGramas=" + porcaoGramas + ", quantidadeProteinas=" + quantidadeProteinas + ", comidaLactosa=" + comidaLactosa + ", quantidadeLipidio=" + quantidadeLipidio +  '}';
    }
    
    

}
