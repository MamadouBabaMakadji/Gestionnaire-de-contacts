package org.apache.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.Group;
import service.IContactService;

public class ActionViewGroup extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ViewForm view = (ViewForm) form;
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
		IContactService service = (IContactService) context.getBean("service");
		
		long groupId = (long)request.getAttribute("groupId");
		Group group = service.getGroup(groupId);
		
		view.setGroup(group);
		request.setAttribute("group", group);

		return mapping.findForward("view");
	}
}
