package dao;

import entities.Location;
import utils.JpaUtil;

public class LocationDAO extends JpaUtil {

	public void aggiungiLocation(Location location) {
		
		t.begin();
		em.persist(location);
		t.commit();
	}
}
