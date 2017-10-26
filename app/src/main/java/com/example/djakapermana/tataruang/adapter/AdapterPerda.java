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
import com.example.djakapermana.tataruang.model.Perda;

import java.util.List;

/**
 * Created by Djaka Permana on 13/06/2017.
 */

public class AdapterPerda extends ArrayAdapter<Perda> {
    public AdapterPerda(@NonNull Context context, @NonNull List<Perda> perdas) {
        super(context, 0, perdas);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.list_perda,parent,false);
        }

        Perda perda = getItem(position);

        TextView textView = (TextView) view.findViewById(R.id.txt_nama_perda);
        textView.setText(perda.getNamaPerda());

        return view;
    }
}
