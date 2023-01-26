package dao;

import java.time.LocalDate;
import java.util.HashSet;

import entities.Evento;
import entities.Location;
import entities.Partecipazione;
import entities.TipoEvento;
import utils.JpaUtil;

public class EventoDAO extends JpaUtil{
	
public void inserisciEvento(Evento ev) {
		
		try {
			
			t.begin();
			em.persist(ev);
			t.commit();
			
			System.out.println("Evento inserito correttamente!");
		}
		catch(Exception e) {
			System.out.println("Errore nell'inserimento dell'evento");
		}
		
	}

public static void inserisciPartecipazioneEvento(Partecipazione par) {

	t.begin();
	em.persist(par);
	t.commit();
}

public static void getEventoById(int id) {
	Evento e = em.find(Evento.class, id);
	
	if( e == null ) {
		System.out.println( "L'evento con l'id " + id + " non è stato trovato!" );
		return;
	}
	
	System.out.println( "Dati Evento #" + id );
	System.out.printf(  
		"Titolo: %s | Data evento: %s | Descrizione: %s | Tipo: %s | Nmax Partecipanti: %d%n",
		e.getTitolo(), e.getDatavento().toString(), e.getDescrizione(), e.getTipoevento(), e.getNmaxpartecipanti()
	);
}

public static void deleteEventoById(int id) {
	Evento e = em.find(Evento.class, id);
	
	if( e == null ) {
		System.out.println( "L'Evento con l'id " + id + " non è stato trovato!" );
		return;
	}
	
	t.begin();
	em.remove(e);
	t.commit();
	
	System.out.println( "L'Evento con l'id " + id + " è stato eliminato!" );
}

public static void persist(Object entity) {
	t.begin();
	em.persist(entity);
	t.commit();
}

public static Evento getEvento(int id) {
	Evento e = em.find(Evento.class, id);
	
	if( e == null ) {
		System.out.println( "L'Evento con l'id " + id + " non è stato trovato!" );
		return null;
	}
	
	return e;
}

public static void updateEventoById(int id, String titolo, LocalDate dataevento, String descrizione, TipoEvento tipoevento, int nmaxpartecipanti) {
	Evento ev = getEvento(id);
	if( ev == null ) return;
	
	try {
		ev.setTitolo(titolo);
		ev.setDatavento(dataevento);
		ev.setDescrizione(descrizione);
		ev.setTipoevento(tipoevento);
		ev.setNmaxpartecipanti(nmaxpartecipanti);
		
		persist(ev);
		
		System.out.println("L'Evento con l'id " + id + " è stato aggiornato!");
	}
	catch(Exception e) {
		System.out.println( "Errore nella modifica dell'Evento!" );
	}
	
}
	




}
