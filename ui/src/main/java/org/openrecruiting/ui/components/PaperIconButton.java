package org.openrecruiting.ui.components;

import com.vaadin.flow.component.*;
import com.vaadin.flow.component.dependency.HtmlImport;

@Tag("paper-icon-button")
@HtmlImport("bower_components/paper-icon-button/paper-icon-button.html")
@HtmlImport("bower_components/iron-icons/iron-icons.html")
public class PaperIconButton extends Component implements HasComponents {

  public void addClickListener(
          ComponentEventListener<ClickEvent<PaperIconButton>> listener) {
    addListener(ClickEvent.class, (ComponentEventListener) listener);
  }
}
