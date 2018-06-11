/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author ValdeneidaRodrigues
 */
public class RelatorioVendasDAO {
    public void Add() throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        stmt.execute();
        
        ConnectionFactory.closeConnection(con, stmt);
    }
    
    public void Remove() throws SQLException{
    
    }
    
    public void Search() throws SQLException{
    
    }
    
    public void Update() throws SQLException{
    
    }
}
