package app;

import java.time.LocalDate;

import dao.EventoDAO;
import dao.LocationDAO;
import dao.PartecipazioneDAO;
import dao.PersonaDAO;
import entities.Evento;
import entities.Location;
import entities.Partecipazione;
import entities.Persona;
import entities.Sesso;
import entities.Stato;
import entities.TipoEvento;


public class App{
	
	private static Partecipazione inserisciPartecipazione(Evento evento, Persona persona) {
		Partecipazione par1 = new Partecipazione();
		par1.setEvento(evento);
		par1.setPersona(persona);
		par1.setStato(Stato.CONFERMATA);
		PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO();
		partecipazioneDAO.aggiungiPartecipazione(par1);
		return par1;
	}
	
	private static Persona inserisciPersona() {
		
		
		Persona p1 = new Persona();
		p1.setNome("Gaetano");
		p1.setCognome("Quarto");
		p1.setEmail("gaetano@mail.com");
		p1.setDatadinascita(LocalDate.parse("1997-12-08"));
		p1.setSesso(Sesso.MASCHIO);
		PersonaDAO personaDAO = new PersonaDAO();
		personaDAO.inserisciPersona(p1);
		return p1;
		
	}
	
	private static Location inserisciLocation() {
		
		Location l1 = new Location();
		l1.setNome("Spazio 900");
		l1.setCitta("Roma");
		
		LocationDAO locationDAO = new LocationDAO();
		locationDAO.aggiungiLocation(l1);
		return l1;
		
	}
	
	private static Evento inserisciEvento(Location loc) {
		
		Evento e = new Evento();
		e.setTitolo("Festa anni 80'");
		e.setDatavento(LocalDate.parse("2023-01-30"));
		e.setDescrizione("Ritorna indietro nel tempo con noi.");
		e.setTipoevento(TipoEvento.PUBBLICO);
		e.setNmaxpartecipanti(150);
		e.setLocation(loc);
		
		EventoDAO evDAO = new EventoDAO();
		evDAO.inserisciEvento(e);
		return e;
		
	}
	


	public static void main(String[] args) {
		
		Location location = inserisciLocation();
		Evento evento = inserisciEvento(location);
		Persona persona = inserisciPersona();
		
		Partecipazione partecipazione = inserisciPartecipazione(evento, persona);
	}
}
