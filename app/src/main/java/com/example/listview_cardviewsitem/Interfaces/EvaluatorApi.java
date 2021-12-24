package com.example.listview_cardviewsitem.Interfaces;

import com.example.listview_cardviewsitem.Models.ListEvaluator;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EvaluatorApi {
    @GET("ws/listadoevaluadores.php")
    public Call<ListEvaluator> Listar();
}
