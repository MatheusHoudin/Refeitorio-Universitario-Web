/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Usuario;
import modelo.bean.IngredienteBean;
import modelo.bean.OpcaoComidaBean;

/**
 *
 * @author mathe
 */
public class CadastrarOpcaoComidaCommand implements Command {

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) {
        String nome = request.getParameter("nome");
        String categoria = request.getParameter("categoria");
        String[] ingredientes = request.getParameterValues("ingredientes");
        OpcaoComidaBean opcComida = new OpcaoComidaBean();
        opcComida.setCategoria(categoria);
        opcComida.setNomeComida(categoria);
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");
        try{
            if(usuario.getTipoUsuario().getPermissaoNutricionista()!=null){
                ArrayList<IngredienteBean> ingredientesBean = getIngredientesBean(ingredientes);

                if(usuario.getTipoUsuario().getPermissaoNutricionista().criarOpcaoComida(nome, categoria,ingredientesBean )){
                    request.getRequestDispatcher("principal.jsp").forward(request, response);
                }
            }else{
               request.getRequestDispatcher("paginaErro.jsp").forward(request, response);
            }
        }catch (ServletException | IOException ex) {
            Logger.getLogger(CadastrarOpcaoComidaCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    private ArrayList<IngredienteBean> getIngredientesBean(String[] ingredientes){
        ArrayList<IngredienteBean> ing = new ArrayList<>();
        for(int i=0;i<ingredientes.length;i++){
            IngredienteBean  in = new IngredienteBean();
            in.setId(Integer.parseInt(ingredientes[i]));
            ing.add(in);
        }
        
        return ing;
    }
    
}
