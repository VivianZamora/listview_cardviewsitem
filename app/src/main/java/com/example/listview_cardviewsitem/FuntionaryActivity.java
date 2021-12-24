package com.example.listview_cardviewsitem;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listview_cardviewsitem.Adapters.AdapterFunctionary;
import com.example.listview_cardviewsitem.Adapters.EvaluatorAdapter;
import com.example.listview_cardviewsitem.Interfaces.EvaluatorApi;
import com.example.listview_cardviewsitem.Interfaces.FunctinaryApi;
import com.example.listview_cardviewsitem.Models.EvaluatorModels;
import com.example.listview_cardviewsitem.Models.Functionary;
import com.example.listview_cardviewsitem.Models.ListEvaluator;
import com.example.listview_cardviewsitem.Models.ListFunctionary;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FuntionaryActivity extends AppCompatActivity {

    RecyclerView listView;
    Context Ctx;
    View Prueba;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funtionary);
        CasoRetro();
    }

    private void CasoRetro() {
        /*tvInformacion.setText("");
        tvInformacion.append("RETROFIT \n");*/
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://www.uealecpeterson.net/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        FunctinaryApi functionaryApi = retrofit.create(FunctinaryApi.class);
        Call<ListFunctionary> call = functionaryApi.Listar();
        call.enqueue(new Callback<ListFunctionary>() {
            @Override
            public void onResponse(Call<ListFunctionary> call, Response<ListFunctionary> response) {
                try {
                    if (response.isSuccessful()) {

                        ListFunctionary R = response.body();
                        List<Functionary> EvaList = R.getListaaevaluar();
                        AdapterFunctionary adaptador = new AdapterFunctionary(EvaList,Ctx);
                        listView.setAdapter(adaptador);
                        /*listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                Toast.makeText(MainActivity.this, "Position:  "+position, Toast.LENGTH_SHORT).show();
                            }
                        });*/
                        return;

                    }
                } catch (Exception ex) {
                    Log.e("error: ", ex.getMessage());
                }

            }

            @Override
            public void onFailure(Call<ListEvaluator> call, Throwable t) {
                Log.e("Retrofit", t.getMessage());

            }


        });


    }

}
