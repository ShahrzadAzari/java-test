package dramaplays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class InvoiceTest {  

    @Test  
    public void testConstructor(){ 
        List<Performance> performances = new ArrayList<Performance>();
        Invoice InvoiceClass = new Invoice("customer", performances);
        assertEquals(InvoiceClass.customer, "customer");
        assertEquals(InvoiceClass.performances, performances); 
    }  
}  
