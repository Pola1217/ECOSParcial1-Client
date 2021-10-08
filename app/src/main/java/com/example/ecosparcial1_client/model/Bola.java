package com.example.ecosparcial1_client.model;

public class Bola {

    private int posX, posY, cant, r, g, b;
    private String datos;
    private boolean crear, borrar;

   /* public Bola() {
        this.posX = 0;
        this.posY = 0;
        this.tam = 30;
    }*/
// int cant
    public Bola(int posX, int posY, int r, int g, int b, String datos, boolean crear, boolean borrar, int cant) {

        this.posX = posX;
        this.posY = posY;

        this.cant = cant;

        this.r = r;
        this.g = g;
        this.b = b;

        this.datos = datos;

        this.crear = crear;
        this.borrar = borrar;

    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public String getDatos() {
        return datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }

    public boolean isCrear() {
        return crear;
    }

    public void setCrear(boolean crear) {
        this.crear = crear;
    }

    public boolean isBorrar() {
        return borrar;
    }

    public void setBorrar(boolean borrar) {
        this.borrar = borrar;
    }

    @Override
    public String toString() {

        return this.posX + ":" + this.posY + ":" + this.r + ":" + this.g + ":" + this.b;

    }
}
