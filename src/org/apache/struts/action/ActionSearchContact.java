package org.apache.struts.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.Contact;
import service.IContactService;

public class ActionSearchContact extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		SearchContactForm sf = (SearchContactForm) form;
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
		IContactService service = (service.IContactService) context.getBean("service");
		List<Contact> listResults = new ArrayList<Contact>(service.searchContacts(sf.getNom()));
//		sf.setListResults(listResults);
		request.setAttribute("listResults", listResults);
		
		return mapping.findForward("viewSearch");
	}
	
}
