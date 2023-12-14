package com.moraaguiargalindo.application.views.adm_agg;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Adm_agg")
@Route(value = "adm1")
@Uses(Icon.class)
public class Adm_aggView extends Composite<VerticalLayout> {

    public Adm_aggView() {
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
    }
}
