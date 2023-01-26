package dao;

import entities.Persona;
import utils.JpaUtil;

public class PersonaDAO extends JpaUtil{
	
	public void inserisciPersona(Persona persona) {
		
		t.begin();
		
		em.persist(persona);
		t.commit();
	}

}
