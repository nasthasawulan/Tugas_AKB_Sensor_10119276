package com.example.a10119276_mymaps.view.fragment;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import com.example.a10119276_mymaps.R;
import com.example.a10119276_mymaps.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 *  NIM   : 10119276
 *  Nama  : Nasthasa Wulan Ghani Sopian
 *  Kelas : IF-7
 */

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private boolean maps;
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

        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION
            }, 100);
        }
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
        maps = true;
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);
        LatLng Bebek = new LatLng(-6.891744768744561, 107.61674946821417);
        googleMap.addMarker(new MarkerOptions().position(Bebek)
                .title("BebeK Ali Borme Dipatiukur"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(Bebek));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Bebek, 15));

        LatLng Ayam = new LatLng(-6.940964990907456, 107.62707708170916);
        googleMap.addMarker(new MarkerOptions().position(Ayam)
                .title("KFC Buah Batu"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(Ayam));

        LatLng Agj = new LatLng(-6.933995037400445, 107.61362093937936);
        googleMap.addMarker(new MarkerOptions().position(Agj)
                .title("Ayam Geprek Jogja Moh.Ramdhan"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(Agj));

        LatLng Steak = new LatLng(-6.9306400756468225, 107.61900677258934);
        googleMap.addMarker(new MarkerOptions().position(Steak)
                .title("Waroeng Steak and Shake Banteng"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(Steak));

        LatLng Seblak = new LatLng(-6.904118778435824, 107.61270841238975);
        googleMap.addMarker(new MarkerOptions().position(Seblak)
                .title("Seblak Sultan Bandung"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(Seblak));
    }
}