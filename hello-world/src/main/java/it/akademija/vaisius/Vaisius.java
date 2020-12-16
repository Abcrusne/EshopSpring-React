package it.akademija.vaisius;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Vaisius {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String pavadinimas;

	@OneToOne
	private Medis medis;

	public Vaisius() {
		super();
	}

	public Vaisius(String pavadinimas) {
		super();
		this.pavadinimas = pavadinimas;
	}

	public void setMedis(Medis medis) {
		this.medis = medis;
	}

	public Medis getMedis() {
		return medis;
	}

	public Long getId() {
		return id;
	}

	public String getPavadinimas() {
		return pavadinimas;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setPavadinimas(String pavadinimas) {
		this.pavadinimas = pavadinimas;
	}

//	public VaisiusIsServiso getMedis() {
//		// TODO Auto-generated method stub
//		return medis;
//	}

}
