package test;

import static org.junit.Assert.assertSame;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import DAO.ContactDaoImpl;
import DAO.IContactDao;
import model.Adress;
import model.Contact;
import model.Group;
import model.PhoneNumber;

public class DAOSpringImplTest {

	// ************************* Create ************************
	// Add contact w multiples phones and w multiples groups
	//@Ignore 
	@Test
	public void insertDBContactWPG() {
		boolean result = false;

		Contact contact = new Contact("toto", "stMichel", "mbm@hb.net");
		Adress adress = new Adress("80 rue mbm", "Neuilly", "55121", "Mali");
		
		PhoneNumber phone1 = new PhoneNumber("0404040404");
		PhoneNumber phone2 = new PhoneNumber("0505050505");
		
		Group group1 = new Group(5, "Info", 3);
		Group group2 = new Group(4, "Miage", 4);

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
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
		IContactDao IContactDao = (DAO.IContactDao) context.getBean("dao");
		
		try {
			result = IContactDao.insertDBObjects(objects);
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
		Group group3 = new Group("Info");
		Group group4 = new Group("DZ");

		// Test add group
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
		IContactDao IContactDao = (DAO.IContactDao) context.getBean("dao");
		try {
/*			result = ContactDaoImpl.insertDB(group1);
			result = ContactDaoImpl.insertDB(group2);*/
			result = IContactDao.insertDB(group4);
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
			ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
			IContactDao IContactDao = (DAO.IContactDao) context.getBean("dao");
			Contact contact = IContactDao.getContact(1);
			//Contact contact = ContactDaoImpl.getContact2(2);

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
	
	
	//@Ignore
	@Test
	public void getAllContactTest() {
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
			IContactDao IContactDao = (DAO.IContactDao) context.getBean("dao");
			List<Contact> contacts = IContactDao.getAllContacts();
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
	
	
	//@Ignore
	@Test
	public void getAllContactWGroupsTest() {
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
			IContactDao IContactDao = (DAO.IContactDao) context.getBean("dao");
			Set<Contact> contacts = IContactDao.getAllContactsWGroups();
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
			e.printStackTrace();
		}
	}
	
	
	// Get a contact by HQL
	//@Ignore 
	@Test
	public void getAllContactsHQLTest() {
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
			IContactDao IContactDao = (DAO.IContactDao) context.getBean("dao");
			Set<Contact> contacts = IContactDao.getAllContactsLazy();
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
			e.printStackTrace();
		}
	}

	
	// Test for get a group by an id
	//@Ignore
	@Test
	public void getGroupTest() {
		Group group = null;
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
			IContactDao IContactDao = (DAO.IContactDao) context.getBean("dao");
			group = IContactDao.getGroup(3);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(group.toString());
	}


	//@Ignore 
	@Test
	public void getAllGroupsTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
		IContactDao IContactDao = (DAO.IContactDao) context.getBean("dao");
		Set<Group> groups = IContactDao.getAllGroups();
		for(Group group : groups){
			System.out.println(group.toString());
		}
	}


	// Get contact from an id of group
	//@Ignore
	@Test
	public void getContactsFromIdGroupTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
		IContactDao IContactDao = (DAO.IContactDao) context.getBean("dao");
		Set<Contact> contacts = IContactDao.getContactsByGroupId(5);
		for(Contact c : contacts){
			System.out.println(c.toString());
			for(Group group : c.getGroups()) {
				System.out.println(group.toString());
			}
		}
	}
	
	
	// Test Search contacts
	//@Ignore 
	@Test
	public void searchContactsByNameTest(){
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
		IContactDao IContactDao = (DAO.IContactDao) context.getBean("dao");
		Set<Contact> contacts = IContactDao.searchContacts("Baba");
		System.out.println("toto il va péter");
		for(Contact c : contacts) {
			System.out.println("Id : " +c.getContact_ID()+ ", nom : " +c.getNom()+ ", prénom : " +c.getPrenom());
		}
	}
	
	
	//@Ignore
	@Test
	public void searchContactsByCountryTest(){
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
		IContactDao IContactDao = (DAO.IContactDao) context.getBean("dao");
		Set<Contact> contacts = IContactDao.searchContacts("France Mali");
		System.out.println("toto il va péter");
		for(Contact c : contacts) {
			System.out.println("Id : " +c.getContact_ID()+ ", nom : " +c.getNom()+ ", prénom : " +c.getPrenom());
		}
	}
	
	
	@Ignore 
	@Test
	public void searchContactsByCityTest() {
		ContactDaoImpl ContactDaoImpl = new ContactDaoImpl();
		Set<Contact> contacts = ContactDaoImpl.searchContacts("Auber Neuilly");
		System.out.println("toto il va péter");
		for(Contact c : contacts){
			System.out.println("Id : " +c.getContact_ID()+ ", nom : " +c.getNom()+ ", prénom : " +c.getPrenom());
		}
	}
	
	
	//@Ignore
	@Test
	public void searchContactsByGroupNameTest(){
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
		IContactDao IContactDao = (DAO.IContactDao) context.getBean("dao");
		Set<Contact> contacts = IContactDao.searchContacts("Miage");
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

			Contact contact = new Contact(2, 5, "toto", "baba", "mbm@hb.net");
			Adress adress = new Adress(2, "80 rue mbm", "Paris", "55121", "DZ");
			contact.setAdress(adress);
			
			PhoneNumber phone1 = new PhoneNumber(3, "0202020202", contact);
/*			PhoneNumber phone2 = new PhoneNumber(4, "0303030303", contact);*/
			
/*			Group group1 = new Group(4, "Miage", 3);
			Group group2 = new Group(3, "Paris X", 2);*/
			Group group3 = new Group(5, "Info", 2);

			Set<PhoneNumber> phones = new HashSet<PhoneNumber>();
			phone1.setContact(contact); 
			/*phone2.setContact(contact);*/
			phones.add(phone1);
/*			phones.add(phone2);*/
			contact.setPhones(phones);

			Set<Group> groups = new HashSet<Group>();
/*			groups.add(group1);
			groups.add(group2);*/
			groups.add(group3);
			/*group2.getContacts().add(contact);
			group1.getContacts().add(contact);*/
			group3.getContacts().add(contact);
			
			contact.setGroups(groups);
			
			ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
			IContactDao IContactDao = (DAO.IContactDao) context.getBean("dao");
			
			IContactDao.update(contact);
			
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
			Group group = new Group(4, "Miage", 6);
			ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
			IContactDao IContactDao = (DAO.IContactDao) context.getBean("dao");
			group.setGroupName("MIIAGEE");
			IContactDao.update(group);
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
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
		IContactDao IContactDao = (DAO.IContactDao) context.getBean("dao");
		IContactDao.deleteContact(3);
	}
	
	//@Ignore
	@Test
	public void deleteGroupsTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
		IContactDao IContactDao = (DAO.IContactDao) context.getBean("dao");
		IContactDao.deleteGroup(2);
	}

}
