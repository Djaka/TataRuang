package com.example.djakapermana.tataruang.adapter;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.djakapermana.tataruang.R;
import com.example.djakapermana.tataruang.fragments.MapInformasiRuangFragment;
import com.example.djakapermana.tataruang.model.InformasiRuang;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Djaka Permana on 11/06/2017.
 */


//class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

//    @Override
//    public boolean onLongClick(View v) {
//        itemClickListener.onClick(v, getAdapterPosition(),false);
//        return false;
//    }
//}

public class AdapterInfoRuang extends ArrayAdapter<InformasiRuang> {
    public AdapterInfoRuang(@NonNull Context context, @NonNull List<InformasiRuang> informasiRuangs) {
        super(context, 0, informasiRuangs);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView==null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_info_ruang, parent, false);
        }

        InformasiRuang informasiRuang = getItem(position);

        TextView textViewNamaBangunan = (TextView) listItemView.findViewById(R.id.txt_nama_bangunan);
        textViewNamaBangunan.setText(informasiRuang.getNama_bangunan());

        TextView textViewAlamat = (TextView) listItemView.findViewById(R.id.txt_alamat);
        textViewAlamat.setText(informasiRuang.getAlamat_pemilik());

        TextView textViewLuasLahan = (TextView) listItemView.findViewById(R.id.txt_luas_lahan);
        textViewLuasLahan.setText(informasiRuang.getLuas_lahan() + " m²");

        TextView textViewPemilik = (TextView) listItemView.findViewById(R.id.txt_pemilik);
        textViewPemilik.setText(informasiRuang.getNama_pemilik());

        return listItemView;
    }

    //    private ArrayList<InformasiRuang>  mArrayList;
//    private Context mContext;
//
//    public AdapterInfoRuang(ArrayList<InformasiRuang> mArrayList, Context mContext) {
//        this.mArrayList = mArrayList;
//        this.mContext = mContext;
//    }
//
//    @Override
//    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
//        View view = inflater.inflate(R.layout.list_info_ruang, parent,false);
//
//        return new ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(ViewHolder holder, int position) {
//        holder.textViewNamaBangunan.setText(mArrayList.get(position).getNama_bangunan());
//        holder.textViewAlamat.setText(mArrayList.get(position).getAlamat_pemilik());
//        holder.textViewLuasLahan.setText(mArrayList.get(position).getLuas_lahan());
//        holder.textViewPemilik.setText(mArrayList.get(position).getNama_pemilik());
//
//        holder.setItemClickListener(new ItemClickListener() {
//            @Override
//            public void onClick(View view, int position) {
//
//                MapInformasiRuangFragment mapInformasiRuangFragment = new MapInformasiRuangFragment();
//
//                Bundle bundle = new Bundle();
//                bundle.putString("namabangunan", mArrayList.get(position).getNama_bangunan());
//                bundle.putString("namapemilik", mArrayList.get(position).getNama_pemilik());
//                bundle.putString("luaslahan", mArrayList.get(position).getLuas_lahan());
//                bundle.putString("latitude", mArrayList.get(position).getLatitude());
//                bundle.putString("longitude", mArrayList.get(position).getLongitude());
//
//                mapInformasiRuangFragment.setArguments(bundle);
//
//
//                mapInformasiRuangFragment.getFragmentManager().beginTransaction()
//                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
//                        .replace(R.id.frame_default, mapInformasiRuangFragment)
//                        .addToBackStack(null)
//                        .commit();
//
//                Toast.makeText(mContext, " " + mArrayList.get(position).getNama_bangunan(), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//
//
//    @Override
//    public int getItemCount() {
//        return mArrayList.size();
//    }

//    private ArrayList<InformasiRuang> mFilteredList;
//    ItemClickListener listener;
//    Context context;

//    public AdapterInfoRuang(ArrayList<InformasiRuang> mArrayList) {
//        this.mArrayList = mArrayList;
//        this.mFilteredList = mArrayList;
//    }

//    @Override
//    public AdapterInfoRuang.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
//        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_info_ruang, viewGroup, false);
//        final ViewHolder viewHolder = new ViewHolder(view);
//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                listener.onItemClick(v, viewHolder.getPosition());
//            }
//        });
//        return viewHolder;
//    }
//
//    @Override
//    public void onBindViewHolder(AdapterInfoRuang.ViewHolder viewHolder, int i) {
//        viewHolder.textViewNamaBangunan.setText(mFilteredList.get(i).getNama_bangunan());
//        viewHolder.textViewAlamat.setText(mFilteredList.get(i).getAlamat_pemilik());
//        viewHolder.textViewLuasLahan.setText(mFilteredList.get(i).getLuas_lahan());
//        viewHolder.textViewPemilik.setText(mFilteredList.get(i).getNama_pemilik());
//    }
//
//    @Override
//    public int getItemCount() {
//        return mFilteredList.size();
//    }

    //    @Override
//    public Filter getFilter() {
//        return new Filter() {
//            @Override
//            protected FilterResults performFiltering(CharSequence charSequence) {
//
//                String charString = charSequence.toString();
//
//                if(charString.isEmpty()){
//                    mFilteredList = mArrayList;
//                }else {
//                    ArrayList<InformasiRuang> filteredList = new ArrayList<>();
//
//                    for (InformasiRuang informasiRuang : mArrayList){
//                        if (informasiRuang.getNama_bangunan().toLowerCase().contains(charString)){
//                            filteredList.add(informasiRuang);
//                        }
//                    }
//
//                    mFilteredList = filteredList;
//                }
//
//                FilterResults filterResults = new FilterResults();
//                filterResults.values = mFilteredList;
//                return filterResults;
//            }
//
//            @Override
//            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
//                mFilteredList = (ArrayList<InformasiRuang>) filterResults.values;
//                notifyDataSetChanged();
//            }
//        };
//    }

}