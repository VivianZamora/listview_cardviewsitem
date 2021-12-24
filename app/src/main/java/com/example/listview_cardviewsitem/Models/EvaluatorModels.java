package com.example.listview_cardviewsitem.Models;

public class EvaluatorModels {

    private String idevaluador="";
    private String nombres="";
    private String imgJPG="";
    private String imgjpg="";
    private String area="";
    private String imgDefault="https://uealecpeterson.net/ws/adminimg/unknown.png";

    public EvaluatorModels(String idevaluador, String nombres, String imgJPG, String imgjpg, String area) {
        this.idevaluador = idevaluador;
        this.nombres = nombres;
        this.imgJPG = imgJPG;
        this.imgjpg = imgjpg;
        this.area = area;
    }

    public String getIdevaluador() {
        return idevaluador;
    }

    public void setIdevaluador(String idevaluador) {
        this.idevaluador = idevaluador;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getImgDefault() {
        return imgDefault;
    }
}
