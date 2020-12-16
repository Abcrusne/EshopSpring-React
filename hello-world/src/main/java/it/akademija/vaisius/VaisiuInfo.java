package it.akademija.vaisius;

public class VaisiuInfo {

	private String pavadinimas;

	private String medzioPavadinimas;

	public VaisiuInfo(String pavadinimas, String medzioPavadinimas) {
		super();
		this.pavadinimas = pavadinimas;
		this.medzioPavadinimas = medzioPavadinimas;
	}

	public String getPavadinimas() {
		return pavadinimas;
	}

	public void setPavadinimas(String pavadinimas) {
		this.pavadinimas = pavadinimas;
	}

	public String getMedzioPavadinimas() {
		return medzioPavadinimas;
	}

	public void setMedzioPavadinimas(String medzioPavadinimas) {
		this.medzioPavadinimas = medzioPavadinimas;
	}

}
