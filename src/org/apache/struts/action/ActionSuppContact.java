package org.apache.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import DAO.IContactDao;
import service.IContactService;

public class ActionSuppContact extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		SuppContactForm ncf = (SuppContactForm) form;
		long contact_ID = ncf.getIdentifiant();
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
		IContactDao dao = (DAO.IContactDao) context.getBean("dao");
		if (dao.deleteContact(contact_ID))
			return mapping.findForward("SuppOK");
		return mapping.findForward("EchecSupp");
	}

}
