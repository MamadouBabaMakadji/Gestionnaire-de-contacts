package org.apache.struts.action;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.StaleObjectStateException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate4.HibernateOptimisticLockingFailureException;

import DAO.IContactDao;
import model.Adress;
import model.Contact;
import model.PhoneNumber;
import service.IContactService;

public class ActionEditContact extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		EditContactForm ncf = (EditContactForm) form;
		System.out.println("Passage EditAction");
		System.out.println("Contact Id = " +ncf.getContactId());
		System.out.println("Contact version = " +ncf.getVersionContact());
		
  		if (ncf.getNom() != null && ncf.getPrenom() != null && ncf.getMail().length() > 5) {
			ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
			/*IContactService service = (IContactService) context.getBean("service");*/
			IContactDao dao = (DAO.IContactDao) context.getBean("dao");
			
			boolean result = false;
			Contact contact = dao.getContact(ncf.getContactId());
			Adress adress = contact.getAdress();
			System.out.println("Contact toString : " +contact.toString());	
			
			// PHONES
			Set<PhoneNumber> phonesContact = new HashSet<>();
			//The field has already an id
			if (ncf.getPhoneNumber1Id()!= 0) {
				// But the user deletes this content so we delete the phone in the db
				if(ncf.getPhoneNumber1().isEmpty() || ncf.getPhoneNumber1() == null) {
					System.out.println("phone1 = " +ncf.getPhoneNumber1Id());
					
					dao.deletePhone(ncf.getPhoneNumber1Id(), contact.getContact_ID());
				} 
				// or user just wants to update it
				else {
					PhoneNumber phone1 = new PhoneNumber(ncf.getPhoneNumber1Id(), ncf.getPhoneNumber1(), contact);
					phonesContact.add(phone1);
				}
			} 
			// The field hasn't an id so the user wants to add a new Phone Number
			else {
				System.out.println("passage add phone 1");
				PhoneNumber phone1 = new PhoneNumber(ncf.getPhoneNumber1(), contact);
				System.out.println("phone1 iD= " + phone1.getPhone_ID());
				System.out.println("size phonesContact = " +phonesContact.size());
				phonesContact.add(phone1);
			}
			
			if (ncf.getPhoneNumber2Id()!= 0) {
				// But the user deletes this content so we delete the phone in the db
				if(ncf.getPhoneNumber2().isEmpty() || ncf.getPhoneNumber2() == null) {
					System.out.println("phone2 = " +ncf.getPhoneNumber2Id());
					dao.deletePhone(ncf.getPhoneNumber2Id(), contact.getContact_ID());
				} 
				// or user just wants to update it
				else {
					PhoneNumber phone2 = new PhoneNumber(ncf.getPhoneNumber2Id(), ncf.getPhoneNumber2(), contact);
					phonesContact.add(phone2);
				}
			} 
			// The field hasn't an id so the user wants to add a new Phone Number
			else {
				System.out.println("passage add phone 2");
				PhoneNumber phone2 = new PhoneNumber(ncf.getPhoneNumber2(), contact);
				System.out.println("phone2 iD= " + phone2.getPhone_ID());
				System.out.println("size phonesContact = " +phonesContact.size());
				phonesContact.add(phone2);
				
			}
			
			System.out.println("size phonesContact = " +phonesContact.size());
			// CONTACT
			contact.setNom(ncf.getNom());
			contact.setPrenom(ncf.getPrenom());
			contact.setMail(ncf.getMail());
			contact.setAdress(adress);
			contact.setPhones(phonesContact);
			contact.setVersion(ncf.getVersionContact());

			// ADRESS
			adress.setStreet(ncf.getStreet());
			adress.setZip(ncf.getZip());
			adress.setCity(ncf.getCity());
			adress.setCountry(ncf.getCountry());
			adress.setContact(contact);
			
			try {
				dao.update(contact);
			} catch (HibernateOptimisticLockingFailureException e) {
				e.printStackTrace();
				return mapping.findForward("EchecEdit");
			} catch (StaleObjectStateException e) {
				e.printStackTrace();
				return mapping.findForward("EchecEdit");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return mapping.findForward("EditOK");
	}

}
