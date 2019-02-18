package org.openrecruiting.ui.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.openrecruiting.ui.layouts.NewLayout;

import java.util.function.Function;

@Route(value = "", layout = NewLayout.class)
public class MainView extends VerticalLayout {

  static final  String TASK_TAB = "TASK_TAB";
  static final String APPLICANT_TAB = "APPLICANT_TAB";
  static final String VACANCY_TAB = "VACANCY_TABT";
  static final String JOBOFFER_TAB = "JOBOFFER_TAB";

  Div content = new Div();

  public MainView() {

    Tabs tabs = getTabs();

    add(tabs);

    add(content);

    content.add(getTaskList());

    TextField tf = new TextField();
    tf.setLabel("Label");

    add(tf);

    Button b = new Button();
    b.setText("Hallo");
    b.addClickListener(event -> Notification.show("Button clicked"));

    add(b);

    tabs.addSelectedChangeListener(event -> {
      Tab selectedTab = tabs.getSelectedTab();
      String id = selectedTab.getId().orElse("");
      switch (id) {
        case TASK_TAB: changeContent(t -> getTaskList()); break;
        case APPLICANT_TAB: changeContent(t -> getApplicantList()); break;
        default: Notification.show("default");
      }

    });
  }

  private void changeContent(Function<Void,Component> contentProvider) {
    content.removeAll();

    content.add(contentProvider.apply(null));
  }

  private Component getTaskList() {

    Text text = new Text("TaskList");
    return text;
  }

  private Component getApplicantList() {

    Text text = new Text("ApplicantList");
    return text;
  }

  private Component getVacancyList() {

    Text text = new Text("VacancyList");
    return text;
  }

  private Tabs getTabs() {
    Tabs tabs = new Tabs();

    Tab taskTab = new Tab();
    taskTab.setId(TASK_TAB);
    taskTab.setLabel("Meine Aufgaben");
    tabs.add(taskTab);

    Tab applicantTab = new Tab();
    applicantTab.setId(APPLICANT_TAB);
    applicantTab.setLabel("Bewerber");
    tabs.add(applicantTab);

    Tab vacancyTab = new Tab();
    vacancyTab.setId(VACANCY_TAB);
    vacancyTab.setLabel("Vakanzen");
    tabs.add(vacancyTab);

    Tab jobofferTab = new Tab();
    jobofferTab.setId(JOBOFFER_TAB);
    jobofferTab.setLabel("Ausschreibungen");
    tabs.add(jobofferTab);

    return tabs;
  }

}
