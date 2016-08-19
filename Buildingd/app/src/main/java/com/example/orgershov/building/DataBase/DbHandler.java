package com.example.orgershov.building.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.orgershov.building.Classes.Feedback;
import com.example.orgershov.building.Classes.Message;
import com.example.orgershov.building.Classes.Order;
import com.example.orgershov.building.Classes.Payment;
import com.example.orgershov.building.Classes.ServiceGiver;
import com.example.orgershov.building.Classes.User;

import java.util.ArrayList;


/**
 * Created by alex-ks53 on 8/3/2016.
 */
public class DbHandler {

    public MySQLiteHelper dbHelper;
    public DbHandler(Context context)
    {
        dbHelper = new MySQLiteHelper(context, DbConstants.BDB_DB_NAME, null, DbConstants.BDB_DB_VERSION);
    }

    public boolean addUser(User newUser,String status)
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues columnValues = new ContentValues();
        columnValues.put(DbConstants.USER_ID, newUser.getID());
        columnValues.put(DbConstants.FIRST_NAME, newUser.getFirstName());
        columnValues.put(DbConstants.LAST_NAME, newUser.getLastName());
        columnValues.put(DbConstants.EMAIL, newUser.getEmail());
        columnValues.put(DbConstants.USER_NAME, newUser.getUserName());
        columnValues.put(DbConstants.PASSWORD, newUser.getPassword());
        columnValues.put(DbConstants.BUILDING_ADDRESS, newUser.getBuildingAddress());
        columnValues.put(DbConstants.PHONE_NUMBER, newUser.getPhoneNumber());
        columnValues.put(DbConstants.USER_PERMISSION, newUser.getUserPermission());
        columnValues.put(DbConstants.APARTMENT_ID, newUser.getApartmentId());
        columnValues.put(DbConstants.STATUS,status);



        long result = db.insert(DbConstants.USER_TABLE_NAME, null, columnValues);

        db.close();

