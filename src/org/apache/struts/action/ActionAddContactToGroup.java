package org.apache.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.Contact;
import model.Group;
import service.IContactService;

public class ActionAddContactToGroup extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		AddContactToGroupForm ncf = (AddContactToGroupForm) form;
		long contactId = ncf.getContact_ID();
		long groupId = ncf.getGroup_ID();
		System.out.println("contactId = " +contactId);
		System.out.println("groupId = " +groupId);
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
		IContactService IContactService = (service.IContactService) context.getBean("service");
		Contact contact = IContactService.getContact(contactId);
		Group group = IContactService.getGroup(groupId);
		contact.getGroups().add(group);
		if (IContactService.update(contact))
			return mapping.findForward("view");
		return mapping.findForward("EchecDeleteGroup");
	}

}
