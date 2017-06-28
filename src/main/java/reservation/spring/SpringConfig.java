/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.spring;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.trk.javase.crypto.MDPProduct;

import reservation.controller.AccessInterceptor;

/**
 *
 * @author ETY
 */
@Configuration
//@SpringBootApplication
//@EnableAutoConfiguration

@ComponentScan(basePackages = "reservation") 
@EnableJpaRepositories(basePackages = "reservation")
@EnableWebMvc
public class SpringConfig extends WebMvcConfigurerAdapter{

	private static Logger log = Logger.getLogger(SpringConfig.class);
	
	@Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new AccessInterceptor()).addPathPatterns("/**");
    }
	
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
 
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
 
    @Bean
    public InternalResourceViewResolver jspViewResolver() {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setPrefix("/WEB-INF/views/");
//        bean.setSuffix(".jsp");
        return bean;
    }
 /*
    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver getMultipartResolver() {
        return new CommonsMultipartResolver();
    }
 */
    @Bean
    public StringHttpMessageConverter stringHttpMessageConverter() {
        return new StringHttpMessageConverter(Charset.forName("UTF-8"));
    }
    
    @Bean(name = "messageSource")
    public ReloadableResourceBundleMessageSource getMessageSource() {
        ReloadableResourceBundleMessageSource resource = new ReloadableResourceBundleMessageSource();
        resource.setBasename("classpath:messages");
        resource.setDefaultEncoding("UTF-8");
        return resource;
    }
    
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");

        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(filter);
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }
    
   @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory());
        return txManager;
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() {
    	// Insert Security Acces to Data Base 
    	
    	// Avant la mise en place de la sécurité applicative concernant les passwords
    	// return Persistence.createEntityManagerFactory("PU");
        
    	//Mise en place d'une sécurité cachant le mot de passe de connexion à la base de données
        return getSecurityEMFactory("PU");
    }

    /**
     * Methode qui se charge de créer une instance de EntityManagerFactory
     * en ajoutant le password décodé pour la connexion à la base de données
     * Utilisation de l'algorithme BCrypt de Spring (Voir la classe Coder.java )
     * @param persitUnit
     * @return : EntityManagerFactory
     */
    public EntityManagerFactory getSecurityEMFactory(String persitUnit ){
    	 Map<String, String> properties = new HashMap<String, String>();
		  EntityManagerFactory emf = Persistence.createEntityManagerFactory(
				  persitUnit,properties);
		
		  String sfp = System.getProperty("appli.hotel.properties.file");
		  
		  if ( sfp == null )
			 log.error(">>>>>>>>>>>APPLI Properties File residence :"+sfp );
		  
		  Properties props = new Properties();
		  try {
			  InputStream is = new FileInputStream(new File(sfp));			
			  if ( is != null ){
				props.load(is);
				is.close();
			}
		  } catch (IOException e) {
			  log.error("Error while read properties file:"+e.getLocalizedMessage());
		}
		 
		  String crypto = (String) props.get("javax.persistence.jdbc.password");
		  
		  if ( crypto != null ){
			  log.error("Crypto OK "+crypto);
		  }else{
			  log.error("Crypto KO "+crypto); 
		  }
		  
		  
		  if ( MDPProduct.check(crypto) ) {
			  properties.put("javax.persistence.jdbc.password", MDPProduct.getMdp() );
		  }
		  
		  return emf;

    }
}
