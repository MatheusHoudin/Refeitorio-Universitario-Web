/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.OpcaoDiaria;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ValdeneidaRodrigue~
 * ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    dataRefeicao DATE,
    diaDaSemana VARCHAR(25),
    turno VARCHAR(25)
 */
public class OpcoesDiariasDAO {
    public void Add(OpcaoDiaria c) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        stmt = con.prepareStatement("INSERT INTO OPCOES_DIARIAS VALUES(?, ? , ?)");
        stmt.setDate(1, (Date) c.getDataRefeicao());
        stmt.setString(2, c.getDiaSemana());
        stmt.setString(3, c.getTurno());
        stmt.execute();
        
        ConnectionFactory.closeConnection(con, stmt);
    }
    
    public void Remove(int ID) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        stmt = con.prepareStatement("DELETE FROM OPCOES_DIARIAS WHERE ID = ?");
        stmt.setInt(1, ID);
        stmt.execute();
        ConnectionFactory.closeConnection(con, stmt);
    }
    
    public static OpcaoDiaria Search(int ID) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String search = "SELECT * FROM OPCOES_DIARIAS WHERE ID = "+ID;
        stmt = con.prepareStatement("SELECT * FROM OPCOES_DIARIAS WHERE ID = ID");
        stmt.execute();
        rs = stmt.executeQuery(search);
        OpcaoDiaria l = new OpcaoDiaria();
        if (rs.next()) {
            l.setID(rs.getInt("ID"));
            l.setDataRefeicao((Date)rs.getDate("dataRefeicao"));
            l.setDiaSemana(rs.getString("diaDaSemana"));
            l.setTurno(rs.getString("turno"));
        }
        ConnectionFactory.closeConnection(con, stmt);
        return l;
    }
    
    public void Update() throws SQLException{
    
    }
    
    public static OpcaoDiaria setID(OpcaoDiaria c) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        rs = stmt.executeQuery("SELECT ID FROM OPCOES_DIARIAS WHERE dataRefeicao = ? AND diaDaSemana = ?");
        stmt.setDate(1, (Date) c.getDataRefeicao());
        stmt.setString(1, c.getDiaSemana());
        stmt.execute();
        c.setID(rs.getInt("ID"));
        ConnectionFactory.closeConnection(con, stmt);
        return c;
    }
}
