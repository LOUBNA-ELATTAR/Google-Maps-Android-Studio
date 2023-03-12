package com.example.google_map;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.example.google_map.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

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

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        LatLng london = new LatLng(51.507359,  -0.136439);
        LatLng rabat = new LatLng(34.020882, -6.841650);
        LatLng tirana = new LatLng(41.327953, 19.819025);
        mMap.addMarker(new MarkerOptions().position(london).title("Marker in London").icon(BitmapDescriptorFactory.fromResource(R.drawable.london)));
        mMap.addMarker(new MarkerOptions().position(rabat).title("Marker in Rabat").icon(BitmapDescriptorFactory.fromResource(R.drawable.rabat)));
        mMap.addMarker(new MarkerOptions().position(tirana).title("Marker in Tirana").icon(BitmapDescriptorFactory.fromResource(R.drawable.tirana)));
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney").icon(BitmapDescriptorFactory.fromResource(R.drawable.sydney)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

    }
}