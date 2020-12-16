package it.akademija.vaisius;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Length;

@Entity
public class Medis {

	@Id
	@Length(min = 2)
	private String pavadinimas;

	public Medis() {
		super();
	}

	public Medis(@Length(min = 2) String pavadinimas) {
		super();
		this.pavadinimas = pavadinimas;
	}

	public String getPavadinimas() {
		return pavadinimas;
	}

	public void setPavadinimas(String pavadinimas) {
		this.pavadinimas = pavadinimas;
	}

}
