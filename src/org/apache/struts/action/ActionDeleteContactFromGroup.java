package org.apache.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import DAO.IContactDao;
import model.Contact;
import model.Group;
import service.IContactService;

public class ActionDeleteContactFromGroup extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		DeleteContactFromGroupForm ncf = (DeleteContactFromGroupForm) form;
		long contactId = ncf.getContact_ID();
		long groupId = ncf.getGroup_ID();
		System.out.println("contactId = " +contactId);
		System.out.println("groupId = " +groupId);
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
		/*IContactService IContactService = (service.IContactService) context.getBean("service");*/
		IContactDao dao = (DAO.IContactDao) context.getBean("dao");
		Contact contact = dao.getContact(contactId);
		Group group = dao.getGroup(groupId);
		contact.getGroups().remove(group);
		if (dao.update(contact))
			return mapping.findForward("view");
		return mapping.findForward("EchecDeleteGroup");
	}

}
