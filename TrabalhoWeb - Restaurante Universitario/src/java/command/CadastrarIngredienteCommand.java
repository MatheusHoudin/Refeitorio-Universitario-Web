/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import dao.IngredienteDAO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.bean.InformacoesNutricionaisBean;
import modelo.bean.IngredienteBean;

/**
 *
 * @author mathe
 */
public class CadastrarIngredienteCommand implements Command {

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) {
        String nome = request.getParameter("nome");
        Double gramas = Double.valueOf(request.getParameter("gramas"));
        Double proteinas = Double.valueOf(request.getParameter("proteinas"));
        Double lipidios = Double.valueOf(request.getParameter("lipidios"));
        String lactosa = request.getParameter("lactose");
        Boolean lactose = verificaLactose(lactosa);
        IngredienteBean ing = criarIngredienteBean(nome, gramas, proteinas, lipidios, lactose);
        
        IngredienteDAO.add(ing);
        try {
            request.getRequestDispatcher("principal.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(CadastrarIngredienteCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private boolean verificaLactose(String valorLactose){
        return valorLactose.equals("sim");
    }
    
    private IngredienteBean criarIngredienteBean(String nome,Double gramas,
            Double proteinas,Double lipidios,Boolean lactosa){
        IngredienteBean ingBean = new IngredienteBean();
        ingBean.setNome(nome);
        InformacoesNutricionaisBean inf = new InformacoesNutricionaisBean();
        inf.setLactosa(lactosa);
        inf.setLipidios(lipidios);
        inf.setQuantidadeProteinas(proteinas);
        inf.setPorcaoGramas(gramas);
        
        ingBean.setInformacoesNutricionaisBean(inf);
        
        return ingBean;
    }
}
