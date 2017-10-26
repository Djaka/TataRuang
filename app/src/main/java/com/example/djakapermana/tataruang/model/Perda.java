package com.example.djakapermana.tataruang.model;

import java.net.URL;

/**
 * Created by Djaka Permana on 13/06/2017.
 */

public class Perda {

    private String namaPerda;
    private String urlPerda;

    public Perda(String namaPerda, String urlPerda) {
        this.namaPerda = namaPerda;
        this.urlPerda = urlPerda;
    }

    public Perda(String namaPerda) {
        this.namaPerda = namaPerda;
    }

    public String getNamaPerda() {
        return namaPerda;
    }

    public String getUrlPerda() {
        return urlPerda;
    }
}
