package org.apache.struts.action;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ContactDAO;
import model.Adress;
import model.Contact;
import model.Group;
import model.PhoneNumber;

public class ActionEditContact extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		EditContactForm ncf = (EditContactForm) form;
		if (ncf.getNom() != null && ncf.getPrenom() != null && ncf.getMail().length() > 5) {
			ContactDAO cdao = new ContactDAO();
			Contact contact = cdao.getContact((long) ncf.getIdentifiant());
			Adress adress = contact.getAdress();
			PhoneNumber phone = new PhoneNumber(ncf.getTel());
			Set<PhoneNumber> phones = new HashSet<PhoneNumber>();
			Set<Group> groups = new HashSet<Group>();
			// ADRESS
			adress.setStreet(ncf.getAdress());
			adress.setZip(ncf.getCode_postal());
			adress.setCity(ncf.getVille());
			adress.setCountry(ncf.getPays());
			adress.setContact(contact);
			// PHONE
			phone.setContact(contact);
			phones.add(phone);
			if (ncf.getTel2() != "") {
				PhoneNumber phone2 = new PhoneNumber(ncf.getTel2());
				phone2.setContact(contact);
				phones.add(phone2);
			}
			// GROUP
			if (ncf.getGroup() != "") {
				Group group = new Group(ncf.getGroup());
				Set<Contact> contacts = new HashSet<Contact>();
				contacts.add(contact);
				group.setContacts(contacts);
				groups.add(group);
			}
			// Modifications
			contact.setNom(ncf.getNom());
			contact.setPrenom(ncf.getPrenom());
			contact.setMail(ncf.getMail());
			contact.setAdress(adress);
			contact.setPhones(phones);
			contact.setGroups(groups);
			if (cdao.saveUpdate(cdao.getSession(), contact))
				return mapping.findForward("EditOK");
			return mapping.findForward("EchecEdit");
		} else {
			return mapping.findForward("EchecEdit");
		}
	}

}
