package org.apache.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ContactService;

public class ActionGroupContact extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		GroupContactForm ncf = (GroupContactForm) form;
		if(ncf.getNom().length() > 3 ){
			ContactService cs = new ContactService();
			cs.createGroupContact(ncf.getNom());
			return mapping.findForward("ok");
		}else{
			return mapping.findForward("no");
		}
	}

}
