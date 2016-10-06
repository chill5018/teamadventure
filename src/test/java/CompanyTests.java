import org.junit.*;
import static org.junit.Assert.*;

public class CompanyTests {

    @Test
    public void company_isCreatedCorrectly(){
        Customer testCompany = new Customer("Extreme Tech Nerds" ,"Claudiu","Robciuc","533243", "test@example.com","02-09-2016-20:30",20, 4);
        assertEquals("Extreme Tech Nerds", testCompany.getCompanyName());
        assertEquals("Claudiu", testCompany.getfName());
        assertEquals("Robciuc", testCompany.getlName());
        assertEquals("533243", testCompany.getTelNum());
        assertEquals("02-09-2016-20:30", testCompany.getReservationDate());
        assertEquals(20, testCompany.getAge());
        assertEquals(4, testCompany.getNumOfPeople());
    }
}
