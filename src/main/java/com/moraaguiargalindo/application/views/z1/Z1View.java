package com.moraaguiargalindo.application.views.z1;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Z1")
@Route(value = "z1")
@Uses(Icon.class)
public class Z1View extends Composite<VerticalLayout> {

    public Z1View() {
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
    }
}
