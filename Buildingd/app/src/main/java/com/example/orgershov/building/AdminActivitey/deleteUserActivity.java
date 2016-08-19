package com.example.orgershov.building.AdminActivitey;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
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

public class deleteUserActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView DusersLIst;
    DbHandler dbHandler;
    MyPersonAdapter DelateUserAdapter;
    ArrayList<User> UsersLIst = new ArrayList<User>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_user);
        dbHandler = new DbHandler(this);

        DusersLIst = (ListView)findViewById(R.id.ListOfUsersToDeleteLV);

        populatePeople();

        DelateUserAdapter = new MyPersonAdapter(this, R.layout.lidt_of_users_to_delete, UsersLIst);

        DusersLIst.setAdapter(DelateUserAdapter);

        DusersLIst.setOnItemClickListener(this);

    }
    public void populatePeople()
    {
        ArrayList<User> userList=dbHandler.getUsers();

        for(User U: userList)  {
            UsersLIst.add(U);

        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
      final User user = (User) parent.getItemAtPosition(position);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to delete this user?");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int id) {
              dbHandler.DeleteUser(user.getID());
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();

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
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.lidt_of_users_to_delete, parent, false);
            }
            // Lookup view for data population

            TextView tvName = (TextView) convertView.findViewById(R.id.firstnameOfUsetToDeleteTV);
            TextView tvLastname = (TextView) convertView.findViewById(R.id.lastnameOfUserToDeleteTV);
            TextView tvId = (TextView)convertView.findViewById(R.id.idOfUserToDeleteTV);

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
