package org.apache.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ContactService;

public class ActionSearch extends Action 
{
/*	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		SearchForm sf = (SearchForm) form;
		ContactService cs = new ContactService();

		if (!cs.searchContact(sf.getNom()).isEmpty()) {
			request.setAttribute("listContact", cs.searchContact(sf.getNom()));
			return mapping.findForward("ResultSearch");
		}

		else
			return mapping.findForward("Main");

	}*/
}