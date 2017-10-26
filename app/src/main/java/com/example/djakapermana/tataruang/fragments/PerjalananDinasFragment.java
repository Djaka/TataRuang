package com.example.djakapermana.tataruang.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.djakapermana.tataruang.R;
import com.example.djakapermana.tataruang.adapter.AdapterPerjalananDinas;
import com.example.djakapermana.tataruang.model.PerjalananDinas;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerjalananDinasFragment extends Fragment {

    public PerjalananDinasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_perjalanan_dinas, container, false);

        ListView mListViewPerjalananDinas = (ListView) view.findViewById(R.id.list_perjalanan_dinas);

        final ArrayList<PerjalananDinas> perjalananDinases = new ArrayList<PerjalananDinas>();
        perjalananDinases.add(new PerjalananDinas("20 Juli 2017","Seminar Infrastuktur di jl. pelajar pejuang 45 no. 66 bandung", 107.9229591, -6.8506319));

        AdapterPerjalananDinas adapterPerjalananDinas = new AdapterPerjalananDinas(getActivity(),perjalananDinases);

        mListViewPerjalananDinas.setAdapter(adapterPerjalananDinas);

        mListViewPerjalananDinas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                PerjalananDinas perjalananDinas = perjalananDinases.get(position);

                MapPerjalananDinasFragment mapPerjalananDinasFragment = new MapPerjalananDinasFragment();

                Bundle bundle = new Bundle();
                bundle.putString("tanggal", perjalananDinas.getTanggalPerjalanan());
                bundle.putString("tujuan", perjalananDinas.getTujuan());
                bundle.putString("longitude", String.valueOf(perjalananDinas.getLongitude()));
                bundle.putString("latitude", String.valueOf(perjalananDinas.getLatitude()));
                mapPerjalananDinasFragment.setArguments(bundle);

                getFragmentManager().beginTransaction()
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .replace(R.id.frame_default, mapPerjalananDinasFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        MenuItem item = menu.findItem(R.id.action_refresh);
        item.setVisible(false);
    }
}
