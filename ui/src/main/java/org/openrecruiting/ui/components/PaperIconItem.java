package org.openrecruiting.ui.components;

import com.vaadin.flow.component.*;
import com.vaadin.flow.component.dependency.HtmlImport;

@Tag("paper-icon-item")
@HtmlImport("bower_components/paper-item/paper-icon-item.html")
public class PaperIconItem extends Component implements HasComponents, HasSize {

  public PaperIconItem(String icon, String text) {

    IronIcon ironIcon = new IronIcon();
    ironIcon.getElement().setProperty("icon", icon);
    ironIcon.getElement().setProperty("slot", "item-icon");
    add(ironIcon);
    add(new Text(text));
    setWidth("100%");
  }

  @SuppressWarnings("unchecked")
  public void addClickListener(
          ComponentEventListener<ClickEvent<PaperIconButton>> listener) {
    addListener(ClickEvent.class, (ComponentEventListener) listener);
  }
}
