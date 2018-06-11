/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.Pagamento;
import modelo.Relatorio;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

/**
 *
 * @author ValdeneidaRodrigues
 * ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
 * dataCriado DATE,
 * horario TIME,
 * gerador INT,
 */
public class RelatorioDAO {
    public static void Add(Date dataEmissao, Time horarioEmissao, int gerador) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        stmt = con.prepareStatement("INSERT INTO RELATORIO(dataCriado, horario, gerador) VALUES(?, ?, ?)");
        stmt.setDate(1, dataEmissao);
        stmt.setTime(2, horarioEmissao);
        stmt.setInt(3, gerador);
        stmt.execute();
        
        ConnectionFactory.closeConnection(con, stmt);
    }
    
    public static void Remove(int ID) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        stmt = con.prepareStatement("DELETE FROM RELATORIO WHERE ID = ?");
        stmt.setInt(1, ID);
        stmt.execute();
        ConnectionFactory.closeConnection(con, stmt);
    }
    
    public static void Search(int ID) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String search = "SELECT * FROM RELATORIO WHERE ID = "+ID;
        stmt = con.prepareStatement("SELECT * FROM RELATORIO WHERE ID = ID");
        stmt.execute();
        rs = stmt.executeQuery(search);
        /*Relatorio l = new Relatorio();
        if (rs.next()) {
            l.setID(rs.getInt("ID"));
            l.setDataEmissao(rs.getDate("dataCriado"));
            l.setGeradorCE(rs.getInt("gerador"));
            l.setHorarioEmissao(rs.getTime("horario"));
        }
        ConnectionFactory.closeConnection(con, stmt);
        return l;*/
    }
    
    public static void Update() throws SQLException{
    
    }
    
    public static Relatorio setID(Relatorio c) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs;
        String aaa = "SELECT * FROM RELATORIO WHERE dataCriado = "+c.getDataEmissao()+" AND gerador = "+c.getGerador()+" AND horario = "+c.getHorarioEmissao();
        
        stmt = con.prepareStatement(aaa);
        rs = stmt.executeQuery(aaa);
        if(rs.next()){
            c.setID(rs.getInt("ID"));
        }
        ConnectionFactory.closeConnection(con, stmt);
        return c; 
    }
    
}
