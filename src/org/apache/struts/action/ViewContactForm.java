package org.apache.struts.action;

import java.util.List;
import model.Contact;
import model.Group;
import model.PhoneNumber;

public class ViewContactForm extends ActionForm {

	private static final long serialVersionUID = 1L;

	private String nom;
	private String prenom;
	private String mail;
	private String tel;
	private String ville;
	private String code_postal;
	private String pays;
	private String adresse;
	private List<Group> groups;
	private List<PhoneNumber> phones;
	private String siretEtp;
	private String typeContact;

	public String getTypeContact() {
		return typeContact;
	}

	public void setTypeContact(String typeContact) {
		this.typeContact = typeContact;
	}

	public String getSiretEtp() {
		return siretEtp;
	}

	public void setSiretEtp(String siretEtp) {
		this.siretEtp = siretEtp;
	}


	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCode_postal() {
		return code_postal;
	}

	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
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

	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}

	public List<PhoneNumber> getPhones() {
		return phones;
	}

	public void setPhones(List<PhoneNumber> phones) {
		this.phones = phones;
	}


}
