package com.moraaguiargalindo.application.views.detalleproducto;

import com.moraaguiargalindo.application.views.catalogo.CatalogoView;
import com.moraaguiargalindo.application.views.catalogo.Producto;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
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
        VerticalLayout centroLayout = new VerticalLayout();
        centroLayout.setSizeFull();
        centroLayout.setAlignItems(FlexComponent.Alignment.CENTER);

        centroLayout.add(new H2(producto.getNombre()));
        getContent().add(centroLayout);

        Image imagenProducto = new Image(producto.getRutaImagen(), "No se encontró la imagen");
        imagenProducto.setWidth("100%");
        getContent().add(imagenProducto);

        centroLayout.add(new Span("U$S " + producto.getPrecio()));
        getContent().add(centroLayout);

    }
}

