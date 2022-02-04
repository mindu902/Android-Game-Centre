package fall18_207project.UserTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import fall18_207project.User.SignUp;
import fall18_207project.User.User;
import fall18_207project.User.UsersModel;

import static org.junit.Assert.assertEquals;

public class SignUpTest {

    private SignUp signup;

    @Before
    public void setUp(){
        signup = new SignUp();
        UsersModel usersmodel = new UsersModel();
        usersmodel.addUser(new User("christina", "111111"));
        signup.setUsersModel(usersmodel);
    }

    @After
    public void tearDown(){
        signup = null;
    }

    @Test
    public void testCheckDuplicate(){
        assertEquals(true, signup.checkDuplicate("christina"));
        assertEquals(false,signup.checkDuplicate("joy"));
    }

    @Test
    public void testValidPassword(){
        assertEquals(true, signup.validPassword("123456"));
        assertEquals(false, signup.validPassword("123"));
        assertEquals(true, signup.validPassword("12345678"));
    }
}
