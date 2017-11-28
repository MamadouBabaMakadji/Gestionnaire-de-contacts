package org.apache.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ContactDAO;

public class ActionSuppContact extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		SuppContactForm ncf = (SuppContactForm) form;
		if (ncf.getNom() != null && ncf.getPrenom() != null && ncf.getMail().length() > 5) {
			long contact_ID = (long) ncf.getIdentifiant();
			ContactDAO cdao = new ContactDAO();
			if (cdao.deleteContact(contact_ID))
				return mapping.findForward("SuppOK");
			return mapping.findForward("EchecSupp");
		} else {
			return mapping.findForward("EchecSupp");
		}
	}

}
