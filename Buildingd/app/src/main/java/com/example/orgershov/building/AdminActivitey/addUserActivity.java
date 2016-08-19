package com.example.orgershov.building.AdminActivitey;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.orgershov.building.Classes.User;
import com.example.orgershov.building.DataBase.DbHandler;
import com.example.orgershov.building.R;

public class addUserActivity extends AppCompatActivity {
    EditText FirstnameTxt;
    EditText lastnameTxt;
    EditText EmailTxt;
    EditText UsermaneTxt;
    EditText PasswordTxt;
    EditText TelephoneTxt;
    EditText ApartmentTxt;
    EditText adressTxt;
    EditText IdTxt;

    DbHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        FirstnameTxt=(EditText) findViewById(R.id.updateUserFirstNameET);
        lastnameTxt=(EditText) findViewById(R.id.updateUserlastNameET);
        EmailTxt=(EditText) findViewById(R.id.updateUserEmailET);
        UsermaneTxt=(EditText) findViewById(R.id.updateUserUsernameET);
        PasswordTxt=(EditText) findViewById(R.id.updateUserPasswordET);
        TelephoneTxt=(EditText) findViewById(R.id.updateUserTelephonet);
        ApartmentTxt=(EditText) findViewById(R.id.updateUserApartmentET);
        adressTxt=(EditText) findViewById(R.id.addUserAdressET);
        IdTxt=(EditText) findViewById(R.id.addUserIdET);
        dbHandler = new DbHandler(this);
    }

     public void addAuser(View v)
     {
         String firstname=FirstnameTxt.getText().toString();
         String lastname=lastnameTxt.getText().toString();
         int Id =Integer.parseInt(IdTxt.getText().toString());
         int apatrment=Integer.parseInt(ApartmentTxt.getText().toString());
         String Email=EmailTxt.getText().toString();
         String username=UsermaneTxt.getText().toString();
         String password=PasswordTxt.getText().toString();
         String adress=adressTxt.getText().toString();
         String telephone=TelephoneTxt.getText().toString();
         //if user is new
         String status = "aproved";

         User user = new User(Id,firstname,lastname,Email,username,password,adress,telephone,"regular user",apatrment);
         if(dbHandler.addUser(user,status)){
             Toast.makeText(this,"useradded",Toast.LENGTH_SHORT).show();
         }
         else
             Toast.makeText(this,"unsacsesful",Toast.LENGTH_SHORT).show();
     }
}
