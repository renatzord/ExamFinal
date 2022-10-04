package com.example.renato_llivisaca_exam.Api;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UsuarioService {
    @GET("users.json")
    Call<ResObject> getEarthQuakes();
}
