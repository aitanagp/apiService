package com.example.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    @GET("matricula/{year}/{id}")
    Call<Matricula> getMatricula(@Path("year") int year, @Path("id") int id);

    <Usuario> Call<List<Usuario>> getUsuarios();
}
