package com.moraaguiargalindo.application.views.catalogo;

public class Producto {
    private String nombre;
    private double precio;
    private String rutaImagen;
    private String descripcion;

    public Producto(String nombre, double precio, String rutaImagen, String descripcion) {
        this.nombre = nombre;
        this.precio = precio;
        this.rutaImagen = rutaImagen;
        this.descripcion = descripcion;
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

    public String getDescripcion() {
        return descripcion;
    }
}