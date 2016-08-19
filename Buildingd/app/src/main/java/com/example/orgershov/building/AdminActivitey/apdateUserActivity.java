package com.example.orgershov.building.AdminActivitey;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.orgershov.building.Classes.User;
import com.example.orgershov.building.DataBase.DbHandler;
import com.example.orgershov.building.R;

import java.util.ArrayList;
import java.util.List;

public class apdateUserActivity extends AppCompatActivity  implements AdapterView.OnItemClickListener {

    ListView UpdateusersLIst;
    DbHandler dbHandler;
    MyPersonAdapter UpdateUserAdapter;
    ArrayList<User> UsersLIst = new ArrayList<User>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apdate_user);
        dbHandler = new DbHandler(this);

        UpdateusersLIst = (ListView)findViewById(R.id.listOfUserToUpdateLV);

        populatePeople();

        UpdateUserAdapter = new MyPersonAdapter(this, R.layout.list_of_users_to_update, UsersLIst);

        UpdateusersLIst.setAdapter(UpdateUserAdapter);

        UpdateusersLIst.setOnItemClickListener(this);
    }
    public void populatePeople()
    {
        ArrayList<User> userList=dbHandler.getUsers();

        for(User U: userList)  {
            UsersLIst.add(U);

        }
    }
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent UpdateUser = new Intent(this,apdateSingleUserActivity.class);
        User user = (User) parent.getItemAtPosition(position);
        UpdateUser.putExtra("UpdateUser",user);
       startActivity(UpdateUser);

    }
    class MyPersonAdapter extends ArrayAdapter<User>
    {

        public MyPersonAdapter(Context context, int resource, List<User> objects) {
            super(context, resource, objects);
        }

        // the method getView is in charge of creating a single line in the list
        // it receives the position (index) of the line to be created
        // the method populates the view with the data from the relevant object (according to the position)
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            // Get the data item for this position

            Log.i("TEST getView", "inside getView position " + position);

            User user = getItem(position);
            // Check if an existing view is being reused, otherwise inflate the view

            // the mechanism recycles objects - so it creates them only the firs time
            // if created already - only update the data inside
            // ( when scrolling)
            if (convertView == null) {
                Log.e("TEST getView", "inside if with position " + position);
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_of_users_to_update, parent, false);
            }
            // Lookup view for data population

            TextView tvName = (TextView) convertView.findViewById(R.id.firstnameOfUserToUpdate);
            TextView tvLastname = (TextView) convertView.findViewById(R.id.lastnameOfUserToApdate);
            TextView tvId = (TextView)convertView.findViewById(R.id.idOfUserToUpdate);

            tvName.setText(user.getFirstName());
            tvLastname.setText(user.getLastName());
            tvId.setText(String.valueOf(user.getID()));
            /*if(user.isGender()) // true means female
                genderIcon.setImageResource(R.drawable.female);
            else
                genderIcon.setImageResource(R.drawable.male);
*/
            return convertView;

        }
    }
}
