package com.example.listview_cardviewsitem.Models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Functionary {
    private String id="";
    private String idevaluado="";
    private String Nombres="";
    private String genero="";
    private String situacion="";
    private String cargo="";
    private String fechainicio="";
    private String fechafin="";
    private String imgJPG="";
    private String imgjpg="";

    public Functionary() {
    }

    public Functionary(JSONObject Obj) throws JSONException {

        this.id = Obj.getString("id").toString() ;
        this.idevaluado = idevaluado;
        Nombres = Obj.getString("Nombres").toString() ;
        this.genero = Obj.getString("genero").toString() ;
        this.situacion = Obj.getString("situacion").toString() ;
        this.cargo = Obj.getString("cargo").toString() ;
        this.fechainicio = Obj.getString("fechainicio").toString() ;
        this.fechafin = Obj.getString("fechafin").toString() ;
        this.imgJPG = Obj.getString("imgJPG").toString() ;
        this.imgjpg = Obj.getString("imgjpg").toString() ;
    }
    public static ArrayList<Functionary> JsonArrayALista(JSONArray datos) throws JSONException {
        ArrayList<Functionary> Functionaries= new ArrayList<>();

        for (int i = 0; i < datos.length() && i<20; i++) {
            Functionaries.add(new Functionary(datos.getJSONObject(i)));
        }
        return Functionaries;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdevaluado() {
        return idevaluado;
    }

    public void setIdevaluado(String idevaluado) {
        this.idevaluado = idevaluado;
    }

    public String getNombre() {
        return Nombres;
    }

    public void setNombre(String nombre) {
        this.Nombres = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSituacion() {
        return situacion;
    }

    public void setSituacion(String situacion) {
        this.situacion = situacion;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(String fechainicio) {
        this.fechainicio = fechainicio;
    }

    public String getFechafin() {
        return fechafin;
    }

    public void setFechafin(String fechafin) {
        this.fechafin = fechafin;
    }

    public String getImgJPG() {
        return imgJPG;
    }

    public void setImgJPG(String imgJPG) {
        this.imgJPG = imgJPG;
    }

    public String getImgjpg() {
        return imgjpg;
    }

    public void setImgjpg(String imgjpg) {
        this.imgjpg = imgjpg;
    }
}
