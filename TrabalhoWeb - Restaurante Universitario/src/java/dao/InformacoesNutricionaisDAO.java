/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.bean.InformacoesNutricionaisBean;
import modelo.InformacoesNutricionais;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ValdeneidaRodrigues
 * private int id;
    private Double quantidadeProteinas;
    private Boolean lactosa;
    private Double lipidios;
    private Double porcaoGramas;
 */

public class InformacoesNutricionaisDAO {
    public static void Add(InformacoesNutricionaisBean in) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        stmt = con.prepareStatement("INSERT INTO INFORMACOES_NUTRICIONAIS(lactose, gramas, lipidios, proteinas) VALUES(?, ?, ?, ?)");
        
        stmt.setBoolean(1, in.getLactosa());
        stmt.setDouble(2, in.getPorcaoGramas());
        stmt.setDouble(3, in.getLipidios());
        stmt.setDouble(4, in.getQuantidadeProteinas());
        
        stmt.execute();
        
        ConnectionFactory.closeConnection(con, stmt);
    }
    
    public static void Remove(int ID) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        stmt = con.prepareStatement("DELETE FROM INFORMACOES_NUTRICIONAIS WHERE ID = ?");
        stmt.setInt(1, ID);
        stmt.execute();
        
        ConnectionFactory.closeConnection(con, stmt);
    }
    
    public static InformacoesNutricionaisBean Search(int ID) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String search = "SELECT * FROM INFORMACOES_NUTRICIONAIS WHERE ID = "+ID;
        System.out.println(search);
        stmt = con.prepareStatement("SELECT * FROM INFORMACOES_NUTRICIONAIS WHERE ID = ID");
        rs = stmt.executeQuery(search);
        stmt.execute();
        InformacoesNutricionaisBean a = new InformacoesNutricionaisBean();
        if(rs.next()){
            System.out.println(rs.getDouble("quantidadeProteina"));
            a.setId(rs.getInt("ID"));
            a.setQuantidadeProteinas(rs.getDouble("quantidadeProteina"));
            a.setLactosa(rs.getBoolean("lactose"));
            a.setPorcaoGramas(rs.getDouble("porcaoGramas"));
            a.setLipidios(rs.getDouble("lipidio"));
        }
        ConnectionFactory.closeConnection(con, stmt);
        return a;
    }
    
    public static int searchId(InformacoesNutricionaisBean infBean){
        int id = -1;
        try {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = con.prepareStatement("select ID from informacoes_nutricionais where lactose=? and lipidios=? and gramas=? and proteinas=?");
            stmt.setBoolean(1, infBean.getLactosa());
            stmt.setDouble(2, infBean.getLipidios());
            stmt.setDouble(3, infBean.getPorcaoGramas());
            stmt.setDouble(4, infBean.getQuantidadeProteinas());
            
            rs = stmt.executeQuery();
            if(rs.next()){
                id = rs.getInt("ID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(InformacoesNutricionaisDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
   
    
    public static void Update(InformacoesNutricionais c) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        stmt.execute();
        ConnectionFactory.closeConnection(con, stmt);
    }
    
    
}
