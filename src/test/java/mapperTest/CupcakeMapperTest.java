/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapperTest;


import datasource.CupcakeMapper;
import model.Bottom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author THOMA
 */
public class CupcakeMapperTest {
        private final datasource.CupcakeMapper cm = new CupcakeMapper();
    
    @Test
    public void getBottomFromIDTest(){
        Bottom bottom = cm.getBottomFromID(1);
        assertEquals("Chocolate", bottom.getName());
    }

}
    

