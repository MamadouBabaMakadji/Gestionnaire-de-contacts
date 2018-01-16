package org.apache.struts.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.PhoneNumber;

public class EditContactForm extends ActionForm {

	private static final long serialVersionUID = 1L;
	private long contactId;
	private int versionContact;
	private String nom;
	private String prenom;
	private String mail;
	private long adressId;
	private String street;
	private String city;
	private String zip;
	private String country;
	private long phoneNumber1Id;
	private String phoneNumber1;
	private String phoneKind1;
	private long phoneNumber2Id;
	private String phoneNumber2;
	private String phoneKind2;
	

	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public long getContactId() {
		return contactId;
	}

	public void setContactId(long contactId) {
		this.contactId = contactId;
	}

	
	public int getVersionContact() {
		return versionContact;
	}
	
	public void setVersionContact(int versionContact) {
		this.versionContact = versionContact;
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

	public long getAdressId() {
		return adressId;
	}

	public void setAdressId(long adressId) {
		this.adressId = adressId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	

	public String getPhoneNumber1() {
		return phoneNumber1;
	}

	public void setPhoneNumber1(String phoneNumber1) {
		this.phoneNumber1 = phoneNumber1;
	}

	public String getPhoneKind1() {
		return phoneKind1;
	}

	public void setPhoneKind1(String phoneKind1) {
		this.phoneKind1 = phoneKind1;
	}

	public String getPhoneNumber2() {
		return phoneNumber2;
	}

	public void setPhoneNumber2(String phoneNumber2) {
		this.phoneNumber2 = phoneNumber2;
	}

	public String getPhoneKind2() {
		return phoneKind2;
	}

	public void setPhoneKind2(String phoneKind2) {
		this.phoneKind2 = phoneKind2;
	}
	
	public long getPhoneNumber1Id() {
		return phoneNumber1Id;
	}

	public void setPhoneNumber1Id(long phoneNumber1Id) {
		this.phoneNumber1Id = phoneNumber1Id;
	}

	public long getPhoneNumber2Id() {
		return phoneNumber2Id;
	}

	public void setPhoneNumber2Id(long phoneNumber2Id) {
		this.phoneNumber2Id = phoneNumber2Id;
	}

	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		System.out.println("Passage EditActionForm");
		System.out.println("Version contact = " + versionContact);

/*		System.out.println("Size phonesId = " + phonesId.size());
		for (long id : phonesId) {
			System.out.println("Tel Id = " + id);
		}*/

		if (nom == null || nom.length() < 1) {
			errors.add("nom", new ActionMessage("erreur.nom"));
		}

		// if (prenom == null || prenom.length() < 1) {
		// errors.add("prenom", new ActionMessage("erreur.prenom"));
		// }

		if (!mail.matches("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)+$")) {
			errors.add("mail", new ActionMessage("erreur.mail"));
		}

		/*
		 * for (String tel : phonesNumber) { if (tel.length() != 10) {
		 * errors.add("tel", new ActionMessage("erreur.tel")); } }
		 */

		if (zip.length() != 5) {
			errors.add("zip", new ActionMessage("erreur.zip"));
		}

		return errors;
	}

}
