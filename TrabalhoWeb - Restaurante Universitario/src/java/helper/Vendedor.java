/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import modelo.Usuario;
import modelo.Venda;
import java.sql.Time;
import java.util.Date;

/**
 *
 * @author mathe
 */
public interface Vendedor {
    public Boolean venderCredito(Usuario usuario,Double valor);
    public Boolean validarVenda(Venda venda);
    public Venda gerarVenda(Usuario vendedor,Double valor,Time horario,Date data);
    public Boolean debitarCredito(Usuario usuario, Double valor);
}
