package com.moraaguiargalindo.application.views.detalleproducto;

import com.moraaguiargalindo.application.views.catalogo.CatalogoView;
import com.moraaguiargalindo.application.views.catalogo.Producto;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.OptionalParameter;
import org.springframework.beans.factory.annotation.Autowired;


@Route("detalle-producto")
public class DetalleProductoView extends Composite<Div> implements HasUrlParameter<String> {

    private final CatalogoView catalogoView;

    @Autowired
    public DetalleProductoView(CatalogoView catalogoView) {
        this.catalogoView = catalogoView;
    }
    @Override
    public void setParameter(BeforeEvent event, @OptionalParameter String parameter) {
        if (parameter != null) {
            Producto producto = encontrarProductoPorNombreEnCatalogo(parameter);

            if (producto != null) {
                mostrarDetalleProducto(producto);
            } else {
                getContent().add(new H2("No se encuentra el producto"));
            }
        } else {
            getContent().add(new H2("Producto no encontrado, parametro no valido"));
        }
    }

    private Producto encontrarProductoPorNombreEnCatalogo(String nombre) {
        return catalogoView.obtenerProductos().stream()
                .filter(producto -> producto.getNombre().equals(nombre))
                .findFirst()
                .orElse(null);
    }

    private void mostrarDetalleProducto(Producto producto) {

        //Centrar Producto
        VerticalLayout centroLayout = new VerticalLayout();
        centroLayout.setSizeFull();
        centroLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        centroLayout.add(new H2(producto.getNombre()));
        getContent().add(centroLayout);

        //Imagen Principal
        Image imagenProducto = new Image(producto.getRutaImagen(), "No se encontró la imagen");
        imagenProducto.setWidth("100%");
        getContent().add(imagenProducto);

        //Precio
        centroLayout.add(new Span("U$S " + producto.getPrecio()));
        getContent().add(centroLayout);

        //Cantidad
        IntegerField cantidadField = new IntegerField("Cantidad");
        cantidadField.setMin(1);
        cantidadField.setValue(1);
        centroLayout.add(cantidadField);

        //Carrito
        Button agregarAlCarritoButton = new Button("Agregar al Carrito");
        centroLayout.add(agregarAlCarritoButton);

        //Imagenes
        H4 imagenesDelProducto = new H4("Imagenes del Producto");
        Image imagenesProducto = new Image(producto.getRutaImagen(),"No se encontró la imagen");
        imagenesProducto.setWidth("80%");
        imagenesDelProducto.setClassName("imagenesDelProducto");
        imagenesProducto.setClassName("imagenesProducto");
        getContent().add(imagenesDelProducto, imagenesProducto);

        //Descripciones
        Span descripcionText = new Span(producto.getDescripcion());
        H4 descripcion = new H4("Descripcion");
        descripcion.setClassName("descripcionTitulo");
        descripcionText.setClassName("descrip");
        getContent().add(descripcion,descripcionText);

        //Caracteristicas
        Div caracteristicasDiv = new Div();
        H4 caracteristicasTitulo = new H4("Caracteristicas del Producto");
        caracteristicasTitulo.setClassName("caracteristicasTitulo");
        caracteristicasDiv.addClassName("caracteristicas");

        caracteristicasDiv.add(new Span("Es suave: " + ("Sí")));
        caracteristicasDiv.add(new Span("Tiene algodón: " + ("Sí")));
        caracteristicasDiv.add(new Span("Planchar: " + ("Sí")));
        caracteristicasDiv.add(new Span("Lavadora: " + ("Sí")));

        getContent().add(caracteristicasTitulo, caracteristicasDiv);

    }
}

