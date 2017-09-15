package model;

public class Entreprise extends Contact{
	
	private String numSiret;

	public Entreprise(String numSiret) {
		this.numSiret = numSiret;
	}
	public Entreprise (Entreprise e){
		this(e.numSiret);
	}

	public String getNumSiret() {
		return numSiret;
	}

	public void setNumSiret(String numSiret) {
		this.numSiret = numSiret;
	}
		

}
