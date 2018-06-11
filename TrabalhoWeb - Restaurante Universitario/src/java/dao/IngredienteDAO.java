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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Ingrediente;
import modelo.bean.InformacoesNutricionaisBean;
import modelo.bean.IngredienteBean;

/**
 *
 * @author mathe
 */
public class IngredienteDAO {
        public static boolean add(IngredienteBean ingBean){
        try {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            
            InformacoesNutricionaisDAO.Add(ingBean.getInformacoesNutricionaisBean());
            int idInfoNutricionais = InformacoesNutricionaisDAO.searchId(ingBean.getInformacoesNutricionaisBean());
            
            stmt = con.prepareStatement("insert into ingrediente(infoNutricionais,nome) values(?,?)");
            stmt.setInt(1, idInfoNutricionais);
            stmt.setString(2, ingBean.getNome());
            
            if(stmt.execute()){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(IngredienteOpcaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
   
   public static List<IngredienteBean> obterIngredientes(){
       List<IngredienteBean> ingredientes = new ArrayList<>();
       try {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            stmt = con.prepareStatement("select * from ingrediente join informacoes_nutricionais on ingrediente.infoNutricionais = informacoes_nutricionais.ID");
            
            rs = stmt.executeQuery();
            while(rs.next()){
                InformacoesNutricionaisBean inf = new InformacoesNutricionaisBean();
                inf.setLactosa(rs.getBoolean("lactose"));
                inf.setLipidios(rs.getDouble("lipidios"));
                inf.setPorcaoGramas(rs.getDouble("gramas"));
                inf.setQuantidadeProteinas(rs.getDouble("proteinas"));
                IngredienteBean ingBean = new IngredienteBean();
                ingBean.setInformacoesNutricionaisBean(inf);
                ingBean.setNome(rs.getString("nome"));
                ingBean.setId(rs.getInt("ingrediente.ID"));
                ingredientes.add(ingBean);
            }
        } catch (SQLException ex) {
            Logger.getLogger(IngredienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ingredientes;
   }     
   
    
}
