package model;

import java.util.Set;

public class Entreprise extends Contact {

	private String numSiret;
	
	

	public Entreprise() {
		super();
	}

	public Entreprise(String numSiret) {
		this.numSiret = numSiret;
	}

	public Entreprise(Entreprise e) {
		this(e.numSiret);
	}
	
	public Entreprise(String nom, String mail, Adress adress, Set<PhoneNumber> phones, String numSiret){
		super(nom,mail,adress, phones);
		this.numSiret = numSiret;
	}

	public String getNumSiret() {
		return numSiret;
	}

	public void setNumSiret(String numSiret) {
		this.numSiret = numSiret;
	}

}
