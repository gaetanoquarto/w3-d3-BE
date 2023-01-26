package entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "eventi")
@Getter
@Setter
public class Evento {
	
			@Id
			@SequenceGenerator(name = "evento_seq", sequenceName = "evento_seq", allocationSize = 1)
		    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "evento_seq")
			private int id;
			
			private String titolo;
			private LocalDate datavento;
			private String descrizione;
			@Enumerated(EnumType.STRING)
			private TipoEvento tipoevento;
			private int nmaxpartecipanti;
			
			@OneToMany(mappedBy = "evento", cascade = CascadeType.REMOVE)
			private Set<Partecipazione> partecipazione;
			
			@ManyToOne
			private Location location;

}
