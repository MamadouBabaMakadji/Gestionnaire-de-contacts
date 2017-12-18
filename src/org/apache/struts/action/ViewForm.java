package org.apache.struts.action;

import java.util.List;
import model.Contact;
import model.Group;

public class ViewForm extends ActionForm {

	private static final long serialVersionUID = 1L;

	private List<Contact> listContacts;
	private List<Group> listGroups;
	private String groupName;
	private Group group;
	private Contact contact;
	
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

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}
	
	
	
}
