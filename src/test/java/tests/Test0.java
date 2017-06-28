package tests;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.trk.javase.crypto.MDPProduct;

import reservation.entity.Adresse;
import reservation.entity.Hotel;
import reservation.service.HotelCrudService;
import reservation.spring.SpringConfig;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes  = { reservation.spring.SpringConfigWebApplicationInitializer.class, reservation.spring.SpringConfig.class })
public class Test0 {
	
	private static Logger log = Logger.getLogger(Test0.class);
	
	@Before
	public void setUp() throws Exception {
		System.out.println("Call setUp() ...");
	}

//	@Autowired
//    private HotelCrudService service;
	
	@Test
	public void test() {
		 Map<String, String> properties = new HashMap<String, String>();
		String sfp = System.getProperty("appli.hotel.properties.file");
		System.out.println("Propertie file is :"+sfp);
		
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
			  log.info("Crypto OK "+crypto);
		  }else{
			  log.error("Crypto KO "+crypto); 
		  }
		  
		  if ( MDPProduct.check(crypto) ) {
			  properties.put("javax.persistence.jdbc.password", MDPProduct.getMdp() );
			  log.info("Crypto login and MDP match "+MDPProduct.getMdp()); 
		  }else{
			  log.error("Crypto login and MDP doesn't match "+crypto); 
		  }
	}

}
