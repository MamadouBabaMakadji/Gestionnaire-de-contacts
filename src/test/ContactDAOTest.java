package test;

import static org.junit.Assert.assertSame;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
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

		Contact contact = new Contact("Michel", "baba", "mbm@hb.net");
		Adress adress = new Adress("80 rue mbm", "Neuilly", "55121", "Mali");
		
		PhoneNumber phone1 = new PhoneNumber("7555550202");
		PhoneNumber phone2 = new PhoneNumber("0526894849");
		
		Group group1 = new Group("Nanterre");
		//group1.setGroup_ID(1);
		
		Group group2 = new Group("Paris");

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

	
	// Add a group
	@Ignore
	@Test
	public void insertDBGroupTest() {
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
	//@Ignore 
	@Test
	public void getContactTest() {
		ContactDAO contactDAO = new ContactDAO();
		Contact contact = contactDAO.getContact(1);

		System.out.println("Contact : " + contact.toString());
		
		for(PhoneNumber phoneNumber : contact.getPhones()){
			System.out.println(phoneNumber.toString());
		}
		
		for(Group group : contact.getGroups()){
			System.out.println(group.toString());
		}
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
	@Ignore 
	@Test
	public void getContactWHqlTest() {
		ContactDAO dao = new ContactDAO();
		Contact contact = dao.getContactHQL(1);
		
		System.out.println("Contact : " + contact.getNom() + ", Id = " +contact.getContact_ID()+ ", City = " +contact.getAdress().getCity());
		System.out.println("Contact : " + contact.toString());
		
		for(PhoneNumber phoneNumber : contact.getPhones()){
			System.out.println(phoneNumber.getPhoneNumber());
		}
		
		for(Group group : contact.getGroups()){
			System.out.println("Id of group = " + group.getGroup_ID()+ ", Group name" +group.getGroupName());
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
	@Ignore
	@Test
	public void updateContactTest() {
		ContactDAO dao = new ContactDAO();
		dao.deleteContact(5);
	}
	
	/**
	 *  We want to just update the group's name
	 */
	@Ignore
	@Test
	public void updateGroupTest() {
		ContactDAO dao = new ContactDAO();
		dao.getGroup(1);
		
	}
	
	
	// Update contact
	//@Ignore 
		@Test
		public void updateContact() {
			boolean result = false;

			Contact contact = new Contact("Michel", "baba", "mbm@hb.net");
			contact.setContact_ID(1);
			Adress adress = new Adress("80 rue mbm", "Neuilly", "55121", "Mali");
			
			PhoneNumber phone1 = new PhoneNumber("7555550202");
			PhoneNumber phone2 = new PhoneNumber("0526894849");
			
			Group group1 = new Group("Nanterre");
			//group1.setGroup_ID(1);
			
			Group group2 = new Group("Paris");
			//group1.setGroup_ID(2);

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
				result = contactDAO.saveUpdate(contact);
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
	
	
	// ************************* Delete ************************
	@Ignore
	@Test
	public void deleteContactTest() {
		ContactDAO dao = new ContactDAO();
		dao.deleteContact(5);
	}
	
	@Ignore
	@Test
	public void deleteGroupsTest() {
		ContactDAO dao = new ContactDAO();
		dao.deleteGroup(7);
	}
	
	
}
