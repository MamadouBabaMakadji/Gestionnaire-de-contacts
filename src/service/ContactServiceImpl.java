package service;

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

	public Contact getContact(long id) {
		return cdao.getContact(id);
	}

	public Set<Contact> getAllContacts() {
		return cdao.getAllContacts();
	}

	public Set<Group> getGroups() {
		return cdao.getAllGroups();
	}

	public Set<Contact> seachContacts(String keywords) {
		return cdao.searchContacts(keywords);
	}

	@Override
	public boolean saveUpdate(Contact contact) {
		return cdao.saveUpdate(contact);
	}

	@Override
	public boolean deleteContact(long contact_ID) {
		return cdao.deleteContact(contact_ID);
	}
}
