package com.example.djakapermana.tataruang.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.djakapermana.tataruang.R;

/**
 * Created by Djaka Permana on 02/07/2017.
 */

public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView textViewNamaBangunan, textViewAlamat, textViewLuasLahan, textViewPemilik;

    private ItemClickListener itemClickListener;

    public ViewHolder(View view) {
        super(view);

        textViewNamaBangunan = (TextView) view.findViewById(R.id.txt_nama_bangunan);
        textViewAlamat = (TextView) view.findViewById(R.id.txt_alamat);
        textViewLuasLahan = (TextView) view.findViewById(R.id.txt_luas_lahan);
        textViewPemilik = (TextView) view.findViewById(R.id.txt_pemilik);

        view.setOnClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v, getLayoutPosition());
    }
}
