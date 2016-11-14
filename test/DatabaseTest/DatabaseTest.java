package DatabaseTest;

import com.psdb.DataBaseManagment;
import com.psmodel.customer.Customer;
import java.util.ArrayList;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DatabaseTest {
    
    public DatabaseTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void customerGreaterThanZero(){
        DataBaseManagment dbm = new DataBaseManagment();
        ArrayList<Customer> customers = dbm.getCustomers();
        Assert.assertTrue(customers.size() > 0);
    }
}
