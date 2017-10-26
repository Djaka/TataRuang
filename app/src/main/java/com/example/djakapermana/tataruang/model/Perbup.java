package com.example.djakapermana.tataruang.model;

import java.net.URL;

/**
 * Created by Djaka Permana on 13/06/2017.
 */

public class Perbup {

    private String namaPerbup, urlPerbup;

    public Perbup(String namaPerbup, String urlPerbup) {
        this.namaPerbup = namaPerbup;
        this.urlPerbup = urlPerbup;
    }

    public String getNamaPerbup() {
        return namaPerbup;
    }

    public String getUrlPerbup() {
        return urlPerbup;
    }
}
