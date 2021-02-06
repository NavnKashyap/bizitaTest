package com.bizita.navneettest;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;


import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bizita.navneettest.interfacess.Consts;
import com.bizita.navneettest.model.ViewReportDTO;
import com.bizita.navneettest.preferences.SharedPrefrence;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;


public class ProfileFragment extends Fragment{

    private View view;
    private RecyclerView rvProfile;
    private ProfileAdapter profileAdapter;
    private LinearLayoutManager mLayoutManager;
    MainActivity mainActivity;
    private LayoutInflater myInflater;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_profile, container, false);
        myInflater = LayoutInflater.from(getActivity());
        setUiAction();

        return view;

    }

    public void setUiAction() {

        rvProfile = view.findViewById(R.id.rvProfile);
        mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        rvProfile.setLayoutManager(mLayoutManager);

        profileAdapter = new ProfileAdapter(getActivity(), mainActivity.successDTOS, myInflater);
        rvProfile.setAdapter(profileAdapter);

    }

    @Override
    public void onResume() {
        super.onResume();
    }








    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mainActivity = (MainActivity) activity;
    }


}
