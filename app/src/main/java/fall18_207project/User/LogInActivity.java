package fall18_207project.User;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

import fall18_207project.GameCenter.GameCenterActivity;
import fall18_207project.GameCenter.R;
import fall18_207project.GameCenter.SaveLoad;

public class LogInActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    //usermodel contains username and password
    public UsersModel usermodel = new UsersModel();
    public static final String userfile = "usersFile.ser";
    public static String current_user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        addLogInButtonListener();
        addSignUpButtonListener();
        loadUsersFromFile(userfile);

        username =  findViewById(R.id.UserNameText);
        password =  findViewById(R.id.PassworsText);


    }

    //Check whether username is valid and whether password is correct before login.
    //Display messages when login unsuccessfully

    private void addLogInButtonListener(){
        Button LogInButton = findViewById(R.id.LogInButton);
        LogInButton.setOnClickListener((v) -> {
            Intent temp = new Intent(LogInActivity.this, GameCenterActivity.class);

            //check if the input username and password are correct.
            String input_username = username.getText().toString();
            String input_password = password.getText().toString();

            if ( check_valid(input_username, input_password)  ) {
                current_user = input_username;
                startActivity(temp);
                //show up the message "Success"
                Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
            } //if not correct, check if the user name exists in the database
            else if (!check_valid_user_name(input_username)){
                Toast.makeText(this, "Invalid User Name", Toast.LENGTH_SHORT).show();
            }
            else if (!check_valid(input_username, input_password)){
                Toast.makeText(this, "Password Incorrect", Toast.LENGTH_SHORT).show();
            }

            SaveLoad.name = current_user;

        });
    }

    //Jump to SignUpActivity when press SignUp Button in LoginActivity.
    private void addSignUpButtonListener(){
        Button SignUpButton = findViewById(R.id.SignUpButton);
        SignUpButton.setOnClickListener((v) -> {
            Intent temp = new Intent(LogInActivity.this, SignUpActivity.class);
            startActivity(temp);
        });
    }


    // Read usersFile and save it to usermodel.
    public void loadUsersFromFile(String fileName){
        try {
            //read the input file
            InputStream inputStream = this.openFileInput(fileName);

            //if the input file stream is not null
            if (inputStream != null) {

                //deserializes the usermodel object
                ObjectInputStream input = new ObjectInputStream(inputStream);
                usermodel = (UsersModel) input.readObject();
                inputStream.close();
            }
        } catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        } catch (ClassNotFoundException e) {
            Log.e("login activity", "File contained unexpected data type: " + e.toString());
        }
    }


    // Return true if username exists in the usermodel, and password matches the username.
    public boolean check_valid(String username, String password){
        return usermodel.getUsers().containsKey(username)
                && usermodel.getUsers().get(username).equals(password);
    }


    // Return true if username is in record.
    public boolean check_valid_user_name(String username){
        return usermodel.getUsers().containsKey(username);
    }

}
