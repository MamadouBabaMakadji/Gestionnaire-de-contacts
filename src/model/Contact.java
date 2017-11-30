package model;

import java.util.HashSet;
import java.util.Set;

public class Contact {
	private long contact_ID;
	private int version;
	private String nom;
	private String prenom;
	private String mail;
	private Adress adress;
	private Set<PhoneNumber> phones = new HashSet<PhoneNumber>();
	private Set<Group> groups = new HashSet<Group>();

	public Contact() {
	}

	
	public Contact(String nom, String prenom, String mail) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
	}
	
	
	public Contact(String nom, String prenom, String mail, Adress adress, Set<PhoneNumber> phones, Set<Group> groups) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.adress = new Adress(adress.getStreet(), adress.getCity(), adress.getCountry(), adress.getZip());
		this.phones.addAll(phones);
		this.groups.addAll(groups);
	}


	public Contact(Contact c) {
		this(c.prenom, c.nom, c.mail, c.adress, c.phones, c.groups);
	}
	

	public long getContact_ID() {
		return contact_ID;
	}

	public void setContact_ID(long contact_ID) {
		this.contact_ID = contact_ID;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	public Set<PhoneNumber> getPhones() {
		return phones;
	}

	public void setPhones(Set<PhoneNumber> phones) {
		this.phones = phones;
	}

	public Set<Group> getGroups() {
		return groups;
	}

	public void setGroups(Set<Group> groups) {
		this.groups = groups;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (contact_ID ^ (contact_ID >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		if (contact_ID != other.contact_ID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return new String("Contact {contact_ID=" + this.getContact_ID() + ", nom=" + this.getNom() + ", prenom=" + this.getPrenom() + ", mail=" + this.getMail()
				+ ", address={" + this.adress.getCity() + ", " + this.adress.getCountry() + ", " + this.adress.getStreet() + ", " + this.adress.getZip() +
				", version = " + this.version+ "}");
	}

	
	
}
