package com.example.djakapermana.tataruang.fragments;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.djakapermana.tataruang.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * A simple {@link Fragment} subclass.
 */
public class MapInformasiRuangFragment extends Fragment implements OnMapReadyCallback{

    public MapInformasiRuangFragment() {
        // Required empty public constructor
    }

    MapView mapView;
    GoogleMap mGoogleMap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_map_informasi_ruang, container, false);
        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mapView = (MapView) view.findViewById(R.id.map_informasi_ruang);
        if(mapView != null){
            mapView.onCreate(null);
            mapView.onResume();
            mapView.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        String sNamaBangunan = getArguments().getString("namabangunan");
        String sNamaPemilik = getArguments().getString("namapemilik");
        String sLuasLahan = getArguments().getString("luaslahan");
        String sLatitude = getArguments().getString("latitude");
        String sLongitude = getArguments().getString("longitude");

        double lat = Double.valueOf(sLatitude);
        double lng = Double.valueOf(sLongitude);
        double luaslahan = Double.valueOf(sLuasLahan);

        MapsInitializer.initialize(getContext());

        mGoogleMap = googleMap;
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        googleMap.addMarker(new MarkerOptions().position(new LatLng(lat, lng)).title(sNamaBangunan).snippet("Nama Pemilik: " + sNamaPemilik + "\n" + "Luas Lahan: " + luaslahan + " Hektar"));

        googleMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker marker) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {
                LinearLayout info = new LinearLayout(getContext());
                info.setOrientation(LinearLayout.VERTICAL);

                TextView title = new TextView(getContext());
                title.setText(marker.getTitle());
                title.setTypeface(null, Typeface.BOLD);
                title.setGravity(Gravity.CENTER);

                TextView snippet = new TextView(getContext());
                snippet.setText(marker.getSnippet());

                info.addView(title);
                info.addView(snippet);

                return info;
            }
        });

        CameraPosition informasiRuang = CameraPosition.builder().target(new LatLng(lat, lng)).zoom(20).bearing(0).tilt(45).build();

        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(informasiRuang));

    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        MenuItem item = menu.findItem(R.id.action_refresh);
        item.setVisible(false);
    }
}
