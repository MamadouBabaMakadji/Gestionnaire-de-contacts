package org.apache.struts.action;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.Adress;
import model.Contact;
import model.Group;
import model.PhoneNumber;
import service.IContactService;

public class ActionEditContact extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		EditContactForm ncf = (EditContactForm) form;
		System.out.println("Passage EditAction");
		if (ncf.getNom() != null && ncf.getPrenom() != null && ncf.getMail().length() > 5) {
			ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
			IContactService IContactService = (service.IContactService) context.getBean("service");
			Contact contact = IContactService.getContact((long) ncf.getContactId());
			Adress adress = contact.getAdress();
			Set<PhoneNumber> phones = contact.getPhones();
			Iterator<PhoneNumber> iter = phones.iterator();
			PhoneNumber phone = iter.next();
			PhoneNumber phone2;
			Set<Group> groups = new HashSet<Group>();

			// ADRESS
			adress.setStreet(ncf.getAdress());
			adress.setZip(ncf.getCode_postal());
			adress.setCity(ncf.getVille());
			adress.setCountry(ncf.getPays());
			adress.setContact(contact);

			// PHONE
//			Object[] objectPhone = phones.toArray();
//			if (!"".equals(ncf.getTel2())) {
//				System.out.println("Taille --> " + objectPhone.length);
//				if (objectPhone.length > 1) {
//					if (!(((PhoneNumber) objectPhone[1]).getPhoneNumber()).equals(ncf.getTel2())) {
//						phone2 = (PhoneNumber) objectPhone[1];
//						phone2.setPhoneNumber(ncf.getTel2());
//						phone2.setContact(contact);
//						phone.setPhoneNumber(ncf.getTel());
//						phones.clear();
//						phones.add(phone);
//						phones.add(phone2);
//					} else {
//						phone.setPhoneNumber(ncf.getTel());
//						phones.clear();
//						phones.add(phone);
//					}
//				}
//			} else {
//				phone2 = new PhoneNumber();
//				phone2.setPhoneNumber(ncf.getTel2());
//				phone2.setContact(contact);
//				phone.setPhoneNumber(ncf.getTel());
//				phones.clear();
//				phones.add(phone);
//				phones.add(phone2);
//			}
//
//			// GROUP
//			if (ncf.getGroup() != "") {
//				Group group = new Group(ncf.getGroup());
//				Set<Contact> contacts = new HashSet<Contact>();
//				contacts.add(contact);
//				group.setContacts(contacts);
//				groups.add(group);
//			}
//			// Modifications
//			contact.setNom(ncf.getNom());
//			contact.setPrenom(ncf.getPrenom());
//			contact.setMail(ncf.getMail());
//			contact.setAdress(adress);
//			contact.setPhones(phones);
//			contact.setVersion(ncf.getVersion());
			if (IContactService.saveUpdate(contact))
				return mapping.findForward("EditOK");
			return mapping.findForward("EchecEdit");
		} else {
			return mapping.findForward("EchecEdit");
		}
	}

}
