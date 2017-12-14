package org.apache.struts.action;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.Adress;
import model.Contact;
import model.Entreprise;
import model.Group;
import model.PhoneNumber;
import service.IContactService;

public class ActionNewContact extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		NewContactForm ncf = (NewContactForm) form;
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
		IContactService IContactService = (service.IContactService) context.getBean("service");
		Adress adress = new Adress(ncf.getAdresse(), ncf.getVille(), ncf.getCode_postal(), ncf.getPays());
		PhoneNumber phone = new PhoneNumber(ncf.getTel());
		Set<PhoneNumber> phones = new HashSet<PhoneNumber>();
		Set<Group> groups = new HashSet<Group>();
		if ("Personne".equals(ncf.getTypeContact())) {
			phones.add(phone);
			Contact contact = new Contact(ncf.getNom(), ncf.getPrenom(), ncf.getMail());
			Set<Contact> contacts = new HashSet<Contact>();
			// PHONE
			phone.setContact(contact);
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
			if (IContactService.createContact(contact)) {
				return mapping.findForward("AjoutOK");
			} else {
				return mapping.findForward("EchecAjout");
			}
		} else {
			// ENTREPRISE
			Entreprise etp = new Entreprise(ncf.getNom(), ncf.getMail(), adress, phones, ncf.getSiretEtp());
			phone.setContact(etp);
			phones.add(phone);
			if (!"".equals(ncf.getTel2())) {
				PhoneNumber phone2 = new PhoneNumber();
				phone2.setPhoneNumber(ncf.getTel2());
				phone2.setContact(etp);
				phones.add(phone2);

			}
			etp.setPhones(phones);
			if (ncf.getGroup() != "" && ncf.getGroup() != null) {
				// GROUP
				Group group = new Group(ncf.getGroup());
				groups.add(group);
				etp.setGroups(groups);
			}
			if (IContactService.addEntreprise(etp))
				return mapping.findForward("AjoutOK");
			return mapping.findForward("EchecAjout");
		}

	}

}
