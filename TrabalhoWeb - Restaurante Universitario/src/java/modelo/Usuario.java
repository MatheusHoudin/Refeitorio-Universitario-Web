/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import modelo.bean.LoginBean;
import modelo.bean.TipoUsuarioBean;
import modelo.bean.UsuarioBean;

/**
 *
 * @author mathe
 */
public class Usuario {
    private int ID;
    private String nome;
    private String email;
    private Integer codIdentificador;
    private Double creditos;
    private Login login;
    private TipoUsuario tipoUsuario;

    public Usuario(UsuarioBean usuario) {
        this.setCodIdentificador(usuario.getCodigoIdentificador());
        this.setID(usuario.getId());
        this.setCreditos(usuario.getCreditos());
        this.setNome(usuario.getNome());
        this.setEmail(usuario.getEmail());
        this.setLogin(usuario.getLoginBean());
        this.setTipoUsuario(usuario.getTipoUsuarioBean());
    }
    
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome!=null) {
            this.nome = nome;
        }else{
            throw new IllegalArgumentException("Nome inválido");
        }
        
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email!=null) {
            this.email = email;
        }else{
            throw new IllegalArgumentException("Email inválido");
        }
    }

    public Integer getCodIdentificador() {
        return codIdentificador;
    }

    public void setCodIdentificador(Integer codIdentificador) {
        if (codIdentificador!=null) {
            this.codIdentificador = codIdentificador;
        }else{
            throw new IllegalArgumentException("Identificador inválido");
        }
    }

    public Double getCreditos() {
        return creditos;
    }

    public void setCreditos(Double creditos) {
        if(creditos<0){
            throw new IllegalArgumentException("Créditos abaixo de zero");
        }else{
            this.creditos = creditos;
        } 
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(LoginBean login) {
        if (login!=null) {
            this.login = new Login(login);
        }else{
            throw new IllegalArgumentException("Login inválido");
        }
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuarioBean tipoUsuario) {
        if (tipoUsuario!=null) {
           this.tipoUsuario = new TipoUsuario(tipoUsuario); 
        }else{
            throw new IllegalArgumentException("Tipo de usuário inválido");
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
        return "Usuario{" + "ID=" + ID + ", nome=" + nome + ", email=" + email + ", codIdentificador=" + codIdentificador + ", creditos=" + creditos + ", login=" + login +  ", tipoUsuario=" + tipoUsuario + '}';
    }
    
    public UsuarioBean gerarBean(){
        UsuarioBean ub = new UsuarioBean();
        ub.setId(ID);
        ub.setNome(nome);
        ub.setEmail(email);
        ub.setCodigoIdentificador(codIdentificador);
        ub.setCreditos(creditos);
        ub.setLoginBean(login.gerarBean());
        return ub;
    }
}
