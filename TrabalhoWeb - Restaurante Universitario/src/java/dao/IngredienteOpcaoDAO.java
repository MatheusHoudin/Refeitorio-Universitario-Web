/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.OpcaoComida;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.bean.IngredienteBean;

/**
 *
 * @author ValdeneidaRodrigues
 * ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
 * nomeIngrediente VARCHAR(100),
 * ID_opcao INT,
 */
public class IngredienteOpcaoDAO {
    public static void Add(String nomeIngrediente, OpcaoComida c) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        stmt = con.prepareStatement("INSERT INTO INGREDIENTE_OPCAO(nomeIngrediente, ID_opcao) VALUES(?, ?)");
        stmt.setString(1, nomeIngrediente);
        stmt.setInt(2, c.getId()); 
        stmt.execute();
        
        ConnectionFactory.closeConnection(con, stmt);
    }
    
    public static void Remove(int ID) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        stmt = con.prepareStatement("DELETE FROM INGREDIENTE_OPCAO WHERE ID = ?");
        stmt.setInt(1, ID);
        stmt.execute();
        ConnectionFactory.closeConnection(con, stmt);
    }
    
    public static void Search(int ID) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        stmt = con.prepareStatement("SELECT * FROM INGREDIENTE_OPCAO WHERE ID = ID");
        stmt.execute();
        ConnectionFactory.closeConnection(con, stmt);
    }
    
    public static void Update() throws SQLException{
    
    }
}
