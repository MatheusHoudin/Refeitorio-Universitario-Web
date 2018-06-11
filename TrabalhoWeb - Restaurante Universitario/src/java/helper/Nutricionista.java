/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.util.ArrayList;
import modelo.InformacoesNutricionais;
import modelo.Ingrediente;
import modelo.OpcaoDiaria;
import modelo.Relatorio;
import java.util.Date;
import java.util.List;
import modelo.bean.IngredienteBean;

/**
 *
 * @author mathe
 */
public interface Nutricionista {
    public Boolean montarCardapio(List<OpcaoDiaria> opcoesDiarias);
    public Relatorio verRelatorioGeral(Date data);
    public Boolean criarOpcaoComida(String nome, String categoria,ArrayList<IngredienteBean> ingredientes);
    public Boolean criarIngrediente(String ingrediente);
    public Boolean criarInformacoesNutricionais();
    
}
