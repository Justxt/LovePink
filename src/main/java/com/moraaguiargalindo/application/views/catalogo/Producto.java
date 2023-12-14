package com.moraaguiargalindo.application.views.catalogo;

public class Producto {
    private String nombre;
    private double precio;
    private String rutaImagen;

    public Producto(String nombre, double precio, String rutaImagen) {
        this.nombre = nombre;
        this.precio = precio;
        this.rutaImagen = rutaImagen;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }
}