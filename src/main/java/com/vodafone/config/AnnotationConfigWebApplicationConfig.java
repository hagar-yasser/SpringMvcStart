package com.vodafone.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class AnnotationConfigWebApplicationConfig implements WebApplicationInitializer {

  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {

    // root app
    //only to detect beans not configured in the configuration file of the dispatcher servlet
    //like the service or the repository the dispatcher will by default inherit those beans
    AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
    rootContext.scan("com.vodafone");

    AnnotationConfigWebApplicationContext mvcContext = new AnnotationConfigWebApplicationContext();
    mvcContext.register(MvcConfig.class);

    DispatcherServlet dispatcherServlet = new DispatcherServlet(mvcContext);

    ServletRegistration.Dynamic dynamic = servletContext.addServlet("dispatcherServlet", dispatcherServlet);

    dynamic.addMapping("/springmvc/*");
    dynamic.setLoadOnStartup(1);

    servletContext.addListener(new ContextLoaderListener(rootContext));
  }
}
