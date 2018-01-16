package org.apache.struts.action;

import java.util.List;

import model.Contact;

public class ViewEditContactForm extends ActionForm {

	private static final long serialVersionUID = 1L;

	private List<Contact> listEditContacts;

	public List<Contact> getListEditContacts() {
		return listEditContacts;
	}

	public void setListEditContacts(List<Contact> listEditContacts) {
		this.listEditContacts = listEditContacts;
	}

}
