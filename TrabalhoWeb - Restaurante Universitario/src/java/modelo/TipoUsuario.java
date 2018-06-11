/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import modelo.bean.TipoUsuarioBean;
import helper.Administrador;
import helper.Cliente;
import helper.Nutricionista;
import helper.PermissaoAdministrador;
import helper.PermissaoCliente;
import helper.PermissaoNutricionista;
import helper.Permissoes;
import helper.Vendedor;

/**
 *
 * @author mathe
 */
public class TipoUsuario {
    private int ID;
    private Integer nivelAcesso;
    private Double precoCredito;
    private Administrador permissaoAdministrador;
    private Cliente permissaoCliente;
    private Nutricionista permissaoNutricionista;
    private Vendedor permissaoVendedor;

    public TipoUsuario(TipoUsuarioBean tub) {
        this.setID(tub.getId());
        this.setNivelAcesso(tub.getNivelAcesso());
        this.setPermissoes();
    }
    
    

    public Integer getNivelAcesso() {
        return nivelAcesso;
    }

    private void setNivelAcesso(Integer nivelAcesso) {
        if (nivelAcesso!=null) {
            this.nivelAcesso = nivelAcesso;
            this.setPermissoes();
        }else{
            throw new IllegalArgumentException("Nível de acesso inválido");
        }
    }

    public Double getPrecoCredito() {
        return precoCredito;
    }

    public void setPrecoCredito(Double precoCredito) {
        if (precoCredito!=null) {
            this.precoCredito = precoCredito;
        }else{
            throw new IllegalArgumentException("Preco de crédito inválido");
        }
        
    }
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    private void setPermissoes(){
        switch(this.nivelAcesso){
            case 1:
                this.permissaoAdministrador = new PermissaoAdministrador();
                this.setPrecoCredito(Permissoes.FUNCIONARIO);
                break;
            case 2:
                this.permissaoCliente = new PermissaoCliente();
                this.setPrecoCredito(Permissoes.DOCENTE);
                break;
            case 3:
                this.permissaoCliente = new PermissaoCliente();
                this.setPrecoCredito(Permissoes.PRECO_RESIDENTE);
                break;
            case 4:
                this.permissaoCliente = new PermissaoCliente();
                this.setPrecoCredito(Permissoes.PRECO_ALUNO_NORMAL);
                break;
            case 5:
                this.permissaoNutricionista = new PermissaoNutricionista();
                this.setPrecoCredito(Permissoes.FUNCIONARIO);
                break;
        }
        
    }

    public Administrador getPermissaoAdministrador() {
        return permissaoAdministrador;
    }

    public Cliente getPermissaoCliente() {
        return permissaoCliente;
    }

    public Nutricionista getPermissaoNutricionista() {
        return permissaoNutricionista;
    }

    public Vendedor getPermissaoVendedor() {
        return permissaoVendedor;
    }

    @Override
    public String toString() {
        return "TipoUsuario{" + "ID=" + ID + ", nivelAcesso=" + nivelAcesso + ", precoCredito=" + precoCredito + '}';
    }
    
    
}
