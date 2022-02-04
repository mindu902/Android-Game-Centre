package fall18_207project.User;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import android.widget.Toast;

import fall18_207project.GameCenter.R;

public class SignUpActivity extends AppCompatActivity {

    private EditText newName;
    private EditText newPassword;
    private SignUp signUp;
    private UsersModel usersmodel = new UsersModel();
    public static final String userfile = "usersFile.ser";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        addNewSignUpButtonListener();
    }

    private void addNewSignUpButtonListener(){
        Button NewSignUpButton = findViewById(R.id.NewSignUpButton);
        NewSignUpButton.setOnClickListener((v) -> {
            Intent temp = new Intent(this, LogInActivity.class);
            this.signUp = new SignUp();

            String newName = ((EditText)findViewById(R.id.NewUserNameText)).getText().toString();
            String newPassword = ((EditText)findViewById(R.id.editText2)).getText().toString();

            //open the userfile
            loadUsersFromFile(userfile);

            //check if the newly created username has already existed,
            // if the password is at least 6 characters long
            if ((!signUp.checkDuplicate(newName)) && (signUp.validPassword(newPassword))){
                //save the new user information to usermodel(Hashmap)
                signUp.saveUser(newName,newPassword);
                //Save the new username and password to the usermodel in signup
                saveToFile(SignUp.usersFile);
                startActivity(temp);
                Toast.makeText(this, "Yay! You just created a new account!", Toast.LENGTH_SHORT).show();
            }
            else if (signUp.checkDuplicate(newName)){
                Toast.makeText(this, "User Name Already Exist", Toast.LENGTH_SHORT).show();
            }
            else if (!signUp.validPassword(newPassword)){
                Toast.makeText(this, "Hey! Password should be at least 6 characters!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //Save the new username and password to the usermodel in signup
    public void saveToFile(String filename){

        ObjectOutputStream outputStream = null;
        try {
            //ObjectOutputStream class is used to serialize an usermodel object, a file called
            //"usersFile.ser" is created
            outputStream = new ObjectOutputStream(this.openFileOutput(filename, MODE_PRIVATE));
            outputStream.writeObject(this.signUp.getUsersModel());
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Read usersFile and save it to usermodel.
    public void loadUsersFromFile(String fileName){
        try {
            //deserializes the usermodel object
            InputStream inputStream = this.openFileInput(fileName);
            if (inputStream != null) {
                ObjectInputStream input = new ObjectInputStream(inputStream);
                usersmodel = (UsersModel) input.readObject();
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

}
