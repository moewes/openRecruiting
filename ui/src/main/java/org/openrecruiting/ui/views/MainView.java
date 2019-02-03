package org.openrecruiting.ui.views;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Input;
import com.vaadin.flow.router.Route;

@Route("")
public class MainView extends Div {

  public MainView() {
    Text t = new Text("Hallo");

    add(t);

    Input i = new Input();
    add(i);
  }

}
