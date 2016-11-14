/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserTests;

import com.psmodel.LoginModel;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Michal
 */
public class ValidationTest {
    
    public ValidationTest() {
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
    public void validationWithValidInputManager(){
        String username = "master";
        String password = "master1";
        
        LoginModel model = new LoginModel();
        boolean valid = model.Validate(username, password);
        Assert.assertTrue(valid);
    }
    @Test
    public void validationWithValidInputEmployee(){
        String username = "emp";
        String password = "emp1";
        
        LoginModel model = new LoginModel();
        boolean valid = model.Validate(username, password);
        Assert.assertTrue(valid);
    }
    
     @Test
    public void validationWithInvalidInput(){
        String username = "sadsa";
        String password = "asdas";
        
        LoginModel model = new LoginModel();
        boolean valid = model.Validate(username, password);
        Assert.assertFalse(valid);
    }    
    
}
