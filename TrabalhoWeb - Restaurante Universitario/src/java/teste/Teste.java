/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import dao.LoginDAO;
import modelo.bean.LoginBean;
import modelo.bean.UsuarioBean;

/**
 *
 * @author mathe
 */
public class Teste {
    public static void main(String[] args) {
        LoginBean loginBean = new LoginBean();
        loginBean.setUsuario("admin");
        loginBean.setSenha("123");
        UsuarioBean usuBean = LoginDAO.Search(loginBean);
        if(usuBean!=null){
            System.out.println("deu certo");
            System.out.println(usuBean.getNome());
        }else{
            System.out.println("SE FUDEU");
        }
    }
}
