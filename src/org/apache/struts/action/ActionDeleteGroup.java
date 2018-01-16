package org.apache.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.IContactService;

public class ActionDeleteGroup extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		DeleteGroupForm ncf = (DeleteGroupForm) form;
		long group_ID = ncf.getGroup_ID();
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
		IContactService IContactService = (service.IContactService) context.getBean("service");
		if (IContactService.deleteGroup(group_ID))
			return mapping.findForward("listGroupView");
		return mapping.findForward("EchecDeleteGroup");
	}

}
