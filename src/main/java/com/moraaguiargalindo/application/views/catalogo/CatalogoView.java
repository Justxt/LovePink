package com.moraaguiargalindo.application.views.catalogo;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.textfield.TextField;


import java.util.ArrayList;
import java.util.List;

@PageTitle("Catalogo")
@Route(value = "catalogo")
@RouteAlias(value = "")
public class CatalogoView extends Composite<VerticalLayout> {


    private final TextField filtro;


    public CatalogoView() {
        VerticalLayout layout = getContent();
        layout.setPadding(true);
        layout.setSpacing(true);

        Image logo = new Image("images/logo.jpeg", "Logo");
        logo.setWidth("20%");
        logo.addClassName("logo");
        getContent().add(logo);

        filtro = new TextField("");
        filtro.setPlaceholder("Buscar productos y mas..");
        filtro.setWidth("100%");
        filtro.addClassName("busqueda");

        getContent().add(filtro);

        Image banner = new Image("images/banner.jpeg", "Banner");
        banner.setWidth("100%");
        banner.addClassName("banner");
        getContent().add(banner);



        List<Producto> productos = obtenerProductos();
        mostrarProductos(productos);

    }


    private List<Producto> obtenerProductos() {
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto("Pantalon Mujer", 499.99, "images/img1.jpeg"));
        productos.add(new Producto("Pantalon faja mujer", 69.99, "images/img2.jpeg"));
        productos.add(new Producto("Consola PlayStation", 499.99, "images/img3.jpeg"));
        productos.add(new Producto("Mando PlayStation", 69.99, "images/img4.jpeg"));
        productos.add(new Producto("Consola Xbox Series X", 499.99, "images/img5.jpeg"));
        productos.add(new Producto("Mando Xbox X/S", 69.99, "images/img6.jpeg"));
        return productos;
    }

    private void mostrarProductos(List<Producto> productos) {
        Div productosVen = new Div();
        productosVen.addClassName("Productos");

        for (Producto producto : productos) {
            Div tarjeta = crearProductos(producto);
            productosVen.add(tarjeta);
        }

        getContent().add(productosVen);
    }

    private Div crearProductos(Producto producto) {
        Div tarjeta = new Div();
        tarjeta.setClassName("ProductosVentas");

        Image imagenProducto = new Image(producto.getRutaImagen(), "No se encontro la img");
        imagenProducto.setHeight("120px");
        imagenProducto.setWidth("120px");

        Div nombrePrecioDiv = new Div();
        nombrePrecioDiv.setText(producto.getNombre() + "\n $" + producto.getPrecio());

        tarjeta.add(imagenProducto, nombrePrecioDiv);

        return tarjeta;
    }
}
