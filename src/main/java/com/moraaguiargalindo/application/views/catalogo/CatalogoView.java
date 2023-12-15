package com.moraaguiargalindo.application.views.catalogo;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.component.textfield.TextField;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;

@Component
@PageTitle("Catalogo")
@Route(value = "catalogo")
@RouteAlias(value = "")
@Scope("prototype")
public class CatalogoView extends Composite<VerticalLayout> {


    public CatalogoView() {
        VerticalLayout layout = getContent();
        layout.setPadding(true);
        layout.setSpacing(true);


        Image logo = new Image("images/logo.jpeg", "Logo");
        logo.setWidth("20%");
        logo.addClassName("logo");
        getContent().add(logo);

        TextField filtro = new TextField("");
        filtro.setPlaceholder("Buscar productos y mas..");
        filtro.setWidth("100%");
        filtro.addClassName("busqueda");

        getContent().add(filtro);

        Image banner = new Image("images/banner.jpeg", "Banner");
        banner.setWidth("100%");
        banner.addClassName("banner");
        getContent().add(banner);

        H1 hola2 = new H1("Love Pink");
        Span hola3 = new Span("Jeans con horma Levanta cola o Push up, en Love Pink Jeans siempre creamos modelos de tendencia, " +
                "ofreciendo la mejor calidad y respaldo en cada prenda Colombiana Love Pink Jeans!");
        hola2.addClassName("hola2");
        hola3.addClassName("hola3");

        getContent().add(hola2, hola3);

        List<Producto> productos = obtenerProductos();
        mostrarProductos(productos);

    }


    public List<Producto> obtenerProductos() {
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto("Levanta Cola X", 12.99, "images/img1.jpeg", "Jean azul claro tipo flare para mujer" +
                " cuenta con 5 bolsillos, tiro alto, detalles con rotos en frente, bota ancha y un fit ajustado desde la cadera hasta la rodilla." +
                " Crea un total look vintage combinando esta prenda con una blusa y unos botines, lucirás fenomenal para salir de compras" +
                " con tus amigas al centro comercial."));

        productos.add(new Producto("Pantalon Caderas", 11.99, "images/img2.jpeg", "Jean azul claro tipo flare para mujer" +
                " cuenta con 5 bolsillos, tiro alto, detalles con rotos en frente, bota ancha y un fit ajustado desde la cadera hasta la rodilla." +
                " Crea un total look vintage combinando esta prenda con una blusa y unos botines, lucirás fenomenal para salir de compras" +
                " con tus amigas al centro comercial."));

        productos.add(new Producto("Faja Algodon Su", 9.99, "images/img3.jpeg", "Jean azul claro tipo flare para mujer" +
                " cuenta con 5 bolsillos, tiro alto, detalles con rotos en frente, bota ancha y un fit ajustado desde la cadera hasta la rodilla." +
                " Crea un total look vintage combinando esta prenda con una blusa y unos botines, lucirás fenomenal para salir de compras" +
                " con tus amigas al centro comercial."));

        productos.add(new Producto("Sosten Algodon", 6.99, "images/img4.jpeg", "Jean azul claro tipo flare para mujer" +
                " cuenta con 5 bolsillos, tiro alto, detalles con rotos en frente, bota ancha y un fit ajustado desde la cadera hasta la rodilla." +
                " Crea un total look vintage combinando esta prenda con una blusa y unos botines, lucirás fenomenal para salir de compras" +
                " con tus amigas al centro comercial."));

        productos.add(new Producto("Pantalon Mujer", 12.99, "images/img5.jpeg", "Jean azul claro tipo flare para mujer" +
                " cuenta con 5 bolsillos, tiro alto, detalles con rotos en frente, bota ancha y un fit ajustado desde la cadera hasta la rodilla." +
                " Crea un total look vintage combinando esta prenda con una blusa y unos botines, lucirás fenomenal para salir de compras" +
                " con tus amigas al centro comercial."));

        productos.add(new Producto("Faja Algodon Su", 9.99, "images/img3.jpeg", "Jean azul claro tipo flare para mujer" +
                " cuenta con 5 bolsillos, tiro alto, detalles con rotos en frente, bota ancha y un fit ajustado desde la cadera hasta la rodilla." +
                " Crea un total look vintage combinando esta prenda con una blusa y unos botines, lucirás fenomenal para salir de compras" +
                " con tus amigas al centro comercial."));

        productos.add(new Producto("Sosten Poliestireno", 12.99, "images/img4.jpeg", "Jean azul claro tipo flare para mujer" +
                " cuenta con 5 bolsillos, tiro alto, detalles con rotos en frente, bota ancha y un fit ajustado desde la cadera hasta la rodilla." +
                " Crea un total look vintage combinando esta prenda con una blusa y unos botines, lucirás fenomenal para salir de compras" +
                " con tus amigas al centro comercial."));
        return productos;
    }

    public void mostrarProductos(List<Producto> productos) {
        Div productosVen = new Div();
        productosVen.addClassName("Productos");

        for (Producto producto : productos) {
            Div tarjeta = crearProductos(producto);
            productosVen.add(tarjeta);
        }

        getContent().add(productosVen);
    }

    public Div crearProductos(Producto producto) {
        Div tarjeta = new Div();
        tarjeta.setClassName("ProductosVentas");

        Image imagenProducto = new Image(producto.getRutaImagen(), "No se encontro la img");
        imagenProducto.setHeight("120px");
        imagenProducto.setWidth("120px");

        Div nombrePrecioDiv = new Div();
        nombrePrecioDiv.setText(producto.getNombre() + "\n $" + producto.getPrecio());

        tarjeta.addClickListener(e -> getUI().ifPresent(ui ->
                ui.navigate(com.moraaguiargalindo.application.views.detalleproducto.DetalleProductoView.class, producto.getNombre())));


        tarjeta.add(imagenProducto, nombrePrecioDiv);

        return tarjeta;
    }
}
