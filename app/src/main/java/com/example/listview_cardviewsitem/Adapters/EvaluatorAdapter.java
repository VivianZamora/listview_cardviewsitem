package com.example.listview_cardviewsitem.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;
import com.example.listview_cardviewsitem.FuntionaryActivity;
import com.example.listview_cardviewsitem.Models.EvaluatorModels;
import com.example.listview_cardviewsitem.R;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import retrofit2.http.Url;
import retrofit2.internal.EverythingIsNonNull;

public class EvaluatorAdapter extends ArrayAdapter {

    private List<EvaluatorModels> ListEvalua;
    Context context;
    private int HeaderType = 1;
    public EvaluatorAdapter(@NonNull Context context, List<EvaluatorModels> ListEvalua) {
        super(context, R.layout.list_items_eva,ListEvalua);
        this.ListEvalua=ListEvalua;
        this.context=context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        View view= LayoutInflater.from(context).inflate(R.layout.list_items_eva,parent,false);
        ImageView Image= view.findViewById(R.id.Imagen);
        TextView Area= view.findViewById(R.id.Area);
        TextView Nombres= view.findViewById(R.id.Nombres);
        TextView Identificacion= view.findViewById(R.id.Identificacion);

        Area.setText(ListEvalua.get(position).getArea());
        Nombres.setText("NOMBRE: "+ListEvalua.get(position).getNombres());
        Identificacion.setText("IDENTIFICACIÓN: "+ListEvalua.get(position).getIdevaluador());


            try {
                boolean b=URLUtil.isValidUrl(ListEvalua.get(position).getImgjpg());
                if(b)
                Glide.with(context).load(ListEvalua.get(position).getImgjpg()).error("https://uealecpeterson.net/ws/adminimg/unknown.png").into(Image);
                else
                {
                    Log.e("mensaje:","hola falso ");
                }
            }catch (Exception ex){
                Log.e("Error Glide Imagen: ", ex.getMessage());

            }





        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Position: "+position, Toast.LENGTH_SHORT).show();
                viewFuntionary();
            }
        });
        return view;

    }

    public void viewFuntionary(){
        try {
            Intent intent = new Intent(context,FuntionaryActivity.class);
            Bundle b = new Bundle();
            Gson gson = new Gson();
            String json = gson.toJson(this.ListEvalua);
            b.putString("Data", json);
            intent.putExtras(b);
            context.startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
        }catch (Exception e)
        {
            Toast.makeText(context, "Error:  "+e, Toast.LENGTH_SHORT).show();
            Log.e("Error_viewFuntionary", e.getMessage());
        }
    }


}
