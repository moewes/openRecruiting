package org.openrecruiting.ui.views;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.openrecruiting.ui.layouts.NewLayout;

@Route(value = "vacancies", layout = NewLayout.class)
public class VacancyView extends VerticalLayout {

  public VacancyView() {
    add(new Text("Vakancies"));
  }

}
