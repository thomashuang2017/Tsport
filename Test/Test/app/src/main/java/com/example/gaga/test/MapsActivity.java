package com.example.gaga.test;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.KeyEvent;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
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


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng sport1 = new LatLng(25.059085, 121.546795);
        LatLng sport2 = new LatLng(25.060431, 121.523909);
        LatLng sport3 = new LatLng(25.082745, 121.591557);
        LatLng sport4 = new LatLng(25.070535, 121.487708);
        LatLng sport5 = new LatLng(25.048812, 121.536327);
        LatLng sport6 = new LatLng(25.044837, 121.547788);
        LatLng sport7 = new LatLng(25.046458, 121.507195);
        LatLng sport8 = new LatLng(25.066198, 121.523726);
        mMap.addMarker(new MarkerOptions().position(sport1).title("夢想38號 CAFE & BAR"));
        mMap.addMarker(new MarkerOptions().position(sport2).title("ZINC運動吧"));
        mMap.addMarker(new MarkerOptions().position(sport3).title("酒咖 運動飛鏢酒吧"));
        mMap.addMarker(new MarkerOptions().position(sport4).title("510 Darts飛鏢運動"));
        mMap.addMarker(new MarkerOptions().position(sport5).title("Halfway There kitchen & bar 伴路餐酒"));
        mMap.addMarker(new MarkerOptions().position(sport6).title("HUB 倉 鉄板&串物料理"));
        mMap.addMarker(new MarkerOptions().position(sport7).title("The 58 Bar - 台灣自釀啤酒專賣"));
        mMap.addMarker(new MarkerOptions().position(sport8).title("88 Sports Bar"));
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.getUiSettings().setMapToolbarEnabled(true);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sport5));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(14));
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            Intent myIntent = new Intent();
            myIntent = new Intent(MapsActivity.this, Baseball.class);
            startActivity(myIntent);
            this.finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
