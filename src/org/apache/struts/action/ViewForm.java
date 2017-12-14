package org.apache.struts.action;

import java.util.List;

import model.Contact;

public class ViewForm extends ActionForm {

	private static final long serialVersionUID = 1L;

	private List<Contact> listContacts;

	public List<Contact> getListContacts() {
		return listContacts;
	}

	public void setListContacts(List<Contact> listContacts) {
		this.listContacts = listContacts;
	}

}
