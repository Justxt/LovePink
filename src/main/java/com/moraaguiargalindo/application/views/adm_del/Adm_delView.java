package com.moraaguiargalindo.application.views.adm_del;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Adm_del")
@Route(value = "administrado2")
@Uses(Icon.class)
public class Adm_delView extends Composite<VerticalLayout> {

    public Adm_delView() {
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
    }
}
