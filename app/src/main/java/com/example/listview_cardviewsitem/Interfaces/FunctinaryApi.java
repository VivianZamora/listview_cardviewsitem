package com.example.listview_cardviewsitem.Interfaces;

import com.example.listview_cardviewsitem.Models.ListFunctionary;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FunctinaryApi {
    @GET("ws/listadoaevaluar.php?e=1712896529")
    public Call<ListFunctionary> Listar();
}
