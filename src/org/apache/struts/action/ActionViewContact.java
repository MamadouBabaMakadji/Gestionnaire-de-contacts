package org.apache.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Contact;

public class ActionViewContact extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Contact contact = (Contact)request.getAttribute("contact");
		/*Contact contact = (Contact) request.getSession().getAttribute("contact");*/
		ViewForm view = (ViewForm) form;
		request.setAttribute("contact", contact);
		return mapping.findForward("view");
	}
}
