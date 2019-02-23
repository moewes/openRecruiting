package org.openrecruiting.ui.services;

import com.vaadin.cdi.annotation.VaadinServiceEnabled;
import com.vaadin.cdi.annotation.VaadinServiceScoped;
import com.vaadin.flow.i18n.I18NProvider;

import javax.annotation.PostConstruct;
import java.text.MessageFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

@VaadinServiceEnabled
@VaadinServiceScoped
public class LocaliseService implements I18NProvider {

  private final Locale LOCALE_DE = new Locale("de", "DE");
  private final Locale LOCALE_EN = new Locale("en", "GB");

  private List<Locale> locales = Collections
          .unmodifiableList(Arrays.asList(LOCALE_DE, LOCALE_EN));

  private Map<Locale, ResourceBundle> bundles = new HashMap<>();

  @PostConstruct
  public void init() {

    for (Locale locale:locales) {
      bundles.put(locale,readProperties(locale));
    }
  }

  @Override
  public List<Locale> getProvidedLocales() {
    return locales;
  }

  @Override
  public String getTranslation(String key, Locale locale, Object... params) {

    ResourceBundle resourceBundle = bundles.get(locale);

    String value;
    try {
      value = resourceBundle.getString(key);
    } catch (MissingResourceException e) {
      value = "<" + key + ">" + locale.getLanguage();
    }

      if (params.length > 0) {
        value = MessageFormat.format(value, params);
      }


    return value;
  }

  private ResourceBundle readProperties(final Locale locale) {
    final ClassLoader cl = LocaliseService.class.getClassLoader();

    ResourceBundle propertiesBundle = null;
    try {
      propertiesBundle = ResourceBundle.getBundle("openRecruiting", locale,
              cl);
    } catch (final MissingResourceException e) {
      Logger.getLogger(LocaliseService.class.getName())
              .info("Missing resource");
              e.printStackTrace();
    }
    return propertiesBundle;
  }
}
