package com.bizita.navneettest.model;

import java.io.Serializable;
import java.util.ArrayList;

public class ViewReportDTO implements Serializable {

        ArrayList<SuccessDTO>  success= new ArrayList<>();
    ArrayList<LocationDTO> location= new  ArrayList<>();

    public ArrayList<SuccessDTO> getSuccess() {
        return success;
    }

    public void setSuccess(ArrayList<SuccessDTO> success) {
        this.success = success;
    }

    public ArrayList<LocationDTO> getLocation() {
        return location;
    }

    public void setLocation(ArrayList<LocationDTO> location) {
        this.location = location;
    }
}
