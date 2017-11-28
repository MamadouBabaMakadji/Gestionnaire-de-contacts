package org.apache.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ContactDAO;
import model.Contact;

public class ActionSuppContact extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		SuppContactForm ncf = (SuppContactForm) form;
		if (ncf.getNom() != null && ncf.getPrenom() != null && ncf.getMail().length() > 5) {
			long contact_ID = (long) ncf.getIdentifiant();
			System.out.println("Je suis dans l'action ID = " + contact_ID);
			ContactDAO cdao = new ContactDAO();
			Contact contact = cdao.getContact(contact_ID);
			if (cdao.deleteContact(contact))
				return mapping.findForward("SuppOK");
			return mapping.findForward("EchecSupp");
		} else {
			return mapping.findForward("EchecSupp");
		}
	}

}
