import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Filip on 29-09-2016.
 */
public class ActivityTests {

    @Test
    public void Activity_isCreatedCorrectly(){
        Activity testActivity = new Activity("Paintball", "Cph", 500, 1500, 15, 14);
        assertEquals("Paintball", testActivity.getName());
        assertEquals("Cph", testActivity.getPlace());
        //assertEquals(500, testActivity.getPrice());
        assertEquals(1500, testActivity.getTime());
        assertEquals(15, testActivity.getCapacity());
        assertEquals(14, testActivity.getMinAge());
    }
}
