package org.openrecruiting.ui.layouts;

import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Viewport;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.material.Material;
import org.openrecruiting.ui.components.*;
import org.openrecruiting.ui.views.*;

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
    drawerContent.setPadding(false);
    drawerContent.setSpacing(false);

    PaperIconItem search = new PaperIconItem("search", "Suchen");

    drawerContent.add(search);

    PaperIconItem dashboard = new PaperIconItem("dashboard", "Dashboard");
    dashboard.addClickListener(event -> this.getUI().ifPresent(ui -> ui.navigate(MainView.class)));
    drawerContent.add(dashboard);

    PaperIconItem task = new PaperIconItem("query-builder", "Meine Aufgaben");
    task.addClickListener(event -> this.getUI().ifPresent(ui -> ui.navigate(TaskView.class)));
    drawerContent.add(task);

    PaperIconItem applicants = new PaperIconItem("social:people", "Bewerber");
    applicants.addClickListener(event -> this.getUI().ifPresent(ui -> ui.navigate(ApplicantView.class)));
    drawerContent.add(applicants);

    PaperIconItem vacancies = new PaperIconItem("communication:business", "Vakanzen");
    vacancies.addClickListener(event -> this.getUI().ifPresent(ui -> ui.navigate(VacancyView.class)));
    drawerContent.add(vacancies);

    PaperIconItem joboffer = new PaperIconItem("communication:chat", "Ausschreibungen");
    joboffer.addClickListener(event -> this.getUI().ifPresent(ui -> ui.navigate(JobofferView.class)));
    drawerContent.add(joboffer);

    PaperIconItem reports = new PaperIconItem("assessment", "Auswertungen");
    reports.addClickListener(event -> this.getUI().ifPresent(ui -> ui.navigate(ReportView.class)));
    drawerContent.add(reports);

    PaperIconItem settings = new PaperIconItem("settings", "Einstellungen");
    settings.addClickListener(event -> this.getUI().ifPresent(ui -> ui.navigate(SettingsView.class)));
    drawerContent.add(settings);

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
    menuButton.getElement().setAttribute("icon", "menu");
    menuButton.addClickListener(event -> {
      String forceNarrow = drawerLayout.getElement().getProperty("forceNarrow");
      if (forceNarrow == null) {
        drawerLayout.getElement().setProperty("forceNarrow", true);
      } else {
        drawerLayout.getElement().removeProperty("forceNarrow");
      }
      drawer.getElement().callFunction("toggle");
      //drawerLayout.getElement().setAttribute("narrow", true);
    });

    toolbar.add(menuButton);

    Div title = new Div();
    title.getElement().setAttribute("main-title", true);
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

    if (content != null) {
      this.content.getElement().appendChild(content.getElement());
    }
  }

}
