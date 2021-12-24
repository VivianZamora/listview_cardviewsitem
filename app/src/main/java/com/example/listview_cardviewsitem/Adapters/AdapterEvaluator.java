package com.example.listview_cardviewsitem.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.listview_cardviewsitem.FuntionaryActivity;
import com.example.listview_cardviewsitem.Models.EvaluatorModels;
import com.example.listview_cardviewsitem.R;
import com.google.gson.Gson;

import java.util.List;

public class AdapterEvaluator extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<EvaluatorModels> ListEvalua;
    Context context;


    public AdapterEvaluator(List<EvaluatorModels> listEvalua, Context context) {
         ListEvalua = listEvalua;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //View view= LayoutInflater.from(context).inflate(R.layout.list_items_eva,parent,false);
        //return new VistaTarjeta(view);

        LayoutInflater inf= LayoutInflater.from(context);
        View view=inf.inflate(R.layout.list_items_eva,null);
        //LayoutInflater.from(parent.getContext()).inflate(R.layout.item_elementos, parent, false);
        VistaTarjeta viewT=new VistaTarjeta(view);
        Log.e("main", "Adapter1");
        return viewT;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Log.e("main", "Adapter1");
        EvaluatorModels card = ListEvalua.get(position);
        VistaTarjeta myholder = (VistaTarjeta) holder;
        Log.e("main", "Adapter");
        myholder.Area.setText(card.getArea());
        myholder.Nombres.setText(card.getNombres());
        myholder.Identificacion.setText(card.getIdevaluador());


        try {
            boolean b= URLUtil.isValidUrl(ListEvalua.get(position).getImgjpg());
            if(b)
                Glide.with(context).load(ListEvalua.get(position).getImgjpg()).error("https://uealecpeterson.net/ws/adminimg/unknown.png").into(myholder.Image);
            else
            {
                Log.e("mensaje:","hola falso ");
            }
        }catch (Exception ex){
            Log.e("Error Glide Imagen: ", ex.getMessage());

        }

        ///
        myholder.Cardi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, "Position: "+position, Toast.LENGTH_SHORT).show();
                viewFuntionary(card);
            }
        });
    }




    @Override
    public int getItemCount() {
        return 0;
    }



    public void viewFuntionary(EvaluatorModels card){
        try {
            Intent intent = new Intent(context, FuntionaryActivity.class);
            Bundle b = new Bundle();
            Gson gson = new Gson();
            String json = gson.toJson(card);
            b.putString("Data", json);
            intent.putExtras(b);
            context.startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
        }catch (Exception e)
        {
            Toast.makeText(context, "Error:  "+e, Toast.LENGTH_SHORT).show();
            Log.e("Error_viewFuntionary", e.getMessage());
        }
    }

    public static class VistaTarjeta extends RecyclerView.ViewHolder{
        ImageView Image;
        TextView Area;
        TextView Nombres;
        TextView Identificacion;
        CardView Cardi;
        public VistaTarjeta(@NonNull View view) {
            super(view);

            Image= view.findViewById(R.id.Imagen);
            Area= view.findViewById(R.id.Area);
            Nombres= view.findViewById(R.id.Nombres);
            Identificacion= view.findViewById(R.id.Identificacion);
            Cardi= view.findViewById(R.id.Cardi);

        }
    }
}
