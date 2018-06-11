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
public interface Cliente {
    public Relatorio visualizarHistoricoCompras();
    public SolicitacaoReembolso solicitarReembolso();
    public Boolean editarPerfil(MudancaPerfil dados);
}
