package com.example.orgershov.building.GeneralAcrivitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.orgershov.building.Classes.Payment;
import com.example.orgershov.building.Classes.User;
import com.example.orgershov.building.DataBase.DbHandler;
import com.example.orgershov.building.R;

public class PayBillsActivity extends AppCompatActivity {


    EditText sum;
    EditText payForm;
    EditText commant;
    DbHandler dbHandler;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_bills);
        sum =(EditText) findViewById(R.id.BPsumToPayET);
       payForm=(EditText) findViewById(R.id.PBpayForET);
        commant =(EditText) findViewById(R.id.PBcommantET);
        dbHandler = new DbHandler(this);
        id=(int)getIntent().getSerializableExtra("userId");
    }
    public void PayBill (View v){
   String ID=String.valueOf(id);

        try {
            int  mysum = Integer.parseInt(sum.getText().toString());
            Payment pay = new Payment(mysum,ID,payForm.getText().toString(),commant.getText().toString());
           if( dbHandler.addPayment(pay))
            Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show();
            else
            Toast.makeText(this, "not cliked", Toast.LENGTH_SHORT).show();
        } catch(NumberFormatException nfe) {
            System.out.println("Could not parse " + nfe);
        }

    }

}
