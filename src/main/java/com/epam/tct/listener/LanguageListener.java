package com.epam.tct.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class LanguageListener implements ServletContextListener {
   //private static final Logger LOG = Logger.getLogger(LanguageListener.class);
    public static final String PROPERTIES_FILE =
            "resources";

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ResourceBundle rb = ResourceBundle.getBundle(PROPERTIES_FILE);
        servletContextEvent.getServletContext().setAttribute("resources", rb);
        System.out.println("init");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("destroy");
    }
}
