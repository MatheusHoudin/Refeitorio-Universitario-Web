/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.bean.PagamentoBean;
import modelo.bean.UsuarioBean;
import modelo.bean.VendaBean;
import modelo.Cardapio;
//import Modelo.OpcoesDiarias;
import modelo.Pagamento;
import modelo.Venda;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ValdeneidaRodrigues
 * ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
 * precoTotal DOUBLE,
 * venda INT,
 * cliente INT,
 */
public class PagamentoDAO {
    public static void Add(Pagamento c) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        stmt = con.prepareStatement("INSERT INTO PAGAMENTO(venda, cliente) VALUES(?, ? )");
        stmt.setInt(1, c.getVenda().getID());
        stmt.setInt(2, c.getCliente().getID());
        stmt.execute();
        
        ConnectionFactory.closeConnection(con, stmt);
    }
    
    public static void Remove(int ID) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        stmt = con.prepareStatement("DELETE FROM PAGAMENTO WHERE ID = ?");
        stmt.setInt(1, ID);
        stmt.execute();
        ConnectionFactory.closeConnection(con, stmt);
    }
    
    public static PagamentoBean Search(int ID) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String search = "SELECT * FROM PAGAMENTO WHERE ID = "+ID;
        stmt = con.prepareStatement("SELECT * FROM PAGAMENTO WHERE ID = ID");
        stmt.execute();
        rs = stmt.executeQuery(search);
        PagamentoBean l = new PagamentoBean();
        if (rs.next()) {
            l.setId(rs.getInt("ID"));
            l.setCliente((UsuarioBean)rs.getObject("cliente"));//FAZER UM RS PRA RETORNAR OS DADOS DO USUARIO E FAZER UM OBJETO
            
            l.setVenda((VendaBean)rs.getObject("venda"));//FAZER UM RS PRA RETORNAR OS DADOS DA VENDA E FAZER UM OBJETO
        }
        ConnectionFactory.closeConnection(con, stmt);
        return l;
    }
    
    public static void Update() throws SQLException{
    
    }
    
    public static Pagamento setID(Pagamento c) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs;
        String aaa = "SELECT * FROM PAGAMENTO WHERE  cliente = "+c.getCliente().getID()+" AND venda = "+c.getVenda().getID();
        
        stmt = con.prepareStatement(aaa);
        rs = stmt.executeQuery(aaa);
        if(rs.next()){
            c.setID(rs.getInt("ID"));
        }
        ConnectionFactory.closeConnection(con, stmt);
        return c;
    }
}
