package org.openrecruiting.ui.views;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.textfield.TextField;

public class ApplicantAddressForm extends FormLayout {

  private TextField street = new TextField(getTranslation("street"));
  private TextField town = new TextField("town");
  private TextField zipcode = new TextField("zipcode");

  public ApplicantAddressForm() {

    setResponsiveSteps( new ResponsiveStep("0",1, ResponsiveStep.LabelsPosition.TOP));

    add(new H5("Adresse"));

    street.setRequiredIndicatorVisible(true);

    add(street);

    zipcode.setMaxLength(5);

    add(zipcode);
    add(town);
  }
}
