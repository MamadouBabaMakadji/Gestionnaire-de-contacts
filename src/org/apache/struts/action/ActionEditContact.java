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
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		EditContactForm ncf = (EditContactForm) form;
		System.out.println("Passage EditAction");
		if (ncf.getNom() != null && ncf.getPrenom() != null && ncf.getMail().length() > 5) {
			Contact contact = new Contact(ncf.getContactId(), ncf.getVersionContact(), ncf.getNom(), ncf.getPrenom(), ncf.getMail());
			Adress adress = new Adress(ncf.getAdressId(), ncf.getAdress(), ncf.getVille(), ncf.getCode_postal(), ncf.getPays());
			contact.setAdress(adress);
			
			Set<Group> groups = new HashSet<>();
			Set<PhoneNumber> phones = new HashSet<>();
			
			// Debug
			System.out.println(contact.toString());
			
			/*
			// Instance Group
			for (int i = 0; i < ncf.getGroupsId().size() ; i++) {
				Group group = new Group(ncf.getGroupsId().get(i), ncf.getGroupsName().get(i), ncf.getGroupsVersion().get(i));
				groups.add(group);
			}
			contact.setGroups(groups);
			*/
			
			// Instance Phone
			for (int i = 0; i < ncf.getPhonesId().size() ; i++) {
				PhoneNumber phone = new PhoneNumber(ncf.getPhonesId().get(i), ncf.getPhonesNumber().get(i));
				phone.setContact(contact);
				phones.add(phone);
			}
			contact.setPhones(phones);
			

			ContactDAO cdao = new ContactDAO();
			if (cdao.update(contact))
				return mapping.findForward("EditOK");
			return mapping.findForward("EchecEdit");
		} else {
			return mapping.findForward("EchecEdit");
		}
	}

}
