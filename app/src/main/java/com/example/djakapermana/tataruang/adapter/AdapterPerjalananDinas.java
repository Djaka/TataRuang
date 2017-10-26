package com.example.djakapermana.tataruang.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.djakapermana.tataruang.R;
import com.example.djakapermana.tataruang.model.PerjalananDinas;

import java.util.List;

/**
 * Created by Djaka Permana on 11/06/2017.
 */

public class AdapterPerjalananDinas  extends ArrayAdapter<PerjalananDinas> {

    public AdapterPerjalananDinas(@NonNull Context context, @NonNull List<PerjalananDinas> perjalananDinases) {
        super(context, 0, perjalananDinases);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;

        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_perjalanan_dinas, parent, false);
        }

        PerjalananDinas perjalananDinas = getItem(position);

        TextView textViewTanggal = (TextView)listItemView.findViewById(R.id.tgl_perjalanan);
        textViewTanggal.setText(perjalananDinas.getTanggalPerjalanan());

        TextView textViewTujuan = (TextView)listItemView.findViewById(R.id.tujuan_perjalanan);
        textViewTujuan.setText(perjalananDinas.getTujuan());

        return listItemView;
    }
}
