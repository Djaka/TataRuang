package com.example.djakapermana.tataruang.fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.djakapermana.tataruang.R;
import com.example.djakapermana.tataruang.adapter.AdapterPerbup;
import com.example.djakapermana.tataruang.model.Perbup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerbupFragment extends Fragment {


    private static String TES = "PerbupFragment";
    public PerbupFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_perbup, container, false);

        final ArrayList<Perbup> mListPerbup = new ArrayList<Perbup>();
        mListPerbup.add(new Perbup("Perbup No.38 th 2016 Struktur, Tugas, Fungsi Perangkat Daerah", "https://goo.gl/uzUDzo"));
        mListPerbup.add(new Perbup("Perbup Tupoksi PUPR","https://goo.gl/J27EYy"));

        ListView mListViewPerbup = (ListView) view.findViewById(R.id.list_perbup);

        AdapterPerbup adapterPerbup = new AdapterPerbup(getContext(), mListPerbup);

        mListViewPerbup.setAdapter(adapterPerbup);

        mListViewPerbup.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Perbup perbup = mListPerbup.get(position);

                Intent mIntentPerbup = new Intent(Intent.ACTION_VIEW);
                mIntentPerbup.setData(Uri.parse(perbup.getUrlPerbup()));
                startActivity(mIntentPerbup);
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
