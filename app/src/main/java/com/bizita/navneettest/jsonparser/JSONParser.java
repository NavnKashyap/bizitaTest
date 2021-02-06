package com.bizita.navneettest.jsonparser;

import android.content.Context;


import com.bizita.navneettest.preferences.SharedPrefrence;

import org.json.JSONObject;

public class JSONParser {
    String jsonObjResponse;
    public String SUCCESS = "";
    public String MESSAGE = "";
    public boolean RESULT = false;
    public Context context;
    public JSONObject jObj;


    private SharedPrefrence prefrence;

    public JSONParser(Context context, JSONObject response) {
        try {
            this.context = context;
            jObj  = response;
            prefrence = SharedPrefrence.getInstance(context);

                RESULT = true;


        } catch (Exception e) {
            jObj = null;
            e.printStackTrace();
        }
    }



}