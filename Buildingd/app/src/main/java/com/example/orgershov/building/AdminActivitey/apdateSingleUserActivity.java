package com.example.orgershov.building.AdminActivitey;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.orgershov.building.Classes.User;
import com.example.orgershov.building.DataBase.DbHandler;
import com.example.orgershov.building.R;

public class apdateSingleUserActivity extends AppCompatActivity {
  User  updateUser=null;
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
        setContentView(R.layout.activity_apdate_single_user);
        updateUser = (User) getIntent().getSerializableExtra("UpdateUser");
        initComponents();
       FillFailds();
        dbHandler = new DbHandler(this);
    }

    public void initComponents()
    {
        id=(EditText) findViewById(R.id.updateUserIdET);
        firstName=(EditText)findViewById(R.id.updateUserFirstNameET);
        lastName=(EditText)findViewById(R.id.updateUserlastNameET);
        password=(EditText)findViewById(R.id.updateUserPasswordET);
        username=(EditText)findViewById(R.id.updateUserUsernameET);
        email=(EditText)findViewById(R.id.updateUserEmailET);
        telephone=(EditText)findViewById(R.id.updateUserTelephonet);
        apatrmentId=(EditText)findViewById(R.id.updateUserApartmentET);
        adress=(EditText)findViewById(R.id.updateUserAdressET);
    }
    public void FillFailds()

    {   id.setText(String.valueOf(updateUser.getID()));
        firstName.setText(updateUser.getFirstName());
        lastName.setText(updateUser.getLastName());
        password.setText(updateUser.getPassword());
        username.setText(updateUser.getUserName());
        email.setText(updateUser.getEmail());
        telephone.setText(updateUser.getPhoneNumber());
        apatrmentId.setText(String.valueOf(updateUser.getApartmentId()));
        adress.setText(updateUser.getBuildingAddress());
    }
    public void UpdateUser(View v)
    {
        String Firstname=firstName.getText().toString();
        String Lastname=lastName.getText().toString();
        int Idofuser =Integer.parseInt(id.getText().toString());
        int Apatrment=Integer.parseInt(apatrmentId.getText().toString());
        String Email=email.getText().toString();
        String Username=username.getText().toString();
        String Password=password.getText().toString();
        String Adress=adress.getText().toString();
        String Telephone=telephone.getText().toString();
        //if user is new
        String status = "aproved";
     int idOfUpdate=updateUser.getID();
        User user = new User(Idofuser,Firstname,Lastname,Email,Username,Password,Adress,Telephone,"regular user",Apatrment);

  dbHandler.UpdateUser(user,idOfUpdate);

    }
}
