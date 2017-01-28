package com.jardelnovaes.spring.samples.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import com.jardelnovaes.spring.samples.web.common.FaceletView;
 
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "com.jardelnovaes.spring.samples.web.controller", "com.jardelnovaes.spring.samples.service" })
public class SpringMVCConfig extends WebMvcConfigurerAdapter {
 
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
 
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
 
    @Bean
    public UrlBasedViewResolver facesViewResolver() {
    	UrlBasedViewResolver bean = new UrlBasedViewResolver();
    	bean.setCache(false);
    	bean.setViewClass(FaceletView.class);
        bean.setPrefix("/WEB-INF/views/");
        bean.setSuffix(".xhtml");
        return bean;
    }
    
    @Bean(name = "messageSource")
    public ReloadableResourceBundleMessageSource getMessageSource() {
        ReloadableResourceBundleMessageSource resource = new ReloadableResourceBundleMessageSource();
        resource.setBasename("classpath:messages");
        resource.setDefaultEncoding("UTF-8");
        return resource;
    }
    
    /*
    @Bean
    public InternalResourceViewResolver jspViewResolver() {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();
        
        bean.setViewClass(org.springframework.faces.mvc.JsfView.class);
        bean.setPrefix("/WEB-INF");
        bean.setSuffix(".xhtml");
        
        //bean.setPrefix("/WEB-INF/views/");
        //bean.setSuffix(".jsp");
        return bean;
    }
   */
    /*@Bean(name = "multipartResolver")
    public CommonsMultipartResolver getMultipartResolver() {
        return new CommonsMultipartResolver();
    }*/
}
