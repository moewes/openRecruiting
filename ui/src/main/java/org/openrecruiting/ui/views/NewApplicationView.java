package org.openrecruiting.ui.views;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.openrecruiting.ui.components.PaperCard;
import org.openrecruiting.ui.layouts.NewLayout;

@Route(value = "test", layout = NewLayout.class)
public class NewApplicationView extends VerticalLayout {

  public NewApplicationView() {

    add(new Text("Hallo Welt"));

    PaperCard card = new PaperCard();

    card.add(new Text("Hallo Card"));

    add(card);
  }

}
