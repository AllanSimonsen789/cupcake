/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapperTest;


import datasource.CupcakeMapper;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author THOMA
 */
public class CupcakeMapperTest {
    
    CupcakeMapper cm = new CupcakeMapper();
    
    
    public void getBottomFromIDTest(){
        
        assertEquals("Chocholate", cm.getBottomFromID(1));
    }

}
    

