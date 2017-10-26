package com.example.djakapermana.tataruang.Rest;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Djaka Permana on 22/06/2017.
 */

public interface RequestInterface {
    @GET("ApiInfoRuang.php")
    Call<JSONResponse> getJSON();
}
