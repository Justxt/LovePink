package com.moraaguiargalindo.application.views.catalogo;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.component.html.Image;

import java.util.ArrayList;
import java.util.List;

@PageTitle("Catalogo")
@Route(value = "catalogo")
@RouteAlias(value = "")
public class CatalogoView extends Composite<VerticalLayout> {


    public CatalogoView() {
        VerticalLayout layout = getContent();
        layout.setPadding(true);
        layout.setSpacing(true);

        List<Producto> productos = obtenerProductos();

        mostrarProductos(productos);
    }

    private List<Producto> obtenerProductos() {
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto("Consola XBOX", 499.99, "images/img1.png"));
        productos.add(new Producto("Mando XBOX", 69.99, "images/img2.png"));
        productos.add(new Producto("Consola PlayStation", 499.99, "images/img1.png"));
        productos.add(new Producto("Mando PlayStation", 69.99, "images/img2.png"));
        productos.add(new Producto("Consola XBOX", 499.99, "images/img1.png"));
        productos.add(new Producto("Mando XBOX", 69.99, "images/img2.png"));
        productos.add(new Producto("Consola PlayStation", 499.99, "images/img1.png"));
        productos.add(new Producto("Mando PlayStation", 69.99, "images/img2.png"));

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
        imagenProducto.setHeight("150px");
        imagenProducto.setWidth("150px");

        Div nombrePrecioDiv = new Div();
        nombrePrecioDiv.setText(producto.getNombre() + "\n $" + producto.getPrecio());

        tarjeta.add(imagenProducto, nombrePrecioDiv);

        return tarjeta;
    }
}
