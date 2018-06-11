/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ValdeneidaRodrigues
 */
public class RelatorioPagamentoDAO {
    public void Add(int ID_Relatorio, int ID_Pagamento) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = stmt.executeQuery("SELECT * FROM RELATORIO WHERE ID = ID_Relatorio");
        ResultSet rs1 = stmt.executeQuery("SELECT * FROM PAGAMENTO WHERE ID = ID_Pagamento");
        if (rs != null && rs1 != null) {
            stmt = con.prepareStatement("INSERT INTO RELATORIO_PAGAMENTO(ID_relatorio, ID_pagamento) VALUES()?, ?");
            stmt.setInt(1, ID_Relatorio);
            stmt.setInt(2, ID_Pagamento);
            stmt.execute();
        }else{
            System.out.println("PAGAMENTO OU RELATORIO NÃO EXISTENTE!");
        }
        
        
        ConnectionFactory.closeConnection(con, stmt);
    }
    
    public void Remove(int ID) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        stmt = con.prepareStatement("DELETE FROM RELATORIO_PAGAMENTO WHERE ID = ?");
        stmt.setInt(1, ID);
        stmt.execute();
        ConnectionFactory.closeConnection(con, stmt);
    }
    
    public void Search() throws SQLException{
    
    }
    
    public void Update() throws SQLException{
    
    }
}
