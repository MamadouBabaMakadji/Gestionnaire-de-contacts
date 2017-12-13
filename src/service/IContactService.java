package service;

import java.util.List;
import java.util.Set;

import model.Contact;
import model.Entreprise;
import model.Group;

public interface IContactService {

	public boolean createContact(Contact contact) throws Exception;

	// Pour la création Entreprise
	public boolean addEntreprise(Entreprise etp) throws Exception;
	
	public boolean insertDBObjects(List<Object> objects) throws Exception;;
	
	public boolean insertDB(Object object) throws Exception;;

	public Contact getContact(long id);

	public List<Contact> getAllContacts();
	
	public Set<Contact> getAllContactsLazy();
	
	public Set<Contact> getAllContactsWgroups();
	
	public Set<Contact> getContactsByGroupId(long groupId);

	public Group getGroup(long groupId);
	
	public Set<Group> getAllGroups();

	public Set<Contact> searchContacts(String keywords);
	
	public boolean saveUpdate(Contact contact);
	
	public boolean update(Group group);
	
	public boolean deleteContact(long contact_ID);
	
	public boolean deleteGroup(long groupId);

}
