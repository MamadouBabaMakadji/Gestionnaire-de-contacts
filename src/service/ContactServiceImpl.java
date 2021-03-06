package service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import DAO.IContactDao;
import model.Contact;
import model.Entreprise;
import model.Group;

public class ContactServiceImpl implements IContactService {

	private IContactDao cdao;

	public void setCdao(IContactDao cdao) {
		this.cdao = cdao;
	}

	public boolean createContact(Contact contact) throws Exception {
		return cdao.insertDB(contact);
	}

	// Pour la cr�ation Entreprise
	public boolean addEntreprise(Entreprise etp) throws Exception {
		return cdao.insertDB(etp);
	}

	@Override
	public boolean insertDBObjects(List<Object> objects) throws Exception {
		return cdao.insertDBObjects(objects);
	}

	@Override
	public boolean insertDB(Object object) throws Exception {
		return cdao.insertDB(object);
	}
	
	@Override
	public Contact getContact(long id) {
		return cdao.getContact(id);
	}

	@Override
	public Set<Contact> getAllContacts() {
		return new HashSet<Contact>(cdao.getAllContacts());
	}
	
	@Override
	public Set<Contact> getAllContactsLazy() {
		return cdao.getAllContactsLazy();
	}

	@Override
	public Set<Contact> getContactsByGroupId(long groupId) {
		return cdao.getContactsByGroupId(groupId);
	}
	
	@Override
	public Group getGroup(long groupId) {
		return cdao.getGroup(groupId);
	}

	@Override
	public Set<Group> getAllGroups() {
		return cdao.getAllGroups();
	}

	@Override
	public Set<Contact> getAllContactsWgroups() {
		return cdao.getAllContactsWGroups();
	}

	@Override
	public Set<Contact> searchContacts(String keywords) {
		return cdao.searchContacts(keywords);
	}

	@Override
	public boolean saveUpdate(Contact contact) {
		return cdao.saveUpdate(contact);
	}
	
	@Override
	public boolean update(Contact contact) {
		return cdao.update(contact);
	}

	@Override
	public boolean update(Group group) {
		return cdao.update(group);
	}

	@Override
	public boolean deleteContact(long contact_ID) {
		return cdao.deleteContact(contact_ID);
	}
	
	@Override
	public boolean deleteGroup(long groupId) {
		return cdao.deleteGroup(groupId);
	}

	@Override
	public long getNbContact(){
		return cdao.getNbContact();
	}
	
	@Override
	public long getNbGroup(){
		return cdao.getNbGroup();
	}
	
	@Override
	public Set<Contact> getLastContacts(){
		return cdao.getLastContacts();
	}
	
	@Override
	public boolean updateGroupName(long id, String newName){
		return cdao.updateGroupName(id, newName);
	}
	
}
