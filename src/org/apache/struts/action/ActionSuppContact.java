package org.apache.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.IContactService;

public class ActionSuppContact extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		SuppContactForm ncf = (SuppContactForm) form;
		long contact_ID = ncf.getIdentifiant();
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
		IContactService IContactService = (service.IContactService) context.getBean("service");
		if (IContactService.deleteContact(contact_ID))
			return mapping.findForward("SuppOK");
		return mapping.findForward("EchecSupp");
	}

}
