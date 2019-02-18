package org.openrecruiting.ui.layouts;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Viewport;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.material.Material;
import org.openrecruiting.ui.components.*;
import org.openrecruiting.ui.views.MainView;
import org.openrecruiting.ui.views.NewApplicationView;

@Viewport("width=device-width, minimum-scale=1.0, initial-scale=1.0, user-scalable=yes")
@Theme(value = Material.class)
@HtmlImport("frontend://mystyle.html")
public class NewLayout extends Div implements RouterLayout {

  private Div content = new Div();

  public NewLayout() {

    AppDrawerLayout drawerLayout = new AppDrawerLayout();

    AppDrawer drawer = new AppDrawer();

    drawer.getElement().setAttribute("slot", "drawer");

    VerticalLayout drawerContent = new VerticalLayout();
    drawerContent.addClassName("drawer-content");

    drawerContent.add(new Text("Meine Aufgaben"));
    drawerContent.add(new RouterLink("Neuer Bewerber",NewApplicationView.class));
    drawerContent.add(new Text("Bewerber"));
    drawerContent.add(new RouterLink("Neuer Bewerber",NewApplicationView.class));
    drawerContent.add(new RouterLink("Meine Bewerber",NewApplicationView.class));
    drawerContent.add(new RouterLink("Bewerber suchen",NewApplicationView.class));
    drawerContent.add(new Text("Ausschreibungen"));
    drawerContent.add(new RouterLink("Neue Ausschreibung",NewApplicationView.class));
    drawerContent.add(new RouterLink("Meine Ausschreibungen",NewApplicationView.class));
    drawerContent.add(new RouterLink("Ausschreibung suchen",NewApplicationView.class));
    drawerContent.add(new Text("Vakanzen"));
    drawerContent.add(new RouterLink("Neue Vakanz",NewApplicationView.class));
    drawerContent.add(new RouterLink("Meine Vakanzen",NewApplicationView.class));
    drawerContent.add(new RouterLink("Vakanz suchen",NewApplicationView.class));

    drawer.add(drawerContent);

    drawerLayout.add(drawer);
    drawerLayout.setId("drawerLayout");

    AppHeaderLayout headerLayout = new AppHeaderLayout();

    AppHeader header = new AppHeader();
    header.getElement().setAttribute("slot", "header");
    header.getElement().setAttribute("effects", "waterfall");

    AppToolbar toolbar = new AppToolbar();

    PaperIconButton menuButton = new PaperIconButton();
    menuButton.getElement().setAttribute("drawerToggle", true);
    menuButton.getElement().setAttribute("icon","menu");
    menuButton.addClickListener(event -> {
      String forceNarrow = drawerLayout.getElement().getProperty("forceNarrow");
      if (forceNarrow==null) {
        drawerLayout.getElement().setProperty("forceNarrow", true);
      } else {
        drawerLayout.getElement().removeProperty("forceNarrow");
      }
    });

    toolbar.add(menuButton);

    Div title = new Div();
    title.getElement().setAttribute("main-title",true);
    title.setText("openRecruiting");
    toolbar.add(title);

    header.add(toolbar);

    headerLayout.add(header);

    headerLayout.add(drawerLayout);
    drawerLayout.add(content);

    add(headerLayout);
  }

  @Override
  public void showRouterLayoutContent(HasElement content) {

    if (content!=null)   {
      this.content.getElement().appendChild(content.getElement());
    }
  }

}
