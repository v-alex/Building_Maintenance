package com.example.orgershov.building.AdminActivitey;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.orgershov.building.R;

public class UserManagmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_managment2);
    }
    public void MoveToAddUser(View v){
        Intent addUser = new Intent(this,addUserActivity.class);

        startActivity(addUser);
    }

    public void MoveToRemoveUser(View v){
        Intent RemoveUser = new Intent(this,deleteUserActivity.class);

        startActivity(RemoveUser);
    }
    public void MoveToUpdateUser(View v){
       Intent apdateUser = new Intent(this,apdateUserActivity.class);

        startActivity(apdateUser);
    }
    public void MoveToAproveUser(View v){
       Intent aproveUser = new Intent(this,listOfUserTOAproveActivity.class);

        startActivity(aproveUser);
    }
}
