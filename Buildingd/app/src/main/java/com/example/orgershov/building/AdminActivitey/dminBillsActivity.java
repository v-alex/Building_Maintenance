package com.example.orgershov.building.AdminActivitey;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.orgershov.building.Classes.User;
import com.example.orgershov.building.GeneralAcrivitys.PayBillsActivity;
import com.example.orgershov.building.R;

public class dminBillsActivity extends AppCompatActivity {
int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dmin_bills);
        id = (int)getIntent().getSerializableExtra("adminId");
    }


   public void payBills(View v){


       Intent paybills = new Intent(this, PayBillsActivity.class);
       paybills.putExtra("userId",id);
       startActivity(paybills);
   }
    public void ViewBills(View v){

        Intent viewbills = new Intent(this, ShowPaymentsActivity.class);

        startActivity(viewbills);
    }
}
