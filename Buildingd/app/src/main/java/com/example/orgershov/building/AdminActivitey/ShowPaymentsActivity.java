package com.example.orgershov.building.AdminActivitey;

import android.content.Context;
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
import android.widget.Toast;

import com.example.orgershov.building.Classes.User;
import com.example.orgershov.building.DataBase.DbHandler;
import com.example.orgershov.building.R;

import java.util.ArrayList;
import java.util.List;

public class ShowPaymentsActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView myListView;
    DbHandler dbHandler;
    MyPersonAdapter PersonsAdapter;
    ArrayList<User> allUsers = new ArrayList<User>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_payments);
        dbHandler = new DbHandler(this);

        myListView = (ListView)findViewById(R.id.UsersPaymentsLV);

       populatePeople();

        PersonsAdapter = new MyPersonAdapter(this, R.layout.single_not_payeds_user, allUsers);

        myListView.setAdapter(PersonsAdapter);

        myListView.setOnItemClickListener(this);

    }


    public void populatePeople()
    {
        ArrayList<User> userList=dbHandler.getUsers();

        for(User U: userList)  {
            allUsers.add(U);

        }
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        User user = (User) parent.getItemAtPosition(position);
        Toast.makeText(this, "clicked " + user.getFirstName(), Toast.LENGTH_SHORT).show();
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
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.single_not_payeds_user, parent, false);
            }
            // Lookup view for data population

            TextView tvName = (TextView) convertView.findViewById(R.id.usernameText);
            TextView tvTelephone = (TextView) convertView.findViewById(R.id.telephoneText);
            ImageView genderIcon = (ImageView)convertView.findViewById(R.id.genderIcon);

            tvName.setText(user.getFirstName());
            tvTelephone.setText(user.getPhoneNumber());
            /*if(user.isGender()) // true means female
                genderIcon.setImageResource(R.drawable.female);
            else
                genderIcon.setImageResource(R.drawable.male);
*/
            return convertView;

        }
    }
}
