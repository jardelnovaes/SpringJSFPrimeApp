package com.jardelnovaes.spring.samples.web.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;
 

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitializer implements WebApplicationInitializer {
	@Override
    public void onStartup(ServletContext container) {
		processRootContext(container);
        
		processFacesContext(container);
		
		processSpringContext(container);
		
        //container.addListener(ConfigureListener.class);
        //container.addListener(org.springframework.web.context.request.RequestContextListener.class);
        //super.onStartup(container);
    }
	
	private void processRootContext(ServletContext container){
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.setConfigLocation("com.jardelnovaes.spring.samples.web.config");
        rootContext.register(JPAConfig.class/*, SecurityConfig.class*/);
        container.addListener(new ContextLoaderListener(rootContext));
	}
	
	private void processFacesContext(ServletContext container){
		//container.setInitParameter("javax.faces.DEFAULT_SUFFIX", ".xhtml");
        //container.setInitParameter("javax.faces.FACELETS_VIEW_MAPPINGS", "*.xhtml");

        ServletRegistration.Dynamic facesServlet = container.addServlet("Faces Servlet", javax.faces.webapp.FacesServlet.class);
        facesServlet.setLoadOnStartup(1);
        facesServlet.addMapping("*.xhtml");
        facesServlet.addMapping("*.jsf");
        facesServlet.addMapping("/javax.faces.resource/*");
        facesServlet.addMapping("*.faces");

	}
	
	private void processSpringContext(ServletContext container){
		AnnotationConfigWebApplicationContext dispatcherServlet = new AnnotationConfigWebApplicationContext();
        dispatcherServlet.register(SpringMVCConfig.class);

        ServletRegistration.Dynamic dispatcher = container.addServlet("DispatcherServlet", new DispatcherServlet(dispatcherServlet));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");

	}
}
