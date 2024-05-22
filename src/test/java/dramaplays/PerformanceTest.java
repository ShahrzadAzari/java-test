package dramaplays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PerformanceTest {  

    @Test  
    public void testConstructor(){ 
        Performance PerformanceClass = new Performance("playId", 10);
        assertEquals(PerformanceClass.playID, "playId");
        assertEquals(PerformanceClass.audience, 10); 
    }
}  
