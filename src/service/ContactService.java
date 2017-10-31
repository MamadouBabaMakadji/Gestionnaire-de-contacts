package service;

import DAO.ContactDAO;
import model.Contact;

public class ContactService 
{
	@SuppressWarnings("unused")
	private ContactDAO cdao;
	
	
	public ContactService() {
		
	}

	public boolean createContact(Contact c) throws Exception{
		return (cdao = new ContactDAO()).insert_contact(c);
	}
//	public boolean ajoutAdress(Adress a)
//	{
//		return (cdao = new ContactDAO()).ajouterAdress(a);
//	}
//	
//	public boolean ajoutPhoneNumber(PhoneNumber p){
//		return (cdao = new ContactDAO()).ajouterPhone(p);
//	}
//	
//	public boolean deleteContact(String id){
//		return (cdao = new ContactDAO()).delete(id);
//	}
//	
//	public boolean editContact(Contact c){
//		return (cdao = new ContactDAO()).edit(c);
//	}
//	
//	public boolean editAdress(Adress a){
//		return (cdao = new ContactDAO()).edit_a(a);
//	}
//	
//	public boolean editGroup(Group gp){
//		return (cdao = new ContactDAO()).edit_group(gp);
//	}
//	
//	public boolean editPhone(PhoneNumber p){
//		return (cdao = new ContactDAO()).edit_p(p);
//	}
//	public boolean deleteContact(Contact c,Adress a, PhoneNumber p){
//		return (cdao = new ContactDAO()).deleteContact(c,a,p);
//	}
//	
//	public List<Contact> searchContact(String searchName) {
//		 return (cdao = new ContactDAO()).searchContact(searchName);
//	}
//	
//	/*public Contact searchContact(String id){
//		return (cdao.search(id));
//	}*/
//	
//	public boolean createGroupContact(String nom){
//		return(cdao = new ContactDAO()).createGroup(nom);
//	}
//	
//	public boolean ajoutContactInGroup(Group gc, int id_contact){
//		return (cdao = new ContactDAO()).ajouterContactInGroup(gc, id_contact);
//	}
//	
//	public List<Group> getNameGroup()
//	{
//		return (cdao = new ContactDAO()).getNameGroup();
//	}
//	
//	public List<Contact> afficheContactDuGroup(String idGroup)
//	{
//		return (cdao = new ContactDAO()).listContactOfGroup(idGroup);
//	}
//	
//	
	
}
