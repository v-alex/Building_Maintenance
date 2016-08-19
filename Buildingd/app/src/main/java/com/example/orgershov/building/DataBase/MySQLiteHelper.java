package com.example.orgershov.building.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by alex-ks53 on 8/3/2016.
 */
public class MySQLiteHelper extends SQLiteOpenHelper{

    public MySQLiteHelper(Context context,String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        //USER
    db.execSQL("CREATE TABLE " +
            DbConstants.USER_TABLE_NAME+"( "+
            DbConstants.USER_ID+" INTEGER, "+
            DbConstants.FIRST_NAME+" TEXT, "+
            DbConstants.LAST_NAME+ " TEXT, "+
            DbConstants.EMAIL+"  TEXT, "+
            DbConstants.USER_NAME+" TEXT, "+
            DbConstants.PASSWORD+" TEXT ,"+
            DbConstants.BUILDING_ADDRESS+" TEXT, "+
            DbConstants.PHONE_NUMBER+" INTEGER, "+
            DbConstants.USER_PERMISSION+" TEXT, "+
            DbConstants.APARTMENT_ID+" INTEGER,"+
            DbConstants.STATUS+" TEXT)");
//ORDER
        db.execSQL("CREATE TABLE " +
                DbConstants.ORDER_TABLE_NAME+"( "+
                DbConstants.ORDER_ID+" INTEGER, "+
                DbConstants.ORDER_FROM+ " TEXT, "+
                DbConstants.ORDER_TO+"  TEXT, "+
                DbConstants.ORDER+" TEXT, "+
                DbConstants.ORDER_DATE_RECIEVED+" TEXT)");
//PAYMENT
        db.execSQL("CREATE TABLE " +
                DbConstants.PAYMENT_TABLE_NAME+"( "+
                DbConstants.PAYMENT_ID+" INTEGER, "+
                DbConstants.PAYMENT_FROM+ " TEXT, "+
                DbConstants.PAYMENT_TO+"  TEXT, "+
                DbConstants.SUM+" FLOAT, "+
                DbConstants.COMMENT+" TEXT ,"+
                DbConstants.PAYMENT_DATE_RECIEVED+" TEXT)");
//MESSAGE
        db.execSQL("CREATE TABLE " +
                DbConstants.MESSAGE_TABLE_NAME+"( "+
                DbConstants.MESSAGE_ID+" INTEGER, "+
                DbConstants.CONTENT+ " TEXT, "+
                DbConstants.FROM_USER+"  TEXT, "+
                DbConstants.TO_USER+" TEXT, "+
                DbConstants.MESSAGE_TIME_CREATED+" TEXT)");
//FEEDBACK
        db.execSQL("CREATE TABLE " +
                DbConstants.FEEDBACK_TABLE_NAME+"( "+
                DbConstants.FEEDBACK_WORKER_ID+" INTEGER, "+
                DbConstants.FEEDBACK+ " TEXT, "+
                DbConstants.RATING+"  INTEGER, "+
                DbConstants.WORK_DONE+" TEXT, "+
                DbConstants.PRICE_TAKEN+" FLOAT)");
//EXTERNAL WORKER
        db.execSQL("CREATE TABLE " +
                DbConstants.EXTERNAL_WORKER_TABLE_NAME+"( "+
                DbConstants.WORKER_ID+" INTEGER, "+
                DbConstants.SERVICE_NAME+ " TEXT, "+
                DbConstants.EXTERNAL_WORKER_FIRST_NAME+"  TEXT, "+
                DbConstants.EXTERNAL_WORKER_LAST_NAME+" TEXT, "+
                DbConstants.PHOTO+" TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
