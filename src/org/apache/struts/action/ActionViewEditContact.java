package org.apache.struts.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import DAO.IContactDao;
import model.Contact;
import service.IContactService;

public class ActionViewEditContact extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ViewEditContactForm view = (ViewEditContactForm) form;
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
		/*IContactService service = (IContactService) context.getBean("service");*/
		IContactDao dao = (DAO.IContactDao) context.getBean("dao");
		List<Contact> listEditContacts = new ArrayList<Contact>(dao.getAllContacts());
		view.setListEditContacts(listEditContacts);
		request.setAttribute("listEditContacts", listEditContacts);

		return mapping.findForward("viewEdit");
	}

}
