package com.example.orgershov.building.AdminActivitey;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.orgershov.building.Classes.User;
import com.example.orgershov.building.DataBase.DbHandler;
import com.example.orgershov.building.R;

public class aproveUserActivity extends AppCompatActivity {
    TextView id;
    TextView firstName;
    TextView lastName;
    TextView password;
    TextView username;
    TextView email;
    TextView telephone;
    TextView apatrmentId;
    TextView adress;

    User newUser=null;
    DbHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aprove_user);
        newUser = (User) getIntent().getSerializableExtra("newUser");
        initComponents();
        FillFailds();
        dbHandler = new DbHandler(this);

    }
    public void initComponents()
    {
        id=(TextView) findViewById(R.id.aproveUserIdET);
        firstName=(TextView)findViewById(R.id.updateUserFirstNameET);
        lastName=(TextView)findViewById(R.id.updateUserlastNameET);
        password=(TextView)findViewById(R.id.updateUserPasswordET);
        username=(TextView)findViewById(R.id.updateUserUsernameET);
        email=(TextView)findViewById(R.id.updateUserEmailET);
        telephone=(TextView)findViewById(R.id.updateUserTelephonet);
        apatrmentId=(TextView)findViewById(R.id.updateUserApartmentET);
        adress=(TextView)findViewById(R.id.aproveUserAdressET);
    }
    public void FillFailds()

    {   id.setText("ID: "+String.valueOf(newUser.getID()));
        firstName.setText("first name: "+newUser.getFirstName());
         lastName.setText("last name: "+newUser.getLastName());
        password.setText("password: "+newUser.getPassword());
        username.setText("username: "+newUser.getUserName());
        email.setText("email :"+newUser.getEmail());
        telephone.setText("telephone: "+newUser.getPhoneNumber());
        apatrmentId.setText("apartment id: "+String.valueOf(newUser.getApartmentId()));
        adress.setText("adress: "+newUser.getBuildingAddress());
    }
    public void aproveUser(View v){


          int ID=newUser.getID();
         String status = "aproved";
       dbHandler.AproveUser(ID,status);
        Toast.makeText(this,  newUser.getFirstName()+" APROVED", Toast.LENGTH_SHORT).show();
    }

}
