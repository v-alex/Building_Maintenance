package com.example.orgershov.building.Classes;

import java.io.Serializable;

/**
 * Created by alex-ks53 on 8/3/2016.
 */
public class User  implements Serializable {

    private int ID;
    private String firstName;
    private String lastName;
    private String email;
    private String userName;
    private String password;
    private String buildingAddress;
    private String phoneNumber;
    private String userPermission;
    private int apartmentId;

    public User(int ID, String firstName, String lastName, String email,
                String userName,String password, String buildingAddress,
                String phoneNumber, String userPermission, int apartmentId) {
        setID(ID);
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setUserName(userName);
        setPassword(password);
        setBuildingAddress(buildingAddress);
        setPhoneNumber(phoneNumber);
        setUserPermission(userPermission);
        setApartmentId(apartmentId);
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public boolean setFirstName(String firstName) {

      /*  if((firstName.matches("[a-zA-Z]+")==false)||firstName.length()>20)
            return false;*/
        this.firstName = firstName;
        return true;
    }

    public String getLastName() {

        return lastName;
    }

    public boolean setLastName(String lastName) {
      /* if((lastName.matches("[a-zA-Z]+")==false)||lastName.length()>20)
            return false;*/

        this.lastName = lastName;
        return true;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBuildingAddress() {
        return buildingAddress;
    }

    public void setBuildingAddress(String buildingAddress) {
        this.buildingAddress = buildingAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean setPhoneNumber(String phoneNumber) {
     /*   if (phoneNumber.matches("[0-9]+") == false)
            return false;*/
        this.phoneNumber = phoneNumber;
        return true;
    }

    public String getUserPermission() {
        return userPermission;
    }

    public void setUserPermission(String userPermission) {
        this.userPermission = userPermission;
    }

    public int getApartmentId() {
        return apartmentId;
    }

    public boolean setApartmentId(int apartmentId) {
        if (apartmentId<0||apartmentId>999)
            return false;
        this.apartmentId = apartmentId;
        return true;
    }


}
