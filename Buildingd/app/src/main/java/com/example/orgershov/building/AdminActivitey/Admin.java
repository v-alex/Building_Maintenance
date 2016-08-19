package com.example.orgershov.building.AdminActivitey;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebView;

import com.example.orgershov.building.Classes.AdminUser;
import com.example.orgershov.building.DataBase.DbHandler;
import com.example.orgershov.building.GeneralAcrivitys.ContactUsActivity;
import com.example.orgershov.building.GeneralAcrivitys.MessagesActivity;
import com.example.orgershov.building.GeneralAcrivitys.OrderService;
import com.example.orgershov.building.GeneralAcrivitys.ViewData;
import com.example.orgershov.building.R;

public class Admin extends AppCompatActivity {
    DbHandler dbHandler;
   AdminUser admin =null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        dbHandler=new DbHandler(this);
        admin = (AdminUser)getIntent().getSerializableExtra("user");
        WebView myWebView = (WebView) findViewById(R.id.NewsLayout);
      //  myWebView.loadUrl("http://www.ynet.co.il/home/0,7340,L-184,00.html");
        setTitle("WELCOME "+ admin.getFirstName());
    }

    public boolean onCreateOptionsMenu(final Menu menu)
    {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_admin, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.View_Data: Intent VD = new Intent(this, ViewData.class);
                VD.putExtra("AdminData",admin);

                startActivity(VD);	// test add
                break;
            case R.id.Order_Service: Intent OS = new Intent(this, OrderService.class);
                OS.putExtra("user",admin);
                startActivity(OS);		// test search
                break;
            case R.id.Bills: Intent PB = new Intent(this, dminBillsActivity.class);
                   PB.putExtra("adminId",admin.getID());
                startActivity(PB);
                break;
            case R.id.Messaging: Intent Mes = new Intent(this, MessagesActivity.class);
                Mes.putExtra("user",admin);
                startActivity(Mes);
                break;
            case R.id.User_Management:
                Intent UM = new Intent(this,UserManagmentActivity.class);
                UM.putExtra("user",admin);
                startActivity(UM);
             //Toast.makeText(this, "manage user later ", Toast.LENGTH_SHORT).show();
                break;
            case R.id.Contact_Us: Intent CU = new Intent(this,ContactUsActivity.class);
               CU.putExtra("user",admin);
                startActivity(CU);
                break;
        }
        return true;
    }
}
