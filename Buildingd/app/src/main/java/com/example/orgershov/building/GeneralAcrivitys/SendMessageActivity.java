package com.example.orgershov.building.GeneralAcrivitys;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.orgershov.building.Classes.Message;
import com.example.orgershov.building.Classes.User;
import com.example.orgershov.building.DataBase.DbHandler;
import com.example.orgershov.building.R;

import java.util.ArrayList;
import java.util.List;

public class SendMessageActivity extends AppCompatActivity  implements AdapterView.OnItemClickListener {
    ListView choseUser;
    DbHandler dbHandler;
    MyPersonAdapter UsersAdapter;
    String SendToUser;
    EditText context;

    ArrayList<User> allUsers = new ArrayList<User>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);

        dbHandler = new DbHandler(this);

        context=(EditText)findViewById(R.id.FirstMessageET);
        choseUser = (ListView) findViewById(R.id.ChooseUserToSendMessageLV);

        populatePeople();

        UsersAdapter = new MyPersonAdapter(this, R.layout.choose_user__to_send_message, allUsers);

        choseUser.setAdapter(UsersAdapter);

        choseUser.setOnItemClickListener(this);

    }

    public void populatePeople() {
        ArrayList<User> userList = dbHandler.getUsers();

        for (User U : userList) {
            allUsers.add(U);

        }
    }
    public void SendMessage (View v){

        Toast.makeText(this, "toast", Toast.LENGTH_SHORT).show();
        Message newMessage = new Message("fisrst message madafaka","alex","25/5/16");
        dbHandler.addMessage(newMessage);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        User user = (User) parent.getItemAtPosition(position);
        Toast.makeText(this, "clicked " + user.getFirstName(), Toast.LENGTH_SHORT).show();

    }

    class MyPersonAdapter extends ArrayAdapter<User> {

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
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.choose_user__to_send_message, parent, false);
            }
            // Lookup view for data population

            TextView tvName = (TextView) convertView.findViewById(R.id.nameText);
            TextView tvLastName = (TextView) convertView.findViewById(R.id.lastNameText);
            TextView apartmentIdTv = (TextView) convertView.findViewById(R.id.apartmentId);

            tvName.setText(user.getFirstName());
            tvLastName.setText(user.getLastName());
          //  apartmentIdTv.setText(user.getApartmentId());
            /*if(user.isGender()) // true means female
                genderIcon.setImageResource(R.drawable.female);
            else
                genderIcon.setImageResource(R.drawable.male);
*/
            return convertView;

        }
    }
}
