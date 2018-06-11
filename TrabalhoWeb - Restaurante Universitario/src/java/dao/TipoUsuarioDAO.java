/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.bean.TipoUsuarioBean;
import modelo.Relatorio;
import modelo.TipoUsuario;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ValdeneidaRodrigues
 */
public class TipoUsuarioDAO {
    public static void Add(TipoUsuarioBean c) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        stmt = con.prepareStatement("INSERT INTO TIPO_USUARIO(nivelAcesso, preçoCredito) VALUES(?, ?)");
        stmt.setInt(1, c.getNivelAcesso());
        stmt.setDouble(2, c.getPrecoCredito());
        stmt.execute();
        
        ConnectionFactory.closeConnection(con, stmt);
    }
    
    public void Remove(int ID) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        stmt = con.prepareStatement("DELETE FROM TIPO_USUARIO WHERE ID = ?");
        stmt.setInt(1, ID);
        stmt.execute();
        ConnectionFactory.closeConnection(con, stmt);
    }
    
    public static TipoUsuarioBean Search(int nivelAcesso) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        stmt = con.prepareStatement("SELECT * FROM TIPO_USUARIO WHERE nivelAcesso = ?");
        stmt.setInt(1, nivelAcesso);
        rs = stmt.executeQuery();
        TipoUsuarioBean l = new TipoUsuarioBean();
        if (rs.next()) {
            l.setId(rs.getInt("ID"));
            l.setNivelAcesso(rs.getInt("nivelAcesso"));
            l.setPrecoCredito(rs.getDouble("preçoCredito"));
        }
        ConnectionFactory.closeConnection(con, stmt);
        return l;
    }
    
    
    public static void Update() throws SQLException{
    
    }
    
    public static TipoUsuario setID (TipoUsuario c) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs;
        String aaa = "SELECT * FROM RELATORIO WHERE nivelAcesso = "+c.getNivelAcesso()+" AND preçoCredito = "+c.getPrecoCredito();
        
        stmt = con.prepareStatement(aaa);
        rs = stmt.executeQuery(aaa);
        if(rs.next()){
            c.setID(rs.getInt("ID"));
        }
        ConnectionFactory.closeConnection(con, stmt);
        return c; 
    }
}
