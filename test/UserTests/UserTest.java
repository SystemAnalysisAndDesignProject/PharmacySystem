package UserTests;

import com.psmodel.user.Admin;
import com.psmodel.user.Employee;
import com.psmodel.user.Manager;
import com.psmodel.user.Permission;
import com.psmodel.user.User;
import com.psmodel.user.UserFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserTest {
    
    public UserTest() {
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
    public void makeManagerUser(){
       UserFactory userFactory = new UserFactory();                
       User user = userFactory.makeUser("m");
       Assert.assertTrue(user instanceof Manager);
    }
    
    @Test
    public void makeEmployeeUser(){
       UserFactory userFactory = new UserFactory();                
       User user = userFactory.makeUser("e");
       Assert.assertTrue(user instanceof Employee);
    }
    
    @Test
    public void checkInvalidUser(){
       UserFactory userFactory = new UserFactory();                
       User user = userFactory.makeUser("s");
       Assert.assertNull(user);
    }
    
    @Test
    public void managerUserProperties(){
       String username = "test";
       String password = "test1";
       String role = "m";
       boolean canModifyCustomer = true;
       boolean canmodifyEmployee = true;
       boolean canModifyProduct = true;
       boolean canModifyManager = true;
        
       UserFactory userFactory = new UserFactory();                
       User user = userFactory.makeUser("m");
        
                user.setUsername(username);
                user.setPassword(password);
                user.setRole(role);
                user.setPermission(new Permission(canModifyCustomer,
                                                    canmodifyEmployee,
                                                    canModifyProduct,
                                                    canModifyManager));  
      
       Assert.assertEquals(username,user.getUsername());
       Assert.assertEquals(password,user.getPassword());
       Assert.assertEquals(role,user.getRole());
       Assert.assertEquals(canModifyCustomer,user.getPermission().getCanModifyCustomer());       
       Assert.assertEquals(canmodifyEmployee,user.getPermission().getCanModifyEmployee());       
       Assert.assertEquals(canModifyProduct,user.getPermission().getCanModifyProducts());       
       Assert.assertEquals(canModifyManager,user.getPermission().getCanModifyManager());
       
    }
    
    @Test
    public void singleton(){
        Admin admin = Admin.getInstance();
        Assert.assertTrue(admin instanceof Admin);
    }
    
    @Test
    public void comparingSingletons(){
        Admin admin = Admin.getInstance();
        Assert.assertTrue(admin instanceof Admin);
        Admin admin1 = Admin.getInstance();
        Assert.assertEquals(admin, admin1);
    }
}
