package fall18_207project.UserTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fall18_207project.User.User;

import static org.junit.Assert.assertEquals;

public class UsersTest {

    private User user1;

    @Before
    public  void setUp(){
        user1 = new User("christina", "111111");
    }

    @After
    public void tearDown(){
        user1 = null;
    }

    @Test
    public void testgetUsername(){
        assertEquals("christina", user1.getUsername());
    }

    @Test
    public void testgetPassword(){
        assertEquals("111111", user1.getPassword());
    }
}
