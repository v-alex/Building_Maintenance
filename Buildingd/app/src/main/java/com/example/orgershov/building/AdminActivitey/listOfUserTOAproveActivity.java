package com.example.orgershov.building.AdminActivitey;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.orgershov.building.Classes.User;
import com.example.orgershov.building.DataBase.DbHandler;
import com.example.orgershov.building.R;

import java.util.ArrayList;
import java.util.List;

public class listOfUserTOAproveActivity extends AppCompatActivity  implements AdapterView.OnItemClickListener{
    ListView listOfNewUsers;
    DbHandler dbHandler;
    MyPersonAdapter newUsersAdapter;
    ArrayList<User> newUsers = new ArrayList<User>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_user_toaprove);
        dbHandler = new DbHandler(this);

        listOfNewUsers = (ListView)findViewById(R.id.listOfUsersToAproveLV);

        populatePeople();

        newUsersAdapter = new MyPersonAdapter(this, R.layout.users_waiting_for_aprival, newUsers);

        listOfNewUsers.setAdapter(newUsersAdapter);

        listOfNewUsers.setOnItemClickListener(this);
    }
    public void populatePeople()
    {
        ArrayList<User> userList=dbHandler.getNewUsers();

        for(User U: userList)  {
            newUsers.add(U);

        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent newUser = new Intent(this,aproveUserActivity.class);
        User newUserAprove = (User)parent.getItemAtPosition(position);

       newUser.putExtra("newUser",newUserAprove);
        startActivity(newUser);
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
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.users_waiting_for_aprival, parent, false);
            }
            // Lookup view for data population

            TextView firstname = (TextView) convertView.findViewById(R.id.firsnameWitingToAprovalTV);
            TextView lastname = (TextView) convertView.findViewById(R.id.lastnmaeWaitingForAprovalTV);
            TextView id = (TextView)convertView.findViewById(R.id.idWaitingForAproveTV);

            firstname.setText(user.getFirstName());
            lastname.setText(user.getLastName());
            id.setText(String.valueOf(user.getID()));
            /*if(user.isGender()) // true means female
                genderIcon.setImageResource(R.drawable.female);
            else
                genderIcon.setImageResource(R.drawable.male);
*/
            return convertView;

        }
    }
}
