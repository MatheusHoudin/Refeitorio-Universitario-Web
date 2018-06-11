/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import dao.UsuarioDAO;
import helper.Permissoes;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.TipoUsuario;
import modelo.Usuario;
import modelo.bean.LoginBean;
import modelo.bean.TipoUsuarioBean;
import modelo.bean.UsuarioBean;

/**
 *
 * @author mathe
 */
public class CadastrarClienteCommand implements Command{

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) {
        String nome = request.getParameter("nome");
        Integer matricula = Integer.parseInt(request.getParameter("matricula"));
        String email = request.getParameter("email");
        String tipoUsuario = request.getParameter("tipoUsuario");
        TipoUsuarioBean tuBean = getTipoUsuario(tipoUsuario);
        LoginBean lBean = getLoginBean(matricula);
        
        UsuarioBean usuarioBean = new UsuarioBean();
        usuarioBean.setNome(nome);
        usuarioBean.setEmail(email);
        usuarioBean.setCodigoIdentificador(matricula);
        usuarioBean.setLoginBean(lBean);
        usuarioBean.setTipoUsuarioBean(tuBean);
        usuarioBean.setCreditos(0.0);
        
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");
        if(usuario.getTipoUsuario().getPermissaoAdministrador().addUsuario(usuarioBean)){
            try {
                request.setAttribute("opcaoEscolhida", "listarCliente.jsp");
                request.getRequestDispatcher("principal.jsp").forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(CadastrarClienteCommand.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private TipoUsuarioBean getTipoUsuario(String tipoUsuario){
        TipoUsuarioBean tuBean = null;
        switch(tipoUsuario){
            case "Administrador":
                tuBean = new TipoUsuarioBean();
                tuBean.setNivelAcesso(Permissoes.ADMINISTRADOR);
                tuBean.setPrecoCredito(Permissoes.FUNCIONARIO);
                break;
            case "Nutricionista":
                tuBean = new TipoUsuarioBean();
                tuBean.setNivelAcesso(Permissoes.NUTRICIONISTA);
                tuBean.setPrecoCredito(Permissoes.FUNCIONARIO);
                break;
            case "Docente":
                tuBean = new TipoUsuarioBean();
                tuBean.setNivelAcesso(Permissoes.PROFESSOR);
                tuBean.setPrecoCredito(Permissoes.DOCENTE);
                break;
            case "AlunoResidente":
                tuBean = new TipoUsuarioBean();
                tuBean.setNivelAcesso(Permissoes.RESIDENTE);
                tuBean.setPrecoCredito(Permissoes.PRECO_RESIDENTE);
                break;
            case "AlunoNormal":
                tuBean = new TipoUsuarioBean();
                tuBean.setNivelAcesso(Permissoes.ALUNO_NORMAL);
                tuBean.setPrecoCredito(Permissoes.PRECO_ALUNO_NORMAL);
                break;
        }
        return tuBean;
    }
    
    private LoginBean getLoginBean(Integer matricula){
        String usuarioSenha = String.valueOf(matricula);
        LoginBean lBean = new LoginBean();
        lBean.setSenha(usuarioSenha);
        lBean.setUsuario(usuarioSenha);
        
        return lBean;
    }
}
