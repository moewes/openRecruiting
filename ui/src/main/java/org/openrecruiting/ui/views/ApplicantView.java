package org.openrecruiting.ui.views;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.openrecruiting.ui.layouts.NewLayout;

@Route(value = "applicants", layout = NewLayout.class)
public class ApplicantView extends VerticalLayout {

  public ApplicantView() {

    HorizontalLayout toolbar = new HorizontalLayout();
    toolbar.setJustifyContentMode(JustifyContentMode.END);

    Button newApplication = new Button();
    newApplication.setText("Neue Bewerbung");
    newApplication.addClickListener(event -> this.getUI().ifPresent(ui -> ui.navigate(ApplicationFormView.class)));

    toolbar.add(newApplication);

    add(toolbar);

    add(new Text("Applicants"));
  }

}
