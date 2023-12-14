package com.moraaguiargalindo.application.views.z2;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Z2")
@Route(value = "z2")
@Uses(Icon.class)
public class Z2View extends Composite<VerticalLayout> {

    public Z2View() {
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
    }
}
