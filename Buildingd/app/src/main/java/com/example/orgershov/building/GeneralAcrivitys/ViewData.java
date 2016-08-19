package com.example.orgershov.building.GeneralAcrivitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.example.orgershov.building.Classes.AdminUser;
import com.example.orgershov.building.Classes.User;
import com.example.orgershov.building.DataBase.DbHandler;
import com.example.orgershov.building.R;

import java.util.ArrayList;

public class ViewData extends AppCompatActivity {
    DbHandler dbHandler;
    EditText fullName;
    EditText email;
    EditText phone;
    EditText password;
    EditText username;
    EditText adress;
    EditText id;
    User user =null;
    AdminUser admin=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);

        fullName=(EditText) findViewById(R.id.viewDataNameET);
        email=(EditText) findViewById(R.id.viewDataEmailET);
        phone=(EditText) findViewById(R.id.VDphoneET);
        password=(EditText) findViewById(R.id.VDpasswordET);
        username=(EditText) findViewById(R.id.VDusernameET);
        adress=(EditText) findViewById(R.id.viewDataAdressET);
        id=(EditText) findViewById(R.id.viewDataIdET);
        user = (User)getIntent().getSerializableExtra("userData");
        admin = (AdminUser)getIntent().getSerializableExtra("AdminData");


        fillFailds();

    }
    private  void fillFailds() {

        if (admin != null) {
            fullName.setText(admin.getFirstName() + " " + admin.getLastName() + "(ADMIN)");
            email.setText(admin.getFirstName());
            phone.setText(admin.getPhoneNumber());
            //id.setText(Admin.getID());
            adress.setText(admin.getBuildingAddress() + " " + admin.getApartmentId());
            password.setText(admin.getPassword());
            username.setText(admin.getUserName());
        }
        if (user != null) {
            fullName.setText(user.getFirstName() + " " + user.getLastName() + "(resident)");
            email.setText(user.getFirstName());
            phone.setText(user.getPhoneNumber());
            //id.setText(Admin.getID());
            adress.setText(user.getBuildingAddress() + " " + user.getApartmentId());
            password.setText(user.getPassword());
            username.setText(user.getUserName());

        }
    }

}
