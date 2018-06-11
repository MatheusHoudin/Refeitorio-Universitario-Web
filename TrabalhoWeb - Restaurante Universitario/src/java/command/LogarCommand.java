/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import dao.LoginDAO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Usuario;
import modelo.bean.LoginBean;
import modelo.bean.UsuarioBean;

/**
 *
 * @author mathe
 */
public class LogarCommand implements Command {

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) {
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        LoginBean loginBean = new LoginBean();
        loginBean.setUsuario(login);
        loginBean.setSenha(senha);
        UsuarioBean usuBean = LoginDAO.Search(loginBean);
        
        try{
            if(usuBean!=null){
                Usuario usuario = new Usuario(usuBean);
                String permissao = getPermissao(usuario);
                request.getSession().setAttribute("permissao", permissao);
                request.getSession().setAttribute("usuarioLogado", usuario);
                request.getRequestDispatcher("principal.jsp").forward(request, response);
            }else{
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } catch (ServletException | IOException ex) {
            Logger.getLogger(LogarCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private String getPermissao(Usuario usu){
        String permissao = null;
        switch(usu.getTipoUsuario().getNivelAcesso()){
            case 1:
                permissao = "opcoesAdministrador.jsp";
                break;
            case 2:
                permissao = "opcoesCliente.jsp";
                break;
            case 3:
                permissao = "opcoesCliente.jsp";
                break;
            case 4:
                permissao = "opcoesCliente.jsp";
                break;
            case 5:
                permissao = "opcoesNutricionista.jsp";
                break;
        }
        return permissao;
    }
    
}
