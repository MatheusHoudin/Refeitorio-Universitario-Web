/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.bean.CardapioBean;
import modelo.Cardapio;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ValdeneidaRodrigues
 */
public class CardapioDAO {
    public static void Add(Cardapio c) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        //stmt = con.prepareStatement("INSERT INTO bibliotecario (NOME, TURNO) VALUES(?,?)");
        stmt = con.prepareStatement("INSERT INTO CARDAPIO(dataInicial, dataFinal) VALUES(?, ?)");
        stmt.setDate(1, (Date) c.getDataInicial());
        stmt.setDate(2, (Date) c.getDataFinal());
        stmt.execute();
        
        ConnectionFactory.closeConnection(con, stmt);
    }
    
    public static void Remove(int ID) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        stmt = con.prepareStatement("DELETE FROM CARDAPIO WHERE ID = ?");
        stmt.setInt(1, ID);
        stmt.execute();
        ConnectionFactory.closeConnection(con, stmt);
    }
    
    public static ArrayList<CardapioBean> Search(Date dataInicial, Date dataFinal) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<CardapioBean> cardapio = new ArrayList<CardapioBean>();
        if (dataInicial != null && dataFinal != null) {
            stmt = con.prepareStatement("SELECT * FROM CARDAPIO WHERE dataInicial = ? AND dataFinal = ?");
            stmt.setDate(1, dataInicial);
            stmt.setDate(2, dataFinal);
            //System.out.println("???????????");
            stmt.execute();
        }else if(dataInicial != null && dataFinal == null){
            stmt = con.prepareStatement("SELECT * FROM CARDAPIO WHERE dataInicial = ?");
            stmt.setDate(1, dataInicial);
            stmt.execute();
        }else if(dataInicial == null && dataFinal != null){
            stmt = con.prepareStatement("SELECT * FROM CARDAPIO WHERE dataFinal = ?");
            stmt.setDate(1, dataFinal);
            stmt.execute();
        }else{
            stmt = con.prepareStatement("SELECT * FROM CARDAPIO");
            stmt.execute();
        }
        rs = stmt.executeQuery();
        while(rs.next()){
            CardapioBean c = new CardapioBean();
            c.setDataInicial(rs.getDate("dataInicial"));
            c.setDataFinal(rs.getDate("dataFinal"));
            cardapio.add(c);
        }
        ConnectionFactory.closeConnection(con, stmt);
        return cardapio;
    }
    
    public static void Update(Cardapio c, Date novaDataInicial, Date novaDataFinall) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        CardapioDAO.setID(c);
        stmt = con.prepareStatement("UPDATE CARDAPIO SET dataInicial = ?, dataFinal = ? WHERE ID = ?");
        stmt.setDate(1, novaDataInicial);
        stmt.setDate(2, novaDataFinall);
        stmt.setInt(3, c.getID());
        
        stmt.execute();
        ConnectionFactory.closeConnection(con, stmt);
    }
    
    public static Cardapio setID(Cardapio c) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs;
        String aaa = "SELECT * FROM CARDAPIO WHERE dataFinal = \""+c.getDataFinal()+"\" AND dataInicial = \""+c.getDataInicial()+"\"  ";
        
        stmt = con.prepareStatement(aaa);
        rs = stmt.executeQuery(aaa);
        if(rs.next()){
            c.setID(rs.getInt("ID"));
        }
        ConnectionFactory.closeConnection(con, stmt);
        return c;
    }
    
}
