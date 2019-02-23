package org.openrecruiting.ui.views;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.openrecruiting.ui.components.PaperCard;
import org.openrecruiting.ui.layouts.NewLayout;

@Route(value = "search", layout = NewLayout.class)
public class SearchView extends VerticalLayout {

  public SearchView() {

    add(new Text("Search"));

    PaperCard card = new PaperCard();

    card.add(new Text("Hallo Card"));

    add(card);
  }

}
