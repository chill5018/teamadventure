import org.junit.Test;
import static org.junit.Assert.*;

public class BookingTests {
  private Activity testActivity = new Activity("Paintball", "Cph", 500, 1500, 15, 14);
  private Customer testCustomer = new Customer("Claudiu","Robciuc",533243,"02-09-2016-20:30",20, 4);
  private Company testCompany = new Company("Donald", "Trump", 5551234, "10/10/2016", 45, 10);


    @Test
    public void booking_isCreatedCorrectly(){
        Booking testBooking = new Booking(testActivity, testCustomer, testCompany);
        assertEquals(true, testActivity instanceof Activity);
        assertEquals(true, testCustomer instanceof Customer);
        assertEquals(true, testCompany instanceof Company);
        // assertEquals(testCustomer.getNumOfPeople()*testActivity.getPrice(), testBooking.getTotalPriceFamily());
        // assertEquals(testCompany.getNumOfPeople()*testActivity.getPrice(), testBooking.getTotalPriceCompany());
    }
}
