package org.apache.struts.action;

import java.util.List;

import model.Contact;

public class SearchContactForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nom;
//	private List<Contact> listResults;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

//	public List<Contact> getListResults() {
//		return listResults;
//	}
//
//	public void setListResults(List<Contact> listResults) {
//		this.listResults = listResults;
//	}

}
