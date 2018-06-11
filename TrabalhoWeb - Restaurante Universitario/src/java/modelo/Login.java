/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import modelo.bean.LoginBean;

/**
 *
 * @author mathe
 */
public class Login {
    private int ID;
    private String usuario;
    private String senha;

    public Login() {
        super();
    }

    public Login(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    Login(LoginBean login) {
        this.setID(login.getId());
        this.setSenha(login.getSenha());
        this.setUsuario(login.getUsuario());
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        if(usuario!=null){
            this.usuario = usuario;
        }else{
            usuario = "";
        }
        
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        if (senha!=null) {
            this.senha = senha;
        }else{
            this.senha = "";
        }
        
    }
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "Login{" + "ID=" + ID + ", usuario=" + usuario + ", senha=" + senha + '}';
    }
    
    public  LoginBean gerarBean(){
        LoginBean lb = new LoginBean();
        lb.setId(ID);
        lb.setSenha(senha);
        lb.setUsuario(usuario);
        return lb;
    }
}
