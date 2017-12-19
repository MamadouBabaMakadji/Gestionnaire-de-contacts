package org.apache.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.IContactService;

public class ActionEditGroup extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		EditGroupForm sf = (EditGroupForm) form;
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
		IContactService service = (service.IContactService) context.getBean("service");
		if(service.updateGroupName(sf.getGroupID(), sf.getGroupName()))
			return mapping.findForward("editGroupOK");
		return mapping.findForward("editGroupNo");
	}
}
