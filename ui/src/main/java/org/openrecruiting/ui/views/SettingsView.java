package org.openrecruiting.ui.views;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.openrecruiting.ui.layouts.NewLayout;

@Route(value = "settings", layout = NewLayout.class)
public class SettingsView extends VerticalLayout {

  public SettingsView() {
    add(new Text("Settings"));
  }

}
