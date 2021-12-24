package com.example.listview_cardviewsitem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.listview_cardviewsitem.Adapters.AdapterEvaluator;
import com.example.listview_cardviewsitem.Adapters.EvaluatorAdapter;
import com.example.listview_cardviewsitem.Interfaces.EvaluatorApi;
import com.example.listview_cardviewsitem.Models.EvaluatorModels;
import com.example.listview_cardviewsitem.Models.ListEvaluator;

import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView RecytView;
    Context Ctx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecytView=findViewById(R.id.listView);
        View header = getLayoutInflater().inflate(R.layout.h_list_eva, null);
       // RecytView.addHeaderView(header);
       // Prueba=findViewById(R.id.tvPrueba);
        Ctx=this;
        Log.e("main", "primero");
        CasoRetro();
    }







    private void CasoRetro() {
        /*tvInformacion.setText("");
        tvInformacion.append("RETROFIT \n");*/
        Log.e("main", "retro");
        //Toast.makeText(Ctx,"retro",100).show();
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://www.uealecpeterson.net/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        EvaluatorApi evaluatorApi = retrofit.create(EvaluatorApi.class);
        Call<ListEvaluator> call = evaluatorApi.Listar();
        call.enqueue(new Callback<ListEvaluator>() {
            @Override
            public void onResponse(Call<ListEvaluator> call, Response<ListEvaluator> response) {
                try {
                    if (response.isSuccessful()) {
                        Log.e("main", "retro");
                        ListEvaluator R = response.body();
                        List<EvaluatorModels> EvaList = R.getListaaevaluador();
                        Log.e("main", "size "+EvaList.size());
                        LinearLayoutManager linMana= new LinearLayoutManager(MainActivity.this);
                        RecytView.setLayoutManager(linMana);
                        AdapterEvaluator ada = new AdapterEvaluator (EvaList,Ctx);
                        RecytView.setAdapter(ada);

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