package org.openrecruiting.ui.views;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.openrecruiting.ui.components.AppToolbar;
import org.openrecruiting.ui.components.PaperIconButton;
import org.openrecruiting.ui.layouts.NewLayout;

@Route(value = "newApplication", layout = NewLayout.class)
public class ApplicationFormView extends Div {

  public ApplicationFormView() {

    HorizontalLayout toolbar = new HorizontalLayout();
    //toolbar.setJustifyContentMode(JustifyContentMode.END);

    AppToolbar tb = new AppToolbar();
    PaperIconButton save = new PaperIconButton();
    save.getElement().setProperty("icon","save");
    PaperIconButton cancel = new PaperIconButton();
    cancel.getElement().setProperty("icon","chevron-left");

    tb.add(cancel);
    Div text = new Div();
    text.setText("Neue Bewerbung");
    text.getElement().setAttribute("main-title",true);
    tb.add(text);
    tb.add(save);

    add(tb);

    VerticalLayout vl = new VerticalLayout();

    vl.add(new ApplicantDataForm());

    vl.add(new ApplicantAddressForm());

    add(vl);
  }
}
