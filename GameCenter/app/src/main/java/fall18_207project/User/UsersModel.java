package fall18_207project.User;


import java.io.Serializable;
import java.util.HashMap;
/**
 * UsersModel class
 */

public class UsersModel implements Serializable {

    private HashMap<String, String> users = new HashMap<>();

    // Add a new user to the hashmap, key is the username, value is the password
    public void addUser(User user){
        this.users.put(user.getUsername(), user.getPassword());
    }

    // Return the Userfile, Hashmap
    public HashMap<String, String> getUsers(){
        return this.users;
    }

}
