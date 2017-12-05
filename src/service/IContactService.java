package service;

import java.util.Set;

import model.Contact;
import model.Entreprise;
import model.Group;

public interface IContactService {

	public boolean createContact(Contact contact) throws Exception;

	// Pour la création Entreprise
	public boolean addEntreprise(Entreprise etp) throws Exception;

	public Contact getContact(long id);

	public Set<Contact> getAllContacts();

	public Set<Group> getGroups();

	public Set<Contact> seachContacts(String keywords);
	
	public boolean saveUpdate(Contact contact);
	
	public boolean deleteContact(long contact_ID);
	
}
