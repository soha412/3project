package com.example.wich;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sungkyul = new LatLng(37.379896, 126.928844);
        mMap.addMarker(new MarkerOptions().position(sungkyul).title("sungkyulUVI"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sungkyul));

        LatLng cafe1 = new LatLng(37.381835, 126.929787);
        mMap.addMarker(new MarkerOptions().position(cafe1).title("Long Coffee"));

        LatLng cafe2 = new LatLng(37.382046, 126.929825);
        mMap.addMarker(new MarkerOptions().position(cafe2).title("EDIYA"));

        mMap.animateCamera(CameraUpdateFactory.zoomTo(16.0f));

        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {

                String title = marker.getTitle();
                if(!TextUtils.isEmpty(title) && "sungkyulUVI".equals(title)) {
                Intent intent = new Intent(getBaseContext(),InfoActivity.class);
                intent.putExtra("title","sungkyulUVI");
                startActivity(intent);
            }
        }});
    }
}
