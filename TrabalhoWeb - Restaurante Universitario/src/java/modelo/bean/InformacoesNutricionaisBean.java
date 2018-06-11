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
public class InformacoesNutricionaisBean {
    private int id;
    private Double quantidadeProteinas;
    private Boolean lactosa;
    private Double lipidios;
    private Double porcaoGramas;
    
    public InformacoesNutricionaisBean(){
        
    }

    public Double getQuantidadeProteinas() {
        return quantidadeProteinas;
    }

    public void setQuantidadeProteinas(Double quantidadeProteinas) {
        this.quantidadeProteinas = quantidadeProteinas;
    }

    public Boolean getLactosa() {
        return lactosa;
    }

    public void setLactosa(Boolean lactosa) {
        this.lactosa = lactosa;
    }

    public Double getLipidios() {
        return lipidios;
    }

    public void setLipidios(Double lipidios) {
        this.lipidios = lipidios;
    }

    public Double getPorcaoGramas() {
        return porcaoGramas;
    }

    public void setPorcaoGramas(Double porcaoGramas) {
        this.porcaoGramas = porcaoGramas;
    }

    public int getId() {
       return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
