package com.example.orgershov.building.UserAcvitiys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.orgershov.building.Classes.User;
import com.example.orgershov.building.GeneralAcrivitys.ContactUsActivity;
import com.example.orgershov.building.GeneralAcrivitys.MessagesActivity;
import com.example.orgershov.building.GeneralAcrivitys.PayBillsActivity;
import com.example.orgershov.building.GeneralAcrivitys.ViewData;
import com.example.orgershov.building.R;

public class Resident extends AppCompatActivity {
    User user=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resident);
         user = (User)getIntent().getSerializableExtra("user");
        setTitle("WELCOME "+ user.getFirstName());
    }


    public boolean onCreateOptionsMenu(final Menu menu)
    {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_resident, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.View_Data: Intent VD = new Intent(this, ViewData.class);
                VD.putExtra("userData",user);

                startActivity(VD);	// test add
                break;
            case R.id.Order_Service: Toast.makeText(this, "update for this option"+ user.getFirstName(), Toast.LENGTH_SHORT).show();	// test search
                break;
            case R.id.Bills: Intent PB = new Intent(this, PayBillsActivity.class);
                PB.putExtra("userId",user.getID());
                startActivity(PB);	// test add
                break;
            case R.id.Messaging: Intent SM = new Intent(this, MessagesActivity.class);
                SM.putExtra("user",user);
                startActivity(SM);
                break;
            case R.id.Contact_Us: Intent CU = new Intent(this, ContactUsActivity.class);
                CU.putExtra("user",user);
                startActivity(CU);
                break;
        }
        return true;
    }
}
