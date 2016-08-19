package com.example.orgershov.building.Classes;

import android.media.Image;

import java.io.Serializable;

/**
 * Created by alex-ks53 on 8/3/2016.
 */
public class ServiceGiver  implements Serializable {
    private int workerId;
    private String serviceName;
    private String firstName;
    private String lastName;
    private Image photo;

    public ServiceGiver(){};
    /**
     * constructor
     * @param workerId
     * @param serviceName
     * @param firstName
     * @param lastName
     */
    public ServiceGiver(int workerId, String serviceName, String firstName, String lastName) {
        this.workerId = workerId;
        this.serviceName = serviceName;
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public int getWorkerId() {
        return workerId;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getFirstName() {
        return firstName;
    }

    public boolean setFirstName(String firstName) {
        if((firstName.matches("[a-zA-Z]+")==false)||firstName.length()>20)
            return false;
        this.firstName = firstName;

        return true;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean setLastName(String lastName) {
        if((lastName.matches("[a-zA-Z]+")==false)||lastName.length()>20)
            return false;

        this.lastName = lastName;
        return true;
    }

    public Image getPhoto() {
        return photo;
    }

    public void setPhoto(Image photo) {
        this.photo = photo;
    }

}
