package org.openrecruiting.ui.views;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.openrecruiting.ui.layouts.NewLayout;

@Route(value = "tasks", layout = NewLayout.class)
public class TaskView extends VerticalLayout {

  public TaskView() {
    add(new Text("Tasks"));
  }

}
