package test;

import static org.junit.Assert.assertSame;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Ignore;
import org.junit.Test;

import DAO.ContactDAO;
import model.Adress;
import model.Contact;
import model.Group;
import model.PhoneNumber;

public class ContactDAOTest {


	// Add contact w multiples phones
	@Ignore @Test
	public void insertDBTest() {
		boolean result = false;

		Contact contact = new Contact("Michel", "Baba", "mbm@hb.net");
		Adress adress = new Adress("80 rue mbm", "Auber", "55121", "Mali");
		PhoneNumber phone1 = new PhoneNumber("7555550202");
		PhoneNumber phone2 = new PhoneNumber("0526894849");
		Group group1 = new Group("Miage");
		Group group2 = new Group("TOTO");

		// Contact
		contact.setAdress(adress);

		phone1.setContact(contact); phone2.setContact(contact);
		contact.getPhones().add(phone1); contact.getPhones().add(phone2);

		Set<Group> groups = new HashSet<Group>();
		groups.add(group1); groups.add(group2);
		contact.setGroups(groups);

		/*		group1.getContacts().add(contact);
		contact.getGroups().add(group1);
		group2.getContacts().add(contact);
		contact.getGroups().add(group2);*/

		// Test ajout contact
		ContactDAO contactDAO = new ContactDAO();
		try {
			result = contactDAO.insertDB(contact);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (result) {
			System.out.println("OK");
		} else {
			System.out.println("Echec");
		}

		assertSame(true, result);
	}


	// Get contact
	@Ignore
	@Test
	public void getContact() {
		ContactDAO contactDAO = new ContactDAO();
		Contact contact = contactDAO.getContact(1);
		
		System.out.println("Contact : " + contact.toString());
		
		for(PhoneNumber phoneNumber : contact.getPhones()){
			System.out.println(phoneNumber.getPhoneNumber());
		}
		
		for(Group group : contact.getGroups()){
			System.out.println(group.toString());
		}
	}
	
	// Test Search contacts
	@Test
	public void getContactsByName(){
		ContactDAO contactDAO = new ContactDAO();
		Set<Contact> contacts = contactDAO.getContacts("Baba");
		System.out.println("toto il va péter");
		for(Contact c : contacts){
			System.out.println("Id : " +c.getContact_ID()+ ", nom : " +c.getNom()+ ", prénom : " +c.getPrenom());
		}
	}
	
	
	@Test
	public void getContactsByCountry(){
		ContactDAO contactDAO = new ContactDAO();
		Set<Contact> contacts = contactDAO.getContacts("France Mali");
		System.out.println("toto il va péter");
		for(Contact c : contacts){
			System.out.println("Id : " +c.getContact_ID()+ ", nom : " +c.getNom()+ ", prénom : " +c.getPrenom());
		}
	}
	
	
	@Test
	public void getContactsByCity(){
		ContactDAO contactDAO = new ContactDAO();
		Set<Contact> contacts = contactDAO.getContacts("Auber Neuilly");
		System.out.println("toto il va péter");
		for(Contact c : contacts){
			System.out.println("Id : " +c.getContact_ID()+ ", nom : " +c.getNom()+ ", prénom : " +c.getPrenom());
		}
	}
	
	@Test
	public void getContactsByGroupName(){
		ContactDAO contactDAO = new ContactDAO();
		Set<Contact> contacts = contactDAO.getContacts("Miage");
		System.out.println("toto il va péter");
		for(Contact c : contacts){
			System.out.println("Id : " +c.getContact_ID()+ ", nom : " +c.getNom()+ ", prénom : " +c.getPrenom());
		}
	}
	
}
