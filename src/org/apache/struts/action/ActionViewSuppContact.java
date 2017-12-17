package org.apache.struts.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.Contact;
import service.IContactService;

public class ActionViewSuppContact extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ViewSuppContactForm view = (ViewSuppContactForm) form;
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
		IContactService service = (IContactService) context.getBean("service");
		List<Contact> listSuppContacts = new ArrayList<Contact>(service.getAllContacts());
		view.setListContacts(listSuppContacts);
		request.setAttribute("listSuppContacts", listSuppContacts);

		return mapping.findForward("viewSupp");
	}
	
	
}
