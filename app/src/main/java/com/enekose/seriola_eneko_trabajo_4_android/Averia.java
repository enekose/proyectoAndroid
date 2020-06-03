package com.enekose.seriola_eneko_trabajo_4_android;

import java.io.Serializable;

public class Averia implements Serializable {
    private String titulo;
    private String modeloCoche;
    private String urlFoto;
    private Integer numeroImpuestos;

    public Averia(String titulo, String modeloCoche, String urlFoto, Integer numeroImpuestos) {
        this.titulo = titulo;
        this.modeloCoche = modeloCoche;
        this.urlFoto = urlFoto;
        this.numeroImpuestos = numeroImpuestos;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getModeloCoche() {
        return modeloCoche;
    }

    public void setModeloCoche(String modeloCoche) {
        this.modeloCoche = modeloCoche;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public Integer getNumeroImpuestos() {
        return numeroImpuestos;
    }

    public void setNumeroImpuestos(Integer numeroImpuestos) {
        this.numeroImpuestos = numeroImpuestos;
    }
}
