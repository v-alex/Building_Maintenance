package com.example.orgershov.building.Classes;

import java.io.Serializable;
import java.util.List;

/**
 * Created by alex-ks53 on 8/3/2016.
 */
public class AdminUser extends User implements Serializable {
   // public Admin(){}

    public AdminUser(int ID, String firstName, String lastName, String email, String userName, String password, String buildingAddress, String phoneNumber, String userPermission, int apartmentId) {
        super(ID, firstName, lastName, email, userName, password, buildingAddress, phoneNumber, userPermission, apartmentId);
    }
}
