package com.example.djakapermana.tataruang.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.djakapermana.tataruang.R;
import com.example.djakapermana.tataruang.model.Perbup;

import java.util.List;

/**
 * Created by Djaka Permana on 13/06/2017.
 */

public class AdapterPerbup extends ArrayAdapter<Perbup> {

    public AdapterPerbup(@NonNull Context context, @NonNull List<Perbup> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.list_perbup, parent, false);
        }

        Perbup perbup = getItem(position);

        TextView textViewNamaPerbup = (TextView) view.findViewById(R.id.txt_nama_perbup);
        textViewNamaPerbup.setText(perbup.getNamaPerbup());

        return view;
    }
}
