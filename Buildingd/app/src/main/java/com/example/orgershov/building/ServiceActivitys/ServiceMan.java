package com.example.orgershov.building.ServiceActivitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.orgershov.building.GeneralAcrivitys.ContactUsActivity;
import com.example.orgershov.building.GeneralAcrivitys.MessagesActivity;
import com.example.orgershov.building.GeneralAcrivitys.ViewData;
import com.example.orgershov.building.R;

public class ServiceMan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_man);
    }


    public boolean onCreateOptionsMenu(final Menu menu)
    {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_service_man, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.View_Data: Intent VD = new Intent(this, ViewData.class);

                startActivity(VD);
                break;

            case R.id.Messaging: Intent SM = new Intent(this, MessagesActivity.class);

                startActivity(SM);
                break;

            case R.id.Contact_Us: Intent CU = new Intent(this, ContactUsActivity.class);

                startActivity(CU);
                break;
        }
        return true;
    }
}
