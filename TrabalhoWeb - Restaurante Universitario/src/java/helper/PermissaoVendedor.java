/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import dao.UsuarioDAO;
import modelo.Usuario;
import modelo.Venda;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.bean.UsuarioBean;
import modelo.bean.VendaBean;

/**
 *
 * @author mathe
 */
public class PermissaoVendedor implements Vendedor {

    @Override
    public Boolean venderCredito(Usuario usuario, Double valor) {
        usuario.setCreditos(usuario.getCreditos()+valor);
        UsuarioBean ub = usuario.gerarBean();
        return UsuarioDAO.Update(ub);

    }

    @Override
    public Boolean validarVenda(Venda venda) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Venda gerarVenda(Usuario vendedor, Double valor, Time horario, Date data) {
        Venda venda = new Venda();
        VendaBean vb = new VendaBean();
        vb.setDataVenda(data);
        vb.setValorVenda(valor);
        vb.setHorarioVenda(horario);
        vb.setVendedor(vendedor.gerarBean());
        
        return venda;
    }

    @Override
    public Boolean debitarCredito(Usuario usuario, Double valor) {
        return true;
    }
    
}
