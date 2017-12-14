package org.apache.struts.action;

import java.util.List;
import model.Contact;
import model.Group;

public class ViewForm extends ActionForm {

	private static final long serialVersionUID = 1L;

	private List<Contact> listContacts;
	private List<Group> listGroups;
	

	public List<Contact> getListContacts() {
		return listContacts;
	}

	public void setListContacts(List<Contact> listContacts) {
		this.listContacts = listContacts;
	}

	public List<Group> getListGroups() {
		return listGroups;
	}

	public void setListGroups(List<Group> groups) {
		this.listGroups = groups;
	}
	
}
