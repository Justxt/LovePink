package com.moraaguiargalindo.application.views.promos;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.html.Image;

@PageTitle("Promos")
@Route(value = "promos")
@Uses(Icon.class)
public class PromosView extends Composite<VerticalLayout> {

    public PromosView() {
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");

        Image h = new Image("images/img.png", "logo");
        getContent().add(h);
    }
}
