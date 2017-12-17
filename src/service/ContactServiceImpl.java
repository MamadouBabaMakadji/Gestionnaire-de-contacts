package service;

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

	// Pour la création Entreprise
	public boolean addEntreprise(Entreprise etp) throws Exception {
		return cdao.insertDB(etp);
	}

	@Override
	public boolean insertDBObjects(List<Object> objects) throws Exception {
		return cdao.insertDBObjects(objects);
	}

	@Override
	public boolean insertDB(Object object) throws Exception {
		return false;
	}
	
	@Override
	public Contact getContact(long id) {
		return cdao.getContact(id);
	}

	@Override
	public Set<Contact> getAllContacts() {
		return cdao.getAllContacts();
	}
	
	@Override
	public List<Contact> getTenLastContacts() {
		return cdao.getTenLastContacts();
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
}
