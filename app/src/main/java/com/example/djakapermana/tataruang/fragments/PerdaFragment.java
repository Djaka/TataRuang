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
import com.example.djakapermana.tataruang.adapter.AdapterPerda;
import com.example.djakapermana.tataruang.model.Perda;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerdaFragment extends Fragment {


    public PerdaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_perda, container, false);

        final ArrayList<Perda> mListPerda = new ArrayList<Perda>();
        mListPerda.add(new Perda("pp 38 2011 SUNGAI", "https://goo.gl/6M3DjY"));
        mListPerda.add(new Perda("PP No33-1970 HUTAN", "https://goo.gl/BQDSsB"));
        mListPerda.add(new Perda("RTNH","https://goo.gl/VOgpYX"));

        ListView mListViewPerda = (ListView) view.findViewById(R.id.list_perda);

        AdapterPerda adapterPerda = new AdapterPerda(getContext(), mListPerda);

        mListViewPerda.setAdapter(adapterPerda);

        mListViewPerda.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Perda perda = mListPerda.get(position);

                Intent mIntentPerda = new Intent(Intent.ACTION_VIEW);
                mIntentPerda.setData(Uri.parse(perda.getUrlPerda()));
                startActivity(mIntentPerda);
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
