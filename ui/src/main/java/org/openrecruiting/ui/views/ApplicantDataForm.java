package org.openrecruiting.ui.views;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.textfield.TextField;


public class ApplicantDataForm extends FormLayout {

  private TextField anrede = new TextField("Anrede");
  private TextField vorname = new TextField("Vorname");
  private TextField nachname = new TextField("Nachname");
  private TextField geburtsdatum = new TextField("Geburtsdatum");

  public ApplicantDataForm() {

    setResponsiveSteps( new ResponsiveStep("0",1, ResponsiveStep.LabelsPosition.TOP));

    H5 header = new H5("Bewerber");
    header.setSizeFull();

    add(header);
    add(anrede);
    add(vorname);
    add(nachname);
    add(geburtsdatum);
  }

}
