package com.example.orgershov.building.DataBase;

import android.media.Image;

import java.util.Date;

/**
 * Created by alex-ks53 on 8/3/2016.
 */
public class DbConstants {
    public static final String BDB_DB_NAME="BDB.db";
    public static final  int BDB_DB_VERSION= 1;

    //user table constants

    public static final String USER_TABLE_NAME = "USERS";
    public static final String USER_ID="ID";
    public static final String FIRST_NAME= "FIRST_NAME";
    public static final String LAST_NAME="LAST_NAME";
    public static final String EMAIL="EMAIL";
    public static final String USER_NAME="USERNAME";
    public static final String PASSWORD="PASSWORD";
    public static final String BUILDING_ADDRESS="BUILDING_ADDRESS";
    public static final String PHONE_NUMBER="PHONE_NUMBER";
    public static final String USER_PERMISSION="USER_PERMISSION";
    public static final String APARTMENT_ID="APARTMENT_ID";
    public static final String STATUS="STATUS";


    // ORDER TABLE CONSTANTS
    public static final String ORDER_TABLE_NAME="ORDERS";
    public static final String ORDER_ID="ORDER_ID";
    public static final String ORDER_FROM="ORDER_FROM";
    public static final String ORDER_TO="ORDER_TO";
    public static final String ORDER="ORDER_TEXT";
    public static final String ORDER_DATE_RECIEVED="DATE_RECIEVED";

    //payment table constants
    public static final  String PAYMENT_TABLE_NAME="PAYMENT";
    public static final  String PAYMENT_ID="PAYMENT_ID";
    public static final String PAYMENT_FROM="PAYMENT_FROM";
    public static final String PAYMENT_TO="PAYMENT_TO";
    public static final String SUM="SUM";
    public static final String COMMENT="COMMENT";
    public static final String PAYMENT_DATE_RECIEVED="DATE_RECIEVED";

    //message table constants
    public static final String MESSAGE_TABLE_NAME="MESSAGE";
    public static final String MESSAGE_ID="MESSAGE_ID";
    public static final String CONTENT="CONTENT";
    public static final String FROM_USER="FROM_USER";
    public static final String TO_USER="TO_USER";
    public static final String MESSAGE_TIME_CREATED="TIME_CREATED";

    //feedback table constants
    public static final String FEEDBACK_TABLE_NAME="FEEDBACK";
    public static final String FEEDBACK_WORKER_ID="WORKER_ID";
    public static final String FEEDBACK="FEEDBACK";
    public static final String RATING="RATING";
    public static final String WORK_DONE="WORK_DONE";
    public static final String PRICE_TAKEN="PRICE_TAKEN";

    //external worker table constants
    public static final String EXTERNAL_WORKER_TABLE_NAME="EXTERNAL_WORKER";
    public static final String WORKER_ID="ID";
    public static final String SERVICE_NAME="SERVICE_NAME";
    public static final String EXTERNAL_WORKER_FIRST_NAME="FIRST_NAME";
    public static final String EXTERNAL_WORKER_LAST_NAME="LAST_NAME";
    public static final String PHOTO="PHOTO";



}
