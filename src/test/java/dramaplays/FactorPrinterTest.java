package dramaplays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;


public class FactorPrinterTest {
    @Test  
    public void testPrinter(){ 
        FactorPrinter factorPrinter = new FactorPrinter();

        List<Performance> performances1 = new ArrayList<Performance>();
        performances1.add(new Performance("play1", 20));
        performances1.add(new Performance("play2", 10));

        List<Performance> performances2 = new ArrayList<Performance>();
        performances2.add(new Performance("play1", 40));
        performances2.add(new Performance("play2", 21));

        List<Performance> performances3 = new ArrayList<Performance>();
        performances3.add(new Performance("play2", 23));
        performances3.add(new Performance("play2", 35));

        Invoice invoice1 = new Invoice("customer1", performances1);
        Invoice invoice2 = new Invoice("customer1", performances2);
        Invoice invoice3 = new Invoice("customer1", performances3);

        Play play1 = new Play("play1", "tragedy");
        Play play2 = new Play("play2", "comedy");

        Map<String, Play> map = new HashMap<String,Play>();
        map.put("play1", play1);
        map.put("play2", play2);

        NumberFormat frmt = NumberFormat.getCurrencyInstance(Locale.US);

        String result1 = factorPrinter.print(invoice1, map);
        String expectedResult1 = String.format("Factor for %s\n", "customer1");
        expectedResult1 += String.format("  %s: %s (%s seats)\n", "play1", frmt.format(400), 20);
        expectedResult1 += String.format("  %s: %s (%s seats)\n", "play2", frmt.format(330), 10);
        expectedResult1 += String.format("Amount owed is %s\n", frmt.format(730));
        expectedResult1 += String.format("You earned %s credits\n", 2);
        assertEquals(result1, expectedResult1);

        String result2 = factorPrinter.print(invoice2, map);
        String expectedResult2 = String.format("Factor for %s\n", "customer1");
        expectedResult2 += String.format("  %s: %s (%s seats)\n", "play1", frmt.format(500), 40);
        expectedResult2 += String.format("  %s: %s (%s seats)\n", "play2", frmt.format(468), 21);
        expectedResult2 += String.format("Amount owed is %s\n", frmt.format(968));
        expectedResult2 += String.format("You earned %s credits\n", 14);
        assertEquals(result2, expectedResult2);

        String result3 = factorPrinter.print(invoice3, map);
        String expectedResult3 = String.format("Factor for %s\n", "customer1");
        expectedResult3 += String.format("  %s: %s (%s seats)\n", "play2", frmt.format(484), 23);
        expectedResult3 += String.format("  %s: %s (%s seats)\n", "play2", frmt.format(580), 35);
        expectedResult3 += String.format("Amount owed is %s\n", frmt.format(1064));
        expectedResult3 += String.format("You earned %s credits\n", 16);
        assertEquals(result3, expectedResult3);
    }

    @Test
    public void testPrinterWithError(){ 
        FactorPrinter factorPrinter = new FactorPrinter();

        List<Performance> performances = new ArrayList<Performance>();
        performances.add(new Performance("play1", 40));
        performances.add(new Performance("play3", 30));

        Invoice invoice = new Invoice("customer1", performances);

        Play play1 = new Play("play1", "tragedy");
        Play play3 = new Play("play3", "unkown");

        Map<String, Play> map = new HashMap<String,Play>();
        map.put("play1", play1);
        map.put("play3", play3);

        assertThrows(Error.class, () -> {
            String result = factorPrinter.print(invoice, map);
        });
    }
}
