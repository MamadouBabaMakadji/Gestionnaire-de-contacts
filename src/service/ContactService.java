package service;

import java.util.Set;

import DAO.ContactDAO;
import model.Contact;
import model.Entreprise;
import model.Group;

public class ContactService 
{
	@SuppressWarnings("unused")
	private ContactDAO cdao;

	public ContactService() {
	}

	public boolean createContact(Contact contact) throws Exception {
		return (cdao = new ContactDAO()).insertDB(contact);
	}


	public boolean createEntreprise(Entreprise etp) throws Exception {
		return (cdao = new ContactDAO()).insertDB(etp);
	}

	public Contact getContact(long id) {
		return (cdao = new ContactDAO()).getContact(id);
	}
	
	public Set<Contact> getAllContacts() {
		return (cdao = new ContactDAO()).getAllContacts();
	} 
	
	public Set<Group> getGroups() {
		return (cdao = new ContactDAO()).getAllGroups();
	}

	public Set<Contact> seachContacts(String keywords) {
		return (cdao = new ContactDAO()).searchContacts(keywords);
	}
	
	public boolean updateContact(Contact contact){
		return (cdao = new ContactDAO()).update(contact);
	}
}
