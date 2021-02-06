package com.bizita.navneettest;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.bizita.navneettest.interfacess.Consts;
import com.bizita.navneettest.model.SuccessDTO;
import com.bizita.navneettest.model.ViewReportDTO;
import com.bizita.navneettest.preferences.SharedPrefrence;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;


public class MapFragment extends Fragment {
    View view;
    private MapView mMapView;
    private GoogleMap googleMap;
    private ArrayList<MarkerOptions> optionsList = new ArrayList<>();
    private MainActivity mainActivity;
    int i=1;
    SharedPrefrence prefrence;

    private Hashtable<String, SuccessDTO> markers;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_map, container, false);
        mMapView = (MapView) view.findViewById(R.id.mapView);


        prefrence = SharedPrefrence.getInstance(getActivity());


        mMapView.onCreate(savedInstanceState);

        markers = new Hashtable<String, SuccessDTO>();
        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {
                googleMap = mMap;

                if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                    return;
                }
                googleMap.setMyLocationEnabled(true);

                LatLng sydney = new LatLng(Double.parseDouble(String.valueOf(mainActivity.latitude)), Double.parseDouble(String.valueOf(mainActivity.longitude)));

                CameraPosition cameraPosition = new CameraPosition.Builder().target(sydney).zoom(14).build();
                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
            }
        });

        getProfileLocation();

        return view;

    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }


    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }


    public void getProfileLocation() {


            try {



                for (int i = 0; i < mainActivity.locationDTOArrayList.size(); i++) {

                        optionsList.add(new MarkerOptions().position(new LatLng(Double.parseDouble(mainActivity.locationDTOArrayList.get(i).getLat()), Double.parseDouble(mainActivity.locationDTOArrayList.get(i).getLongg()))).title(mainActivity.successDTOS.get(i).getName()).snippet(mainActivity.successDTOS.get(i).getId()));



                }


                try {
                    MapsInitializer.initialize(getActivity().getApplicationContext());
                } catch (Exception e) {
                    e.printStackTrace();
                }

                mMapView.getMapAsync(new OnMapReadyCallback() {
                    @Override
                    public void onMapReady(GoogleMap mMap) {
                        googleMap = mMap;

                        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                            return;
                        }
                        googleMap.setMyLocationEnabled(true);



                        for (MarkerOptions options : optionsList) {

                            options.position(options.getPosition());
                            options.title(options.getTitle());
                            options.snippet(options.getSnippet());
                            options.draggable(false);
                            final Marker hamburg = googleMap.addMarker(options);

                            for (int i = 0; i < mainActivity.locationDTOArrayList.size(); i++) {
                                googleMap.addMarker(new MarkerOptions().position(options.getPosition()).title(mainActivity.successDTOS.get(i).getName()).title(mainActivity.successDTOS.get(i).getName()).snippet(mainActivity.successDTOS.get(i).getId()));

                                markers.put(hamburg.getId(), mainActivity.successDTOS.get(i));



                            }
                        }


                        googleMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {

                            @Override
                            public void onInfoWindowClick(Marker arg0) {
                            }
                        });


                    }
                });

            } catch (Exception e) {
                e.printStackTrace();
            }



    }



    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mainActivity = (MainActivity) activity;
    }



}
