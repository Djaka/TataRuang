package com.example.djakapermana.tataruang.model;

/**
 * Created by Djaka Permana on 11/06/2017.
 */

public class PerjalananDinas {

    private String idPerjalanan, tanggalPerjalanan, tujuan;
    private double longitude, latitude;

    public PerjalananDinas(String tanggalPerjalanan, String tujuan, double longitude, double latitude) {
        this.tanggalPerjalanan = tanggalPerjalanan;
        this.tujuan = tujuan;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public PerjalananDinas(String tanggalPerjalanan, String tujuan) {
        this.tanggalPerjalanan = tanggalPerjalanan;
        this.tujuan = tujuan;
    }

    public String getIdPerjalanan() {
        return idPerjalanan;
    }

    public String getTanggalPerjalanan() {
        return tanggalPerjalanan;
    }

    public String getTujuan() {
        return tujuan;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }
}
