package com.map;

import androidx.annotation.DrawableRes;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements GoogleMap.OnMarkerClickListener, OnMapReadyCallback {

    private GoogleMap mMap;

    private BitmapDescriptor bitmapDescriptorFromVector(Context context, @DrawableRes int vectorResId) {
        Drawable vectorDrawable = ContextCompat.getDrawable(context, vectorResId);
        vectorDrawable.setBounds(0, 0, vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight());
        Bitmap bitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        vectorDrawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }

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

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions()
                .position(sydney)
                .draggable(true)
                .title("Sydney"))
                .setIcon(bitmapDescriptorFromVector(this, R.drawable.ic_australia));
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(78.765481, 18.422899))
                .draggable(true)
                .title("Svalbard"))
                .setIcon(bitmapDescriptorFromVector(this, R.drawable.ic_norway));
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(54.974798, 83.135570))
                .draggable(true)
                .title("Novosibirsk"))
                .setIcon(bitmapDescriptorFromVector(this, R.drawable.ic_russia));
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(54.733295, 56.036891))
                .draggable(true)
                .title("Ufa"))
                .setIcon(bitmapDescriptorFromVector(this, R.drawable.ic_russia));
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(42.842477, 74.589037))
                .draggable(true)
                .title("Bishkek"))
                .setIcon(bitmapDescriptorFromVector(this, R.drawable.ic_kyrgyzstan));
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(64.143269, -17.846021))
                .draggable(true)
                .title("Iceland"))
                .setIcon(bitmapDescriptorFromVector(this, R.drawable.ic_iceland));
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-54.857476, -64.588401))
                .draggable(true)
                .title("Isla de los Estados"))
                .setIcon(bitmapDescriptorFromVector(this, R.drawable.ic_argentina));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        return false;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
