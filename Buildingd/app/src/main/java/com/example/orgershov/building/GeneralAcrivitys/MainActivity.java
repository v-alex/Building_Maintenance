package com.example.orgershov.building.GeneralAcrivitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.orgershov.building.AdminActivitey.*;
import com.example.orgershov.building.Classes.AdminUser;
import com.example.orgershov.building.Classes.User;
import com.example.orgershov.building.DataBase.DbHandler;
import com.example.orgershov.building.R;
import com.example.orgershov.building.UserAcvitiys.Resident;

public class MainActivity extends AppCompatActivity {
    DbHandler dbHandler;
    EditText usernameTV;
    EditText passwordTV;
    AdminUser admin =null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usernameTV =  (EditText)findViewById(R.id.userNameLoginET);
        passwordTV=  (EditText)findViewById(R.id.passwordLoginET);
        dbHandler=new DbHandler(this);
        admin = new AdminUser(666,"or","gershov","or@mail.www","gershovmaster","666","hell","555","Admin",6);
        dbHandler.addUser(admin,"aproved");
        usernameTV.setText("gershovmaster");

    }
    public void login(View v) {
        String username = usernameTV.getText().toString();
        String password = passwordTV.getText().toString();
        User user = dbHandler.Login(username, password);

        if (username.equals(admin.getUserName()) && admin.getUserPermission().equals("Admin")) {
            finish();

            Intent myIntent = new Intent(this, Admin.class);

            myIntent.putExtra("user", admin);
            startActivity(myIntent);
        } else if (user == null) {
            Toast.makeText(this, "no such user ", Toast.LENGTH_SHORT).show();

        } else if (username.equals(user.getUserName()) && user.getUserPermission().equals("regular user")) {
            finish();
            Intent myIntent = new Intent(this, Resident.class);
            myIntent.putExtra("user", user);
            startActivity(myIntent);
        }
    }
    public void Register(View v){
        Intent register=new Intent(this,aproveUserRequsetActivity.class);
        startActivity(register);
    }
}
