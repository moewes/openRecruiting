package org.openrecruiting.ui.views;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.openrecruiting.ui.layouts.NewLayout;

@Route(value = "reports", layout = NewLayout.class)
public class ReportView extends VerticalLayout {

  public ReportView() {
    add(new Text("Reports"));
  }

}