        return(result != -1);
    }

    public User Login(String username,String password){
       User user= null;
        String status=null;
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor UserCursor = db.rawQuery("select * from " + DbConstants.USER_TABLE_NAME + " where " +DbConstants.USER_NAME + "='" + username + "'" , null);
        if (UserCursor != null)
        {
            if (UserCursor.moveToFirst())
            {
                int ID = UserCursor.getInt(0);
                String firstName =UserCursor.getString(1);
                String lastName =UserCursor.getString(2);
                String email= UserCursor.getString(3);
                String userName =UserCursor.getString(4);
                String Password =UserCursor.getString(5);
                String buildingAddress= UserCursor.getString(6);
                String phoneNumber= UserCursor.getString(7);
                String userPermission =UserCursor.getString(8);
                int apartmentId= UserCursor.getInt(9);
                status =UserCursor.getString(10);
                 user = new User(ID,firstName,lastName,email,userName,Password,buildingAddress
                        ,phoneNumber,userPermission,apartmentId);

            }
            UserCursor.close();
        }
        if (status.equals("new user")) {
            return null;
        }
        else
            return user;
    }
    public ArrayList<User> getNewUsers(){
          ArrayList<User> newUserList = new ArrayList<>();
        String status="new user";
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor UserCursor = db.rawQuery("select * from " + DbConstants.USER_TABLE_NAME + " where " +DbConstants.STATUS + "='" + status + "'" , null);
        while(UserCursor.moveToNext()){
            int ID = UserCursor.getInt(0);
            String firstName =UserCursor.getString(1);
            String lastName =UserCursor.getString(2);
            String email= UserCursor.getString(3);
            String userName =UserCursor.getString(4);
            String password =UserCursor.getString(5);
            String buildingAddress= UserCursor.getString(6);
            String phoneNumber= UserCursor.getString(7);
            String userPermission =UserCursor.getString(8);
            int apartmentId= UserCursor.getInt(9);
            User user = new User(ID,firstName,lastName,email,userName,password,buildingAddress
                    ,phoneNumber,userPermission,apartmentId);
            newUserList.add(user);
        }
        return newUserList;
    }
    public void AproveUser(int id,String status){

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues columnValues = new ContentValues();
        columnValues.put(DbConstants.STATUS,status);
        db.update(DbConstants.USER_TABLE_NAME,columnValues,DbConstants.USER_ID+"='"+id+"'",null);
        db.close();
       /* Cursor UserCursor = db.rawQuery("UPDATE "+ DbConstants.USER_TABLE_NAME+
                " SET " +DbConstants.STATUS + "='" + status + "' WHERE "+
                DbConstants.USER_ID+"='"+id+"'" , null);

        UserCursor.close();*/
    }
    public void DeleteUser(int id)
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues columnValues = new ContentValues();
        db.delete(DbConstants.USER_TABLE_NAME, DbConstants.USER_ID + "=" + id, null);
        db.close();
    }
   public void UpdateUser(User user,int id){

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues columnValues = new ContentValues();
       columnValues.put(DbConstants.USER_ID, user.getID());
       columnValues.put(DbConstants.FIRST_NAME, user.getFirstName());
       columnValues.put(DbConstants.LAST_NAME, user.getLastName());
       columnValues.put(DbConstants.EMAIL, user.getEmail());
       columnValues.put(DbConstants.USER_NAME, user.getUserName());
       columnValues.put(DbConstants.PASSWORD, user.getPassword());
       columnValues.put(DbConstants.BUILDING_ADDRESS, user.getBuildingAddress());
       columnValues.put(DbConstants.PHONE_NUMBER, user.getPhoneNumber());
       columnValues.put(DbConstants.USER_PERMISSION, user.getUserPermission());
       columnValues.put(DbConstants.APARTMENT_ID, user.getApartmentId());
       db.update(DbConstants.USER_TABLE_NAME,columnValues,DbConstants.USER_ID+"='"+id+"'",null);;
        db.close();

    }

    public ArrayList<User> getUsers()
    {

        ArrayList<User> UserList = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor UserCursor = db.query(DbConstants.USER_TABLE_NAME,null,null,null,null,null,null,null);
        while(UserCursor.moveToNext()){
            int ID = UserCursor.getInt(0);
            String firstName =UserCursor.getString(1);
            String lastName =UserCursor.getString(2);
            String email= UserCursor.getString(3);
            String userName =UserCursor.getString(4);
            String password =UserCursor.getString(5);
            String buildingAddress= UserCursor.getString(6);
            String phoneNumber= UserCursor.getString(7);
            String userPermission =UserCursor.getString(8);
            int apartmentId= UserCursor.getInt(9);
            User user = new User(ID,firstName,lastName,email,userName,password,buildingAddress
                    ,phoneNumber,userPermission,apartmentId);
            UserList.add(user);
        }
        return UserList;
    }
    public boolean addWorker(ServiceGiver newServiceGiver)
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues columnValues = new ContentValues();
        columnValues.put(DbConstants.WORKER_ID, newServiceGiver.getWorkerId());
        columnValues.put(DbConstants.SERVICE_NAME, newServiceGiver.getServiceName());
        columnValues.put(DbConstants.EXTERNAL_WORKER_FIRST_NAME, newServiceGiver.getFirstName());
        columnValues.put(DbConstants.EXTERNAL_WORKER_LAST_NAME, newServiceGiver.getLastName());



        long result = db.insert(DbConstants.EXTERNAL_WORKER_TABLE_NAME, null, columnValues);

        db.close();

        return(result != -1);
    }

    public ArrayList<ServiceGiver> ServiceGivers()
    {

        ArrayList<ServiceGiver> ServiceGiverList = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor ServiceGiverCursor = db.query(DbConstants.EXTERNAL_WORKER_TABLE_NAME,null,null,null,null,null,null,null);
        while(ServiceGiverCursor.moveToNext()){
            int ID = ServiceGiverCursor.getInt(0);
            String serviceName= ServiceGiverCursor.getString(1);
            String firstName =ServiceGiverCursor.getString(2);
            String lastName =ServiceGiverCursor.getString(3);


            ServiceGiver servicegiver = new ServiceGiver(ID,serviceName,firstName,lastName);

            ServiceGiverList.add(servicegiver);
        }
        return ServiceGiverList;
    }

    public boolean addMessage(Message newMessage)
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues columnValues = new ContentValues();
        columnValues.put(DbConstants.MESSAGE_ID, newMessage.getMessageID());
        columnValues.put(DbConstants.CONTENT, newMessage.getContent());
        columnValues.put(DbConstants.FROM_USER, newMessage.getFromUser());
        columnValues.put(DbConstants.TO_USER, newMessage.getToUser());

        long result = db.insert(DbConstants.MESSAGE_TABLE_NAME, null, columnValues);

        db.close();

        return(result != -1);
    }

    public ArrayList<Message> GetMessages()
    {

        ArrayList<Message> MessagesList = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor MessageCursor = db.query(DbConstants.MESSAGE_TABLE_NAME,null,null,null,null,null,null,null);
        while(MessageCursor.moveToNext()){
            int ID = MessageCursor.getInt(0);
            String context= MessageCursor.getString(1);
            String from =MessageCursor.getString(2);
            String to =MessageCursor.getString(3);


            Message message = new Message(ID,context,from,to);

            MessagesList.add(message);
        }
        return MessagesList;
    }


    public boolean addPayment(Payment newPayment)
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues columnValues = new ContentValues();
        columnValues.put(DbConstants.PAYMENT_ID, 1);
        columnValues.put(DbConstants.PAYMENT_FROM, newPayment.getFrom());
        columnValues.put(DbConstants.PAYMENT_TO, newPayment.getTo());
        columnValues.put(DbConstants.SUM, newPayment.getSum());
        columnValues.put(DbConstants.COMMENT, newPayment.getComment());


        long result = db.insert(DbConstants.PAYMENT_TABLE_NAME, null, columnValues);

        db.close();

        return(result != -1);
    }

    public ArrayList<Payment> GetPayments()
    {

        ArrayList<Payment> PaymentsList = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor MessageCursor = db.query(DbConstants.EXTERNAL_WORKER_TABLE_NAME,null,null,null,null,null,null,null);
        while(MessageCursor.moveToNext()){
            int ID = MessageCursor.getInt(0);
            int sum= MessageCursor.getInt(1);
            String from =MessageCursor.getString(2);
            String to =MessageCursor.getString(3);
            String comment =MessageCursor.getString(4);


            Payment payment = new Payment(ID,sum,from,to,comment);

            PaymentsList.add(payment);
        }
        return PaymentsList;
    }
    public boolean addOrder(Order newOrder)
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues columnValues = new ContentValues();
        columnValues.put(DbConstants.ORDER_ID, newOrder.getOrderID());
        columnValues.put(DbConstants.PAYMENT_FROM, newOrder.getFrom());
        columnValues.put(DbConstants.PAYMENT_TO, newOrder.getTo());
        columnValues.put(DbConstants.ORDER, newOrder.getOrder());


        long result = db.insert(DbConstants.ORDER_DATE_RECIEVED, null, columnValues);

        db.close();

        return(result != -1);
    }

    public ArrayList<Order> GetOrders()
    {
        ArrayList<Order> OrdersList = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor OrderCursor = db.query(DbConstants.EXTERNAL_WORKER_TABLE_NAME,null,null,null,null,null,null,null);
        while(OrderCursor.moveToNext()){
            int ID = OrderCursor.getInt(0);
            String from =OrderCursor.getString(2);
            String to =OrderCursor.getString(3);
            String orderContext =OrderCursor.getString(4);


            Order order = new Order(from,to,orderContext);

            OrdersList.add(order);
        }
        return OrdersList;
    }

    public boolean addFeedback(Feedback newFeedback)
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues columnValues = new ContentValues();
        columnValues.put(DbConstants.FEEDBACK, newFeedback.getFeedback());
        columnValues.put(DbConstants.RATING, newFeedback.getRating());
        columnValues.put(DbConstants.WORK_DONE, newFeedback.getWorkDone());
        columnValues.put(DbConstants.PRICE_TAKEN, newFeedback.getPriceTaken());


        long result = db.insert(DbConstants.FEEDBACK_TABLE_NAME, null, columnValues);

        db.close();

        return(result != -1);
    }

    public ArrayList<Feedback> GetFeedbacks()
    {
        ArrayList<Feedback> FeedbacksList = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor FeedbackCursor = db.query(DbConstants.EXTERNAL_WORKER_TABLE_NAME,null,null,null,null,null,null,null);
        while(FeedbackCursor.moveToNext()){
            int ID = FeedbackCursor.getInt(0);
            String feedBack =FeedbackCursor.getString(2);
            int rating =FeedbackCursor.getInt(3);
            String workDone =FeedbackCursor.getString(4);
            float priceTaken =FeedbackCursor.getFloat(5);


            Feedback feedback = new Feedback(ID,feedBack,rating,workDone,priceTaken);

            FeedbacksList.add(feedback);
        }
        return FeedbacksList;
    }

}
