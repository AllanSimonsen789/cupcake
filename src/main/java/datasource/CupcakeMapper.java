/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Bottom;
import model.Top;

/**
 *
 * @author THOMA
 */
public class CupcakeMapper implements CupcakeMapperInterface {

    
    

    @Override
    public Bottom getBottomFromID(int ID) {
        
        
        
        String sql = "SELECT * FROM cupcakes.bottoms WHERE ID = ?;";
        
        Bottom bottom = null;
        
        try{
            Connection conn = DB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, ID);
            ResultSet res = pstmt.executeQuery();
            
            if(res == null){
                return null;
            }
            else{
                res.next();
                bottom = new Bottom(res.getInt("ID"), res.getString("name"), res.getDouble("price"));
            }
                    
                    } catch (SQLException ex) {
            Logger.getLogger(CupcakeMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return bottom;
        
    }

    @Override
    public Top getTopFromID(int ID) {
    
    String sql = "SELECT * FROM cupcakes.tops WHERE ID = ?;";
        
        Top top = null;
        
        try{
            Connection conn = DB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, ID);
            ResultSet res = pstmt.executeQuery();
            
            if(res == null){
                return null;
            }
            else{
                res.next();
                top = new Top(res.getInt("ID"), res.getString("name"), res.getDouble("price"));
            }
                    
                    } catch (SQLException ex) {
            Logger.getLogger(CupcakeMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return top;
        
    }

    @Override
    public ArrayList<Bottom> getBottoms() {
        
        String sql = "SELECT * FROM cupcakes.bottoms;";
        ArrayList <Bottom> bottomList = new ArrayList<>();
        
        try {
            Connection conn = DB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet res = pstmt.executeQuery();
        
            if(res == null){
                return null;
            }
            else{
                while(res.next()){
                    bottomList.add(new Bottom(res.getInt("ID"),res.getString("name"), res.getDouble("price")));
                }
            }
        
        
        
        } catch (SQLException ex) {
            Logger.getLogger(CupcakeMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return bottomList;
    }

    @Override
    public ArrayList<Top> getTops() {
        
        String sql = "SELECT * FROM cupcakes.tops;";
        ArrayList <Top> topList = new ArrayList<>();
        
        try {
            Connection conn = DB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet res = pstmt.executeQuery();
        
            if(res == null){
                return null;
            }
            else{
                while(res.next()){
                    topList.add(new Top(res.getInt("ID"),res.getString("name"), res.getDouble("price")));
                }
            }
        
        
        
        } catch (SQLException ex) {
            Logger.getLogger(CupcakeMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return topList;
    
    
    
    }

    
    
}
