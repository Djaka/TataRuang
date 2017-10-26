package com.example.djakapermana.tataruang.fragments;


import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.djakapermana.tataruang.R;

import java.lang.reflect.Array;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        Resources resources = getResources();
        String[] mListMisi = resources.getStringArray(R.array.s_misi);

        TextView textViewMisi = (TextView) view.findViewById(R.id.txt_misi);

        StringBuilder builder = new StringBuilder();

        for (String s:mListMisi){
            builder.append(s).append("\n");
            textViewMisi.setText(builder.toString());
        }

        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        MenuItem item = menu.findItem(R.id.action_refresh);
        item.setVisible(false);
    }
}
