package org.apache.struts.action;

import java.util.HashSet;

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
			ContactService cs = new ContactService();
			Adress adress = new Adress(ncf.getAdresse(), ncf.getVille(), ncf.getCode_postal(), ncf.getPays());
			PhoneNumber phone = new PhoneNumber(ncf.getTel());
			Group group = null;
			HashSet<Group> listGroup = new HashSet<Group>();
			HashSet<PhoneNumber> listPhone = new HashSet<PhoneNumber>();
			HashSet<Contact> listContact = new HashSet<Contact>();
			Contact contact = new Contact(ncf.getNom(), ncf.getPrenom(), ncf.getMail(), adress, listPhone /*, listGroup*/);
			// if (ncf.getGroup() != "" && ncf.getGroup() != null) {
			group = new Group(ncf.getGroup());
			listContact.add(contact);
			group.setContacts(listContact);
			listGroup.add(group);
			contact.setGroups(listGroup);
			// }
			phone.setContact(contact);
			listPhone.add(phone);
			contact.setPhones(listPhone);

			if (cs.createContact(contact)) {
				return mapping.findForward("AjoutOK");
			} else {
				return mapping.findForward("EchecAjout");
			}
		} else
			return mapping.findForward("EchecAjout");
	}

}
