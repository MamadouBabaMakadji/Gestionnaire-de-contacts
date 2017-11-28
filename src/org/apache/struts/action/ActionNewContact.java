package org.apache.struts.action;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Adress;
import model.Contact;
import model.Group;
import model.PhoneNumber;
import service.ContactService;

public class ActionNewContact extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		NewContactForm ncf = (NewContactForm) form;
		if (ncf.getNom() != null && ncf.getPrenom() != null && ncf.getMail().length() > 5) {
			Contact contact = new Contact(ncf.getNom(), ncf.getPrenom(), ncf.getMail());
			Adress adress = new Adress(ncf.getAdresse(), ncf.getVille(), ncf.getCode_postal(), ncf.getPays());
			PhoneNumber phone = new PhoneNumber(ncf.getTel());
			Set<Contact> contacts = new HashSet<Contact>();
			Set<Group> groups = new HashSet<Group>();
			// PHONE
			Set<PhoneNumber> phones = new HashSet<PhoneNumber>();
			phone.setContact(contact);
			phones.add(phone);
			if (!"".equals(ncf.getTel2())) {
				PhoneNumber phone2 = new PhoneNumber();
				phone2.setPhoneNumber(ncf.getTel2());
				phone2.setContact(contact);
				phones.add(phone2);
			}
			if (ncf.getGroup() != "" && ncf.getGroup() != null) {
				// GROUP
				Group group = new Group(ncf.getGroup());
				contacts.add(contact);
				group.setContacts(contacts);
				groups.add(group);
			}
			// CONTACT
			contact.setAdress(adress);
			contact.setPhones(phones);
			contact.setGroups(groups);
			// Ajout contact
			ContactService cs = new ContactService();
			if (cs.createContact(contact)) {
				return mapping.findForward("AjoutOK");
			} else {
				return mapping.findForward("EchecAjout");
			}
		} else
			return mapping.findForward("EchecAjout");
	}

}
