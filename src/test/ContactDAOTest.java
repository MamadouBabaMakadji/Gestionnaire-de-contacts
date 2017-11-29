package test;

import static org.junit.Assert.assertSame;

import java.util.HashSet;
import java.util.LinkedList;
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

	// ************************* Create ************************
	// Add contact w multiples phones and w multiples groups
	//@Ignore 
	@Test
	public void insertDBContactWPhonesTest() {
		boolean result = false;

		Contact contact = new Contact("toto", "baba", "mbm@hb.net");
		Adress adress = new Adress("80 rue mbm", "Auber", "55121", "Mali");
		
		PhoneNumber phone1 = new PhoneNumber("7555550202");
		PhoneNumber phone2 = new PhoneNumber("0526894849");
		
		Group group1 = new Group("Nanterre");
		Group group2 = new Group("Rouen");

		// Contact
		contact.setAdress(adress);

		Set<PhoneNumber> phones = new HashSet<PhoneNumber>();
		phone1.setContact(contact); phone2.setContact(contact);
		phones.add(phone1);
		phones.add(phone2);
		contact.setPhones(phones);

		Set<Group> groups = new HashSet<Group>();
		groups.add(group1);
		groups.add(group2);
		contact.setGroups(groups);

		List<Object> objects = new LinkedList<Object>();
		objects.add(contact);
		objects.add(phone1);
		objects.add(phone2);
		
		// Test ajout contact
		ContactDAO contactDAO = new ContactDAO();
		try {
			result = contactDAO.insertDBObjects(objects);
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
		
	
	// Add contact w multiples phones & groups
	@Ignore 
	@Test
	public void insertDBContactWPhonesGroupsTest() {
		boolean result = false;

		Contact contact = new Contact("oussema", "Baba", "mbm@hb.net");
		Adress adress = new Adress("80 rue mbm", "Neuilly", "55121", "Mali");
		PhoneNumber phone1 = new PhoneNumber("7555550202");
		PhoneNumber phone2 = new PhoneNumber("0526894849");
		Group group1 = new Group("Miage");

		// Contact
		contact.setAdress(adress);
		
		phone1.setContact(contact);
		phone2.setContact(contact);
		contact.getPhones().add(phone1);
		contact.getPhones().add(phone2);

		contact.getGroups().add(group1);
		
		group1.getContacts().add(contact);

		// Test add contact
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

	
	// Add contact w multiples phones & groups
	@Ignore
	@Test
	public void insertDBGroup() {
		boolean result = false;

		Group group1 = new Group("TOTO");

		// Test add group
		ContactDAO contactDAO = new ContactDAO();
		try {
			result = contactDAO.insertDB(group1);
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
	
	
	// ************************* Read ************************
	
	// Get a contact
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
	
	@Ignore 
	@Test
	public void getGroups() {
		ContactDAO contactDAO = new ContactDAO();
		Set<Group> groups = contactDAO.getGroups();
		for(Group group : groups){
			System.out.println(group.toString());
		}
	}


	// Get contact from an id of group
	@Ignore
	@Test
	public void getContactsFromIdGroup() {
		ContactDAO contactDAO = new ContactDAO();
		Set<Contact> contacts = contactDAO.getContactByGroupId(1);
		for(Contact c : contacts){
			System.out.println("Id : " +c.getContact_ID()+ ", nom : " +c.getNom()+ ", prénom : " +c.getPrenom());
			
			for(Group group : c.getGroups()) {
				System.out.println(group.getGroupName());
			}
		}
	}
	
	// Test Search contacts
	@Ignore @Test
	public void searchContactsByName(){
		ContactDAO contactDAO = new ContactDAO();
		Set<Contact> contacts = contactDAO.searchContacts("Baba");
		System.out.println("toto il va péter");
		for(Contact c : contacts){
			System.out.println("Id : " +c.getContact_ID()+ ", nom : " +c.getNom()+ ", prénom : " +c.getPrenom());
		}
	}
	
	@Ignore @Test
	public void searchContactsByCountry(){
		ContactDAO contactDAO = new ContactDAO();
		Set<Contact> contacts = contactDAO.searchContacts("France Mali");
		System.out.println("toto il va péter");
		for(Contact c : contacts){
			System.out.println("Id : " +c.getContact_ID()+ ", nom : " +c.getNom()+ ", prénom : " +c.getPrenom());
		}
	}
	
	@Ignore @Test
	public void searchContactsByCity(){
		ContactDAO contactDAO = new ContactDAO();
		Set<Contact> contacts = contactDAO.searchContacts("Auber Neuilly");
		System.out.println("toto il va péter");
		for(Contact c : contacts){
			System.out.println("Id : " +c.getContact_ID()+ ", nom : " +c.getNom()+ ", prénom : " +c.getPrenom());
		}
	}
	
	@Ignore @Test
	public void searchContactsByGroupName(){
		ContactDAO contactDAO = new ContactDAO();
		Set<Contact> contacts = contactDAO.searchContacts("Miage");
		System.out.println("toto il va péter");
		for(Contact c : contacts){
			System.out.println("Id : " +c.getContact_ID()+ ", nom : " +c.getNom()+ ", prénom : " +c.getPrenom());
		}
	}
	
	
	// ************************* Update ************************
	
	
	// ************************* Delete ************************
	
	
	
}
