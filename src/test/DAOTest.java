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
import service.ContactService;

public class DAOTest {

	// ************************* Create ************************
	// Add contact w multiples phones and w multiples groups
	//@Ignore 
	@Test
	public void insertDBContactWPG() {
		boolean result = false;

		Contact contact = new Contact("toto", "baba", "mbm@hb.net");
		Adress adress = new Adress("80 rue mbm", "Neuilly", "55121", "Mali");
		
		PhoneNumber phone1 = new PhoneNumber("7555550202");
		PhoneNumber phone2 = new PhoneNumber("0526894849");
		
		Group group1 = new Group(1, "Miage", 1);
		Group group2 = new Group(2, "Paris X", 1);

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

	
	// Add a group
	//@Ignore
	@Test
	public void insertDBGroupTest() {
		boolean result = false;

		Group group1 = new Group("Miage");
		Group group2 = new Group("Paris X");

		// Test add group
		ContactDAO contactDAO = new ContactDAO();
		try {
			result = contactDAO.insertDB(group1);
			result = contactDAO.insertDB(group2);
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
	//@Ignore 
	@Test
	public void getContactTest() {
		try {
			ContactDAO contactDAO = new ContactDAO();
			//Contact contact = contactDAO.getContact(1);
			Contact contact = contactDAO.getContact2(2);

			System.out.println("Contact : " + contact.toString());
			
			for(PhoneNumber phoneNumber : contact.getPhones()){
				System.out.println(phoneNumber.toString());
			}
			
			for(Group group : contact.getGroups()){
				System.out.println(group.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// Test for get a group by an id
	@Ignore
	@Test
	public void getGroupTest() {
		Group group = null;
		try {
			ContactDAO dao = new ContactDAO();
			group = dao.getGroup(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Group name : " + group.getGroupName());
	}


	//@Ignore
	@Test
	public void getAllContactTest() {
		try {
			ContactDAO dao = new ContactDAO();
			Set<Contact> contacts = dao.getAllContacts();
			for(Contact contact : contacts) {
				System.out.println("Contact : " + contact.toString());
				
				for(PhoneNumber phoneNumber : contact.getPhones()) {
					System.out.println(phoneNumber.toString());
				}
				
				for(Group group : contact.getGroups()) {
					System.out.println(group.toString());
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	// Get a contact by HQL
	//@Ignore 
	@Test
	public void getAllContactsHQLTest() {
		try {
			ContactDAO dao = new ContactDAO();
			Set<Contact> contacts = dao.getAllContactsLazy();
			for(Contact contact : contacts) {
				System.out.println("Contact : " + contact.toString2());
				
				for(PhoneNumber phoneNumber : contact.getPhones()) {
					System.out.println(phoneNumber.toString());
				}
				
				for(Group group : contact.getGroups()) {
					System.out.println(group.toString());
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//@Ignore 
	@Test
	public void getAllGroupsTest() {
		ContactDAO dao = new ContactDAO();
		Set<Group> groups = dao.getAllGroups();
		for(Group group : groups){
			System.out.println(group.toString());
		}
	}


	// Get contact from an id of group
	@Ignore
	@Test
	public void getContactsFromIdGroupTest() {
		ContactDAO contactDAO = new ContactDAO();
		Set<Contact> contacts = contactDAO.getContactsByGroupId(9);
		for(Contact c : contacts){
			System.out.println("Id : " +c.getContact_ID()+ ", nom : " +c.getNom()+ ", prénom : " +c.getPrenom());
			
			for(Group group : c.getGroups()) {
				System.out.println(group.getGroupName());
			}
		}
	}
	
	
	// Test Search contacts
	@Ignore 
	@Test
	public void searchContactsByNameTest(){
		ContactDAO contactDAO = new ContactDAO();
		Set<Contact> contacts = contactDAO.searchContacts("Baba");
		System.out.println("toto il va péter");
		for(Contact c : contacts){
			System.out.println("Id : " +c.getContact_ID()+ ", nom : " +c.getNom()+ ", prénom : " +c.getPrenom());
		}
	}
	
	
	@Ignore
	@Test
	public void searchContactsByCountryTest(){
		ContactDAO contactDAO = new ContactDAO();
		Set<Contact> contacts = contactDAO.searchContacts("France Mali");
		System.out.println("toto il va péter");
		for(Contact c : contacts){
			System.out.println("Id : " +c.getContact_ID()+ ", nom : " +c.getNom()+ ", prénom : " +c.getPrenom());
		}
	}
	
	
	@Ignore 
	@Test
	public void searchContactsByCityTest(){
		ContactDAO contactDAO = new ContactDAO();
		Set<Contact> contacts = contactDAO.searchContacts("Auber Neuilly");
		System.out.println("toto il va péter");
		for(Contact c : contacts){
			System.out.println("Id : " +c.getContact_ID()+ ", nom : " +c.getNom()+ ", prénom : " +c.getPrenom());
		}
	}
	
	
	@Ignore
	@Test
	public void searchContactsByGroupNameTest(){
		ContactDAO contactDAO = new ContactDAO();
		Set<Contact> contacts = contactDAO.searchContacts("Miage");
		System.out.println("toto il va péter");
		for(Contact c : contacts){
			System.out.println("Id : " +c.getContact_ID()+ ", nom : " +c.getNom()+ ", prénom : " +c.getPrenom());
		}
	}
	
	
	// ************************* Update ************************
	
	// Update contact
	//@Ignore 
	@Test
	public void updateContact() {
		boolean result = false;
		try {

			Contact contact = new Contact(2, 0, "toto", "baba", "mbm@hb.net");
			Adress adress = new Adress(2, "80 rue mbm", "Paris", "55121", "DZ");
			contact.setAdress(adress);
			
			PhoneNumber phone1 = new PhoneNumber(3, "0202020202", contact);
			PhoneNumber phone2 = new PhoneNumber(4, "0526894849", contact);
			
			Group group1 = new Group(1, "Miage", 2);
			Group group2 = new Group(2, "Paris X", 2);

			Set<PhoneNumber> phones = new HashSet<PhoneNumber>();
			phone1.setContact(contact); phone2.setContact(contact);
			phones.add(phone1);
			phones.add(phone2);
			contact.setPhones(phones);

			Set<Group> groups = new HashSet<Group>();
			groups.add(group1);
			//groups.add(group2);
			/*group2.getContacts().add(contact);
			group1.getContacts().add(contact);*/
			contact.setGroups(groups);
			
			
			ContactDAO dao = new ContactDAO();
			dao.update(contact);
			
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		assertSame(true, result);
	}
	
	
	//@Ignore
	@Test
	public void updateGroup() {
		boolean result = false;
		try {
			Group group = new Group(2, "Miage", 11);
			ContactDAO dao = new ContactDAO();
			dao.update(group);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertSame(true, result);
	}
	
	
	// ************************* Delete ************************
	
	//@Ignore
	@Test
	public void deleteContactTest() {
		ContactDAO dao = new ContactDAO();
		dao.deleteContact(1);
	}
	
	//@Ignore
	@Test
	public void deleteGroupsTest() {
		ContactDAO dao = new ContactDAO();
		dao.deleteGroup(2);
	}

}
