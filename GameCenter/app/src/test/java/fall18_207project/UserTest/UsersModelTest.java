package fall18_207project.UserTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import fall18_207project.User.User;
import fall18_207project.User.UsersModel;

import static org.junit.Assert.assertEquals;

public class UsersModelTest {

    private UsersModel usersmodel;

    @Before
    public void setUp(){
        usersmodel = new UsersModel();
    }

    @After
    public void tearDown(){
        usersmodel = null;
    }

    @Test
    public void testaddUser(){
        HashMap<String, String> result = new HashMap<>();
        result.put("christina", "111111");
        usersmodel.addUser(new User("christina", "111111"));
        assertEquals(usersmodel.getUsers(),result);
    }
}
