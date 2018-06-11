/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import dao.OpcaoComidaDAO;
import java.util.ArrayList;
import modelo.InformacoesNutricionais;
import modelo.Ingrediente;
import modelo.OpcaoDiaria;
import modelo.Relatorio;
import java.util.Date;
import java.util.List;
import modelo.bean.IngredienteBean;
import modelo.bean.OpcaoComidaBean;

/**
 *
 * @author mathe
 */
public class PermissaoNutricionista implements Nutricionista {

    @Override
    public Boolean montarCardapio(List<OpcaoDiaria> opcoesDiarias) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Relatorio verRelatorioGeral(Date data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean criarIngrediente(String ingrediente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean criarInformacoesNutricionais() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean criarOpcaoComida(String nome, String categoria, ArrayList<IngredienteBean> ingredientes) {
        OpcaoComidaBean opc = new OpcaoComidaBean();
        opc.setNomeComida(nome);
        opc.setCategoria(categoria);
        opc.setIngredientes(ingredientes);
        return OpcaoComidaDAO.Add(opc);
    }

   

  
    
}
