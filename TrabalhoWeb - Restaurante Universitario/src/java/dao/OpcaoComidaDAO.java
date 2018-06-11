/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.OpcaoComida;
import modelo.OpcaoDiaria;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.bean.IngredienteBean;
import modelo.bean.OpcaoComidaBean;

/**
 *
 * @author ValdeneidaRodrigues
 * ~ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nomeComida VARCHAR(30),
    categoria VARCHAR(30),
    ID_informacoesNutricionais INT,
 */
public class OpcaoComidaDAO {
    public static boolean Add(OpcaoComidaBean c){
        Connection con;
        try {
            con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            stmt = con.prepareStatement("INSERT INTO opcao(nomeComida, categoria) VALUES(?, ?)");
            stmt.setString(1, c.getNomeComida());
            stmt.setString(2, c.getCategoria());
            stmt.execute();
            OpcaoComidaBean opcAdicionada = getOpcaoComidaBean(c);
            
            if(addRelacaoIngredienteOpcao(opcAdicionada, c.getIngredientes())){
                return true;
            }
            
            ConnectionFactory.closeConnection(con, stmt);
        } catch (SQLException ex) {
            Logger.getLogger(OpcaoComidaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
        
    }
    
    public static boolean addRelacaoIngredienteOpcao(OpcaoComidaBean opc,List<IngredienteBean> ingredientes){
        try {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            for (IngredienteBean ingrediente : ingredientes) {
                stmt = con.prepareStatement("insert into ingrediente_opcao(ingrediente,opcao) values(?,?)");
                stmt.setInt(1, ingrediente.getId());
                stmt.setInt(2, opc.getId());
                stmt.execute();
                
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(OpcaoComidaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    } 
    
    public static List<OpcaoComidaBean> getOpcaoComidaBeanPorCategoria(String categoria){
        List<OpcaoComidaBean> opcoes = new ArrayList<>();
        try {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = con.prepareStatement("select * from opcao where categoria=?");
            stmt.setString(1, categoria);
            
            rs = stmt.executeQuery();
            while(rs.next()){
                OpcaoComidaBean opc = new OpcaoComidaBean();
                opc.setId(rs.getInt("ID"));
                opc.setCategoria(rs.getString("categoria"));
                opc.setNomeComida("nomeComida");
                
                opcoes.add(opc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OpcaoComidaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return opcoes;
    }
    
    public static OpcaoComidaBean getOpcaoComidaBean(OpcaoComidaBean opc){
        try {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = con.prepareStatement("select * from opcao where nomeComida=? and categoria=?");
            stmt.setString(1, opc.getNomeComida());
            stmt.setString(2, opc.getCategoria());
            
            rs = stmt.executeQuery();
            if(rs.next()){
                OpcaoComidaBean opcBean = new OpcaoComidaBean();
                opcBean.setId(Integer.parseInt(rs.getString("ID")));
                opcBean.setNomeComida(rs.getString("nomeComida"));
                opcBean.setCategoria(rs.getString("categoria"));
                return opcBean;
            }
        } catch (SQLException ex) {
            Logger.getLogger(OpcaoComidaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static void Remove(int ID) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        stmt = con.prepareStatement("DELETE FROM OPCAO WHERE ID = ?");
        stmt.setInt(1, ID);
        stmt.execute();
        ConnectionFactory.closeConnection(con, stmt);
    }
    //RETORNAR TDS AS OPCOES EM UM ARRAY, PARA O ADM CONSEGUIR VISUALIZAR EM ALGUM METODO
    public static OpcaoComida Search(int ID) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String search = "SELECT * FROM OPCAO WHERE ID = "+ID;
        stmt = con.prepareStatement("SELECT * FROM OPCAO WHERE ID = ID");
        stmt.execute();
        rs = stmt.executeQuery(search);
        OpcaoComida l = new OpcaoComida();
        if (rs.next()) {
            l.setID(rs.getInt("ID"));
            l.setCategoria(rs.getString("categoria"));
            l.setNomeComida(rs.getString("nomeComida"));
        }
        ConnectionFactory.closeConnection(con, stmt);
        return l;
    }
    
    public static OpcaoComida setID(OpcaoComida c) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs;
        String a = ""+c.getCategoria()+"";
        System.out.println(a);
        String aaa = "SELECT * FROM OPCAO WHERE nomeComida = \""+c.getNomeComida()+"\" AND categoria = \""+c.getCategoria()+"\"";
        
        stmt = con.prepareStatement(aaa);
        rs = stmt.executeQuery(aaa);
        if(rs.next()){
            c.setID(rs.getInt("ID"));
        }
        ConnectionFactory.closeConnection(con, stmt);
        return c;
    }
}
