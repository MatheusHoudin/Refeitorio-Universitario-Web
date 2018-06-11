/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import modelo.Relatorio;
import modelo.SolicitacaoReembolso;
import modelo.Usuario;
import java.util.Date;
import modelo.bean.UsuarioBean;

/**
 *
 * @author mathe
 */
public interface Administrador extends Vendedor {
    public static final int NIVEL_ACESSO = 1;
    
    public Boolean addUsuario(UsuarioBean usuario);
    public Boolean alterarUsuario(Usuario usuario);
    public Boolean removerUsuario(Usuario usuario);
    public UsuarioBean obterUsuario(Usuario usuario);
    
    public Relatorio verRelatorioGeral(Date data);
    
    public Boolean analisarSolicitacaoReembolso(SolicitacaoReembolso solicitacaoReembolso);
}
