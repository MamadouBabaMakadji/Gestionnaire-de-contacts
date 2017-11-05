package test;

import static org.junit.Assert.assertSame;

import java.util.HashSet;
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
	//@Ignore 
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
	
}
