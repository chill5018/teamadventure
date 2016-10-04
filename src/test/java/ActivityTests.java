import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Filip on 29-09-2016.
 */
public class ActivityTests {

    @Test
    public void Activity_isCreatedCorrectly(){
        Activity testActivity = new Activity("Paintball", 500, 1500, 15, 14,"images/paintball.jpg");
        assertEquals("Paintball", testActivity.getName());
        //assertEquals(500, testActivity.getPrice());
        assertEquals(1500, testActivity.getTime());
        assertEquals(15, testActivity.getCapacity());
        assertEquals(14, testActivity.getMinAge());
    }
}
