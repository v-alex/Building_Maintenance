package com.example.orgershov.building.AdminActivitey;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.orgershov.building.Classes.User;
import com.example.orgershov.building.DataBase.DbHandler;
import com.example.orgershov.building.R;

public class aproveUserRequsetActivity extends AppCompatActivity {
    EditText id;
    EditText firstName;
    EditText lastName;
    EditText password;
    EditText username;
    EditText email;
    EditText telephone;
    EditText apatrmentId;
    EditText adress;

    DbHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aprove_user_requset_activity);

        id=(EditText) findViewById(R.id.SendRequestAddUserIdET);
        firstName=(EditText)findViewById(R.id.updateUserFirstNameET);
        lastName=(EditText)findViewById(R.id.updateUserlastNameET);
        password=(EditText)findViewById(R.id.updateUserPasswordET);
        username=(EditText)findViewById(R.id.updateUserUsernameET);
        email=(EditText)findViewById(R.id.updateUserEmailET);
        telephone=(EditText)findViewById(R.id.updateUserTelephonet);
        apatrmentId=(EditText)findViewById(R.id.updateUserApartmentET);
        adress=(EditText)findViewById(R.id.SendRequestAddUserAdressET);
        dbHandler = new DbHandler(this);
    }


    public void SendRequest(View v){
        int newId=Integer.parseInt(id.getText().toString());
        int newApartmentId=Integer.parseInt(apatrmentId.getText().toString());
        String newLastname=lastName.getText().toString();
        String newFirstname=firstName.getText().toString();
        String newEmail=email.getText().toString();
        String newUsername=username.getText().toString();
        String Password=password.getText().toString();
        String newtelephone=telephone.getText().toString();
        String newadress=adress.getText().toString();
        String newIdPermission="regular user";


        String status = "new user";

        User user = new User(newId,newFirstname,newLastname,newEmail
                ,newUsername,Password,newadress,newtelephone,
                newIdPermission,newApartmentId);
        if(dbHandler.addUser(user,status)){
            Toast.makeText(this,"useradded",Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(this,"unsacsesful",Toast.LENGTH_SHORT).show();

    }
}
