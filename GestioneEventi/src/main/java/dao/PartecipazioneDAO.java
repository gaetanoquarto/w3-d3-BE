package dao;

import entities.Partecipazione;
import utils.JpaUtil;

public class PartecipazioneDAO extends JpaUtil{
	
	public void aggiungiPartecipazione(Partecipazione par) {
		
		t.begin();
		em.persist(par);
		t.commit();
		
	}

}
