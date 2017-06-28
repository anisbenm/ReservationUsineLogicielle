package tests;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import reservation.entity.Adresse;
import reservation.entity.Hotel;
import reservation.service.HotelCrudService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes  = { reservation.spring.SpringConfig.class })
public class Test1 {
//reservation.spring.SpringConfigWebApplicationInitializer.class, 
	@Autowired
    private HotelCrudService service;
	
	@Test
	public void test() {

			    Hotel hotel = new Hotel();
			    Adresse adresse = new Adresse();
			    adresse.setCodepostal(75012l);
			    adresse.setLocalite("PARIS");
			    adresse.setNum(new Integer(11).shortValue());
			    adresse.setPays("FRANCE");
			    adresse.setRue("Avenue Daumesnil");
			    
			    hotel.setAdresse(adresse);
			    hotel.setNom("Hotel Premier");
			    
			    service.save(hotel);
			   
			    System.out.println("SAVE OK");
			    ArrayList<Hotel> hotels = (ArrayList<Hotel>) service.findAll();
			    
			    for ( Hotel h : hotels){
			    	System.out.println(h);
			    }
			    		   
	}

}
