package com.example.wich;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
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
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0,1,0, "위성지도");
        menu.add(0,2,0, "일반지도");
        menu.add(0,2,0, "성결대학교");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case 1:
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            case 2:
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            case 3:
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(37.380205, 126.928655), 17));
        }
        return false;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        // Add a marker in Sydney and move the camera
        final LatLng sungkyul = new LatLng(37.379896, 126.928844);
        mMap.addMarker(new MarkerOptions().position(sungkyul).title("sungkyulUVI").icon(BitmapDescriptorFactory.fromResource(R.drawable.school)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sungkyul));
        LatLng cafe1 = new LatLng(37.381835, 126.929787);
        mMap.addMarker(new MarkerOptions().position(cafe1).title("Long Coffee").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));

        LatLng cafe2 = new LatLng(37.382046, 126.929825);
        mMap.addMarker(new MarkerOptions().position(cafe2).title("EDIYA").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));

        LatLng cafe3 = new LatLng(37.384366, 126.933919);
        mMap.addMarker(new MarkerOptions().position(cafe3).title("Hollis Coffe").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));

        LatLng cafe4 = new LatLng(37.384792, 126.933429);
        mMap.addMarker(new MarkerOptions().position(cafe4).title("Can Coffee").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));

        LatLng cafe5 = new LatLng(37.384946, 126.933438);
        mMap.addMarker(new MarkerOptions().position(cafe5).title("6th street Coffe Shop").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));

        LatLng cafe6 = new LatLng(37.386432, 126.933400);
        mMap.addMarker(new MarkerOptions().position(cafe6).title("TwoSome Place").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));

        LatLng cafe7 = new LatLng(37.386658, 126.930888);
        mMap.addMarker(new MarkerOptions().position(cafe7).title("mumus Cafe").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));

        LatLng cafe8 = new LatLng(37.387201, 126.930716);
        mMap.addMarker(new MarkerOptions().position(cafe8).title("KKun Fishing Cafe").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));

        LatLng cafe9 = new LatLng(37.385332, 126.932099);
        mMap.addMarker(new MarkerOptions().position(cafe9).title("Coffe GruNamu").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));

        LatLng cafe10 = new LatLng(37.384865, 126.933737);
        mMap.addMarker(new MarkerOptions().position(cafe10).title("Palk's Coffee").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));

        LatLng cafe11 = new LatLng(37.384970, 126.934751);
        mMap.addMarker(new MarkerOptions().position(cafe11).title("Cafe Bianco").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));

        LatLng cafe13 = new LatLng(37.385205, 126.935728);
        mMap.addMarker(new MarkerOptions().position(cafe13).title("쏠렌자라").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));

        LatLng cafe14 = new LatLng(37.386273, 126.935905);
        mMap.addMarker(new MarkerOptions().position(cafe14).title("파스쿠찌 명학점").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));

        LatLng cafe15 = new LatLng(37.385671, 126.932603);
        mMap.addMarker(new MarkerOptions().position(cafe15).title("엔제리너스").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));

        LatLng cafe16 = new LatLng(37.386065, 126.931636);
        mMap.addMarker(new MarkerOptions().position(cafe16).title("좋은사람들").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));

        LatLng cafe17 = new LatLng(37.393166, 126.925718);
        mMap.addMarker(new MarkerOptions().position(cafe17).title("커피 본").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));

        LatLng cafe18 = new LatLng(37.393402, 126.925362);
        mMap.addMarker(new MarkerOptions().position(cafe18).title("커피 베이").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));

        LatLng cafe19 = new LatLng(37.396850, 126.922378);
        mMap.addMarker(new MarkerOptions().position(cafe19).title("향기가 머무는 커피숍").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));

        LatLng cafe20 = new LatLng(37.395920, 126.930993);
        mMap.addMarker(new MarkerOptions().position(cafe20).title("카페하로").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(16.0f));

        Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.marker), 100, 100, false);
        Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.school), 100, 100, false);


        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {

                String title = marker.getTitle();
                if(!TextUtils.isEmpty(title) && "sungkyulUVI".equals(title)) {
                Intent intent = new Intent(getApplicationContext(),InfoActivity.class);
                intent.putExtra("title","sungkyulUVI");
                startActivity(intent);
            }
                if(!TextUtils.isEmpty(title) && "Long Coffee".equals(title)) {
                    Intent intent = new Intent(getApplicationContext(),InfoActivity.class);
                    intent.putExtra("title","Long Coffee");
                    startActivity(intent);
                }
                if(!TextUtils.isEmpty(title) && "EDIYA".equals(title)) {
                    Intent intent = new Intent(getApplicationContext(),InfoActivity.class);
                    intent.putExtra("title","EDIYA");
                    startActivity(intent);
                }
                if(!TextUtils.isEmpty(title) && "Hollis Coffe".equals(title)) {
                    Intent intent = new Intent(getApplicationContext(),InfoActivity.class);
                    startActivity(intent);
                }
                if(!TextUtils.isEmpty(title) && "Can Coffee".equals(title)) {
                    Intent intent = new Intent(getApplicationContext(),InfoActivity.class);
                    startActivity(intent);
                }
                if(!TextUtils.isEmpty(title) && "6th street Coffe Shop".equals(title)) {
                    Intent intent = new Intent(getApplicationContext(),InfoActivity.class);
                    startActivity(intent);
                }
                if(!TextUtils.isEmpty(title) && "TwoSome Place".equals(title)) {
                    Intent intent = new Intent(getApplicationContext(),InfoActivity.class);
                    startActivity(intent);
                }
                if(!TextUtils.isEmpty(title) && "KKun Fishing Cafe".equals(title)) {
                    Intent intent = new Intent(getApplicationContext(),InfoActivity.class);
                    startActivity(intent);
                }
                if(!TextUtils.isEmpty(title) && "Coffe GruNamu".equals(title)) {
                    Intent intent = new Intent(getApplicationContext(),InfoActivity.class);
                    startActivity(intent);
                }
                if(!TextUtils.isEmpty(title) && "Palk's Coffee".equals(title)) {
                    Intent intent = new Intent(getApplicationContext(),InfoActivity.class);
                    startActivity(intent);
                }
                if(!TextUtils.isEmpty(title) && "Cafe Bianco".equals(title)) {
                    Intent intent = new Intent(getApplicationContext(),InfoActivity.class);
                    startActivity(intent);
                }
                if(!TextUtils.isEmpty(title) && "쏠렌자라".equals(title)) {
                    Intent intent = new Intent(getApplicationContext(),InfoActivity.class);
                    startActivity(intent);
                }
                if(!TextUtils.isEmpty(title) && "엔제리너스".equals(title)) {
                    Intent intent = new Intent(getApplicationContext(),InfoActivity.class);
                    startActivity(intent);
                }
                if(!TextUtils.isEmpty(title) && "좋은사람들".equals(title)) {
                    Intent intent = new Intent(getApplicationContext(),InfoActivity.class);
                    startActivity(intent);
                }
                if(!TextUtils.isEmpty(title) && "커피 본".equals(title)) {
                    Intent intent = new Intent(getApplicationContext(),InfoActivity.class);
                    startActivity(intent);
                }
                if(!TextUtils.isEmpty(title) && "커피 베이".equals(title)) {
                    Intent intent = new Intent(getApplicationContext(),InfoActivity.class);
                    startActivity(intent);
                }
                if(!TextUtils.isEmpty(title) && "향기가 머무는 커피숍".equals(title)) {
                    Intent intent = new Intent(getApplicationContext(),InfoActivity.class);
                    startActivity(intent);
                }
                if(!TextUtils.isEmpty(title) && "카페하로".equals(title)) {
                    Intent intent = new Intent(getApplicationContext(),InfoActivity.class);
                    startActivity(intent);
                }
        }});
    }
}
