/**
 * Created by ClaudiuRBC and Gosia  on 9/29/2016.
 */
import org.junit.*;
import static org.junit.Assert.*;

public class CustomerTests {

    @Test
    public void customer_isCreatedCorrectly(){
        Customer testCustomer = new Customer("Claudiu","Robciuc","533243","02-09-2016-20:30",20, 4);
        assertEquals("Claudiu", testCustomer.getfName());
        assertEquals("Robciuc", testCustomer.getlName());
        assertEquals("533243", testCustomer.getTelNum());
        assertEquals("02-09-2016-20:30", testCustomer.getReservationDate());
        assertEquals(20, testCustomer.getAge());
        assertEquals(4, testCustomer.getNumOfPeople());
    }


}
