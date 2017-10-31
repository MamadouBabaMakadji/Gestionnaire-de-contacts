package model;

import java.util.HashSet;
import java.util.Set;

import service.ContactService;

public class Main {
	public static void main(String[] args) throws Exception {
		Adress adress = new Adress("80 rue mbm", "Auber", "55121", "Mali");
		PhoneNumber phone = new PhoneNumber("7555550202");
		PhoneNumber phone2 = new PhoneNumber("0526894849");
		Contact contact = new Contact("Makadji", "Mamadou", "mbm@hb.net");
		Group group = new Group("Miage");
		Group group2 = new Group("TMT");

		// Contact
		Set<PhoneNumber> listPhone = new HashSet<PhoneNumber>();
		Set<Group> groups = new HashSet<Group>();
		contact.setAdress(adress);
		phone.setContact(contact);
		phone2.setContact(contact);
		listPhone.add(phone);
		listPhone.add(phone2);
		contact.setPhones(listPhone);
		groups.add(group);
		groups.add(group2);

		// Group
		Set<Contact> contacts = new HashSet<Contact>();
		contacts.add(contact);
		group.setContacts(contacts);
		group2.setContacts(contacts);

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