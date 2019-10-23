/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapperTest;

import model.Invoice;
import model.InvoiceMapper;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author allan
 */
public class InvoiceMapperTest {
        private final InvoiceMapper im = new InvoiceMapper();
    
    @Test
    public void getInvoiceFromIDTest(){
        Invoice invoice = im.getInvoiceFromID(1);
        assertEquals(2, invoice.getCustomerID());
    }
}
