package org.openrecruiting.ui.views;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.openrecruiting.ui.layouts.NewLayout;

@Route(value = "joboffers", layout = NewLayout.class)
public class JobofferView extends VerticalLayout {

  public JobofferView() {
    add(new Text("Joboffers"));
  }

}
