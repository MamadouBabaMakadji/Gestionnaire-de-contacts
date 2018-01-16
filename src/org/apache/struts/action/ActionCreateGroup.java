package org.apache.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.Group;
import service.IContactService;

public class ActionCreateGroup extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		CreateGroupForm ncf = (CreateGroupForm) form;
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
		IContactService IContactService = (service.IContactService) context.getBean("service");
		Group group = new Group(ncf.getNom());
		if (IContactService.insertDB(group))
			return mapping.findForward("ok");
		return mapping.findForward("no");
	}

}
