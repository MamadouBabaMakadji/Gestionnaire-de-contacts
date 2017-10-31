package model;

import java.util.HashSet;
import java.util.Set;

import service.ContactService;

public class Main {
	public static void main(String[] args) throws Exception {
		Contact contact = new Contact("Makadji", "Mamadou Baba", "mbm@hb.net");
		Adress adress = new Adress("80 rue mbm", "Djelibougou", "99000", "Mali");
		PhoneNumber phone1 = new PhoneNumber("7555550202");
		PhoneNumber phone2 = new PhoneNumber("0526894849");
		Group group1 = new Group("MIAGE");
		Group group2 = new Group("TMT");

		// PHONE
		Set<PhoneNumber> phones = new HashSet<PhoneNumber>();
		phone1.setContact(contact);
		phone2.setContact(contact);
		phones.add(phone1);
		phones.add(phone2);

		// GROUP
		Set<Contact> contacts = new HashSet<Contact>();
		Set<Group> groups = new HashSet<Group>();
		contacts.add(contact);
		group1.setContacts(contacts);
		group2.setContacts(contacts);
		groups.add(group1);
		groups.add(group2);

		// CONTACT
		contact.setAdress(adress);
		contact.setPhones(phones);
		contact.setGroups(groups);

		// Ajout contact
		ContactService cs = new ContactService();
		boolean result = cs.createContact(contact);
		if (result) {
			System.out.println("OK");
		} else {
			System.out.println("Echec");
		}
	}
}