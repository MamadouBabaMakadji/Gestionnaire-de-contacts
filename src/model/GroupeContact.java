package model;

import java.util.ArrayList;
import java.util.List;

public class GroupeContact {
 	private int groupId;
 	private int idContact;
 	private String groupName;
 	
	private List<Contact> groupeContact;
 	
		
	public GroupeContact(){
		
	}
	
	public GroupeContact(int id, String name)
	{
		this.groupId = id;
		this.groupName = name;
	}
	
	public GroupeContact(int id, String name, int id_contact)
	{
		this.groupId = id;
		this.groupName = name;
		this.idContact = id_contact;
	}

	public GroupeContact(List<Contact> listContact) {
		this.groupeContact = new ArrayList<Contact>();
		this.groupeContact.addAll(listContact);
	}
	
	public GroupeContact(String name) {
		this.groupName=name;
	}
	
	public GroupeContact(String name, List<Contact> listContact) 
	{
 		this.groupName = name;
		this.groupeContact = listContact;
 	}
	
	//************ Getter and Setter *****************
	
	
	public int getGroupId() {
		return groupId;
	}

	public int getIdContact() {
		return idContact;
	}

	public void setIdContact(int idContact) {
		this.idContact = idContact;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	
	public List<Contact> getGroupeContact() {
		return groupeContact;
	}

	public void setGroupeContact(List<Contact> pGroupeContact) {
		this.groupeContact = pGroupeContact;
	}
	
	//***************************************************
}
