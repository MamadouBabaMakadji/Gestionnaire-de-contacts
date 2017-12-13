package org.apache.struts.action;

import java.util.List;
import java.util.Set;

import model.Contact;
import model.Group;

public class ViewForm extends ActionForm {

	private static final long serialVersionUID = 1L;

	private List<Contact> listContacts;
	private Set<Group> groups;
	

	public List<Contact> getListContacts() {
		return listContacts;
	}

	public void setListContacts(List<Contact> listContacts) {
		this.listContacts = listContacts;
	}

	public Set<Group> getGroups() {
		return groups;
	}

	public void setGroups(Set<Group> groups) {
		this.groups = groups;
	}
	
}
