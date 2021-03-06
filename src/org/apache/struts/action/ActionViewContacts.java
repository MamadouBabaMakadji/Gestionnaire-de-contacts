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

public class ActionViewContacts extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ViewForm view = (ViewForm) form;
		
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
		/*IContactDao service = (IContactDao) context.getBean("dao");*/
		IContactDao dao = (DAO.IContactDao) context.getBean("dao");
		
		List<Contact> listContacts = new ArrayList<Contact>(dao.getAllContacts());
		view.setListContacts(listContacts);
		request.setAttribute("listContacts", listContacts);

		return mapping.findForward("view");
	}
}
