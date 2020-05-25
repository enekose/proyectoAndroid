package com.enekose.seriola_eneko_trabajo_4_android.activities;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;

import com.enekose.seriola_eneko_trabajo_4_android.R;
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
        Intent i = getIntent();
        int pos = i.getIntExtra("pos", 0);

        mMap = googleMap;

        LatLng tall1 = new LatLng(42.825815,-1.631111);
        LatLng tall2 = new LatLng(42.82024,-1.666657);
        LatLng tall3 = new LatLng(42.832934,-1.645006);
        LatLng tall4 = new LatLng(42.805247,-1.657403);
        LatLng centro;

        mMap.addMarker(new MarkerOptions().position(tall1).title("Electromecánica Txantrea"));
        mMap.addMarker(new MarkerOptions().position(tall2).title("Talleres Juaristi"));
        mMap.addMarker(new MarkerOptions().position(tall3).title("Auto Kit Ansoaín"));
        mMap.addMarker(new MarkerOptions().position(tall4).title("Talleres Layana Gabirondo"));


        switch (pos){
            case 0: centro = tall1;
                break;
            case 1: centro = tall2;
                break;
            case 2: centro = tall3;
                break;
            case 3: centro = tall4;
                break;
            default: centro = tall1;
        }

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(centro, 13.0f));
    }
}
