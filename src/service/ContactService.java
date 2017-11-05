package service;

import DAO.ContactDAO;
import model.Contact;

public class ContactService 
{
	@SuppressWarnings("unused")
	private ContactDAO cdao;
	
	
	public ContactService() {
	}

	public boolean createContact(Contact contact) throws Exception{
		return (cdao = new ContactDAO()).insertDB(contact);
	}
	
	public Contact getContact(long id) {
		return(cdao = new ContactDAO()).getContact(id);
	}
	
}
