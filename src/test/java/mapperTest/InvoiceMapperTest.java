/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapperTest;

import java.sql.Timestamp;
import java.util.ArrayList;
import model.Invoice;
import datasource.InvoiceMapper;
import model.OrderLine;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author allan
 */
public class InvoiceMapperTest {

    private final InvoiceMapper im = new InvoiceMapper();

    @Test
    public void getHighestIDTest() {
        assertEquals(im.getHighestID(), 5);
    }

    @Test
    public void makeInvoiceTest() {
        int highestID = im.getHighestID();
        ArrayList<OrderLine> ordrelines = new ArrayList<>();
        ordrelines.add(new OrderLine(0, 1, 1, 1));
        im.makeInvoice(new Invoice(0, 2, 10.0, new Timestamp(2019, 10, 07, 22, 10, 0, 0), ordrelines));
        assertEquals(im.getHighestID(), ++highestID);
    }

    @Test
    public void getInvoiceFromIDAll() {

        for (int i = 1; i <= im.getHighestID(); i++) {
            Invoice invoice = im.getInvoiceFromID(i);
            assertEquals(i, invoice.getID());
            assertNotNull(invoice.getCustomerID());
            assertNotNull(invoice.getPrice());
            assertNotNull(invoice.getTime());
            assertNotNull(invoice.getOrderlines());
        }
    }

    @Test
    public void testGetOrderWithIDSpecific() {
        Invoice invoice = im.getInvoiceFromID(1);
        assertEquals(1, invoice.getID());
        assertEquals(2, invoice.getCustomerID());
        assertEquals(61.00, invoice.getPrice(), 0);
        assertEquals("2019-10-07 22:10:00.0", invoice.getTime().toString());
        assertEquals(2, invoice.getOrderlines().size());

    }

    @Test
    public void testGetAllInvoices() {
        ArrayList<Invoice> invoiceList = im.getAllInvoices();
        assertEquals(im.getHighestID(), invoiceList.size());
        for (int i = 0; i < invoiceList.size(); i++) {
            Invoice invoice = invoiceList.get(i);
            assertEquals(i + 1, invoice.getID());
            assertNotNull(invoice.getCustomerID());
            assertNotNull(invoice.getPrice());
            assertNotNull(invoice.getTime());
            assertNotNull(invoice.getOrderlines());
        }

    }
}
