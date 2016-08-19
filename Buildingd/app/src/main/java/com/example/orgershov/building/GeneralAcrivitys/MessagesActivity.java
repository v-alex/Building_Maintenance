package com.example.orgershov.building.GeneralAcrivitys;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
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

public class MessagesActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView MeaagesLV;
    DbHandler dbHandler;
    MyMessageAdapter MessagesAdapter;
    ArrayList<Message> allMessages = new ArrayList<Message>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);
        dbHandler = new DbHandler(this);
        //final Button btnNewMessage = (Button) findViewById(R.id.btnNewMessage);
       // btnNewMessage.setBackgroundResource(R.drawable.green_mail_send_icon);


        MeaagesLV = (ListView) findViewById(R.id.UsersMessageLV);

        getAllMessages();

        MessagesAdapter = new MyMessageAdapter(this, R.layout.single_message_layout, allMessages);

        MeaagesLV.setAdapter(MessagesAdapter);

        MeaagesLV.setOnItemClickListener(this);

    }

    public void SendAmessage(View v) {
        Toast.makeText(this, "your toast is ready you shithead", Toast.LENGTH_SHORT).show();
        Intent SendM= new Intent(this,SendMessageActivity.class);

        startActivity(SendM);

    }

    public void getAllMessages() {
        ArrayList<Message> messageList =dbHandler.GetMessages();

        Toast.makeText(this, "your toast before", Toast.LENGTH_SHORT).show();
       for (Message M : messageList) {
            allMessages.add(M);

        }
       Toast.makeText(this, "your toast is after", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Message message = (Message) parent.getItemAtPosition(position);
        Toast.makeText(this, "clicked " + message.getFromUser(), Toast.LENGTH_SHORT).show();
    }

    class MyMessageAdapter extends ArrayAdapter<Message> {

        public MyMessageAdapter(Context context, int resource, ArrayList<Message> objects) {
            super(context, resource, objects);
        }

        // the method getView is in charge of creating a single line in the list
        // it receives the position (index) of the line to be created
        // the method populates the view with the data from the relevant object (according to the position)
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            // Get the data item for this position

            Log.i("TEST getView", "inside getView position " + position);

            Message message = getItem(position);
            // Check if an existing view is being reused, otherwise inflate the view

            // the mechanism recycles objects - so it creates them only the firs time
            // if created already - only update the data inside
            // ( when scrolling)
            if (convertView == null) {
                Log.e("TEST getView", "inside if with position " + position);
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.single_message_layout, parent, false);
            }
            // Lookup view for data population

            TextView tvName =(TextView) convertView.findViewById(R.id.messageNameTV);
            TextView tvsubject =(TextView) convertView.findViewById(R.id.messageSubjectTV);
            TextView tvdate= (TextView) convertView.findViewById(R.id.messageDateTV);

            tvName.setText(message.getFromUser());
            tvsubject.setText(message.getContent());
            tvdate.setText(message.getToUser());
            /*if(user.isGender()) // true means female
                genderIcon.setImageResource(R.drawable.female);
            else
                genderIcon.setImageResource(R.drawable.male);
*/
            return convertView;

        }
    }
}