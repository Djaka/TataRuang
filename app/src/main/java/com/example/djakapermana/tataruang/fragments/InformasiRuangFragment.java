package com.example.djakapermana.tataruang.fragments;


import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.djakapermana.tataruang.R;
import com.example.djakapermana.tataruang.Rest.JSONResponse;
import com.example.djakapermana.tataruang.Rest.RequestInterface;
import com.example.djakapermana.tataruang.TentangAplikasiFragment;
import com.example.djakapermana.tataruang.adapter.AdapterInfoRuang;
import com.example.djakapermana.tataruang.model.InformasiRuang;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class InformasiRuangFragment extends Fragment {


    public InformasiRuangFragment() {
        // Required empty public constructor
    }

    public static final String BASE_URL = "http://tataruangpupr.net84.net/";
    private ListView mListView;
    private ArrayList<InformasiRuang> mArrayList;
    private AdapterInfoRuang adapterInfoRuang;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);

        View view = inflater.inflate(R.layout.fragment_informasi_ruang, container, false);

        mListView = (ListView) view.findViewById(R.id.list_info_ruang);

        loadJSON();

        return view;
    }


    public void loadJSON(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RequestInterface requestInterface = retrofit.create(RequestInterface.class);
        Call<JSONResponse> call = requestInterface.getJSON();
        final ProgressDialog loading;
        loading = new ProgressDialog(getContext());
        loading.setMax(100);
        loading.setMessage("Mohon Tunggu..");
        loading.setTitle("Extracting Data");
        loading.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        loading.show();

        call.enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {
                loading.dismiss();
                JSONResponse jsonResponse = response.body();
                mArrayList = new ArrayList<InformasiRuang>(Arrays.asList(jsonResponse.getInforuang()));
                adapterInfoRuang = new AdapterInfoRuang(getContext(),mArrayList);

                mListView.setAdapter(adapterInfoRuang);

                mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        InformasiRuang informasiRuang = mArrayList.get(position);

                        MapInformasiRuangFragment mapInformasiRuangFragment = new MapInformasiRuangFragment();

                        Bundle bundle = new Bundle();
                        bundle.putString("namabangunan",informasiRuang.getNama_bangunan());
                        bundle.putString("namapemilik", informasiRuang.getNama_pemilik());
                        bundle.putString("luaslahan", String.valueOf(informasiRuang.getLuas_lahan()));
                        bundle.putString("latitude", String.valueOf(informasiRuang.getLatitude()));
                        bundle.putString("longitude", String.valueOf(informasiRuang.getLongitude()));

                        mapInformasiRuangFragment.setArguments(bundle);

                        getFragmentManager().beginTransaction()
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                .replace(R.id.frame_default, mapInformasiRuangFragment)
                                .addToBackStack(null)
                                .commit();
                    }
                });
            }


            @Override
            public void onFailure(Call<JSONResponse> call, Throwable t) {
                loading.dismiss();
                AlertDialog.Builder mAlertError = new AlertDialog.Builder(getContext());

                mAlertError.setTitle("Koneksi Error");

                mAlertError.setMessage("Klik Refresh Untuk Mengulang")
                        .setCancelable(false)
                        .setPositiveButton("Refresh", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                loadJSON();
                            }
                        });

                AlertDialog alertDialog = mAlertError.create();

                alertDialog.show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_refresh:
                loadJSON();
                return true;
            case R.id.action_tentang:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_default, new TentangAplikasiFragment()).commit();
                getActivity().setTitle(R.string.s_tentang_aplikasi);
                return true;
        }
        return onOptionsItemSelected(item);
    }
}
