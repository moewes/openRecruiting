package org.openrecruiting.ui.views;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.openrecruiting.ui.layouts.NewLayout;

@Route(value = "applicants", layout = NewLayout.class)
public class ApplicantView extends VerticalLayout {

  public ApplicantView() {
    add(new Text("Applicants"));
  }

}
