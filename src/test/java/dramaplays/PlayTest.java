package dramaplays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayTest {  

    @Test  
    public void testConstructor(){  
        Play playClass = new Play("name", "type");
        assertEquals(playClass.name, "name");
        assertEquals(playClass.type, "type"); 
    }  
}  
