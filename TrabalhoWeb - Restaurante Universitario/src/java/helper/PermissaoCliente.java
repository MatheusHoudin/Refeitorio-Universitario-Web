/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import modelo.MudancaPerfil;
import modelo.Relatorio;
import modelo.SolicitacaoReembolso;

/**
 *
 * @author mathe
 */
public class PermissaoCliente implements Cliente{

    @Override
    public Relatorio visualizarHistoricoCompras() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SolicitacaoReembolso solicitarReembolso() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean editarPerfil(MudancaPerfil dados) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
