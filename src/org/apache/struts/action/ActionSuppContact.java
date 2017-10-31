package org.apache.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Adress;
import model.Contact;
import model.PhoneNumber;
import service.ContactService;

public class ActionSuppContact extends Action{
//	@Override
//	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
//			HttpServletResponse response) throws Exception {
//		SuppContactForm ncf = (SuppContactForm) form;
//		if(ncf.getNom() !=null && ncf.getPrenom()!=null && ncf.getMail().length()>5){
//			Contact c = new Contact(ncf.getNom(),ncf.getPrenom(),ncf.getMail());
//			Adress a = new Adress(ncf.getIdentifiant(),ncf.getAdress(),ncf.getVille(),ncf.getCode_postal(),ncf.getPays());
//			PhoneNumber p= new PhoneNumber(ncf.getIdentifiant(),ncf.getTel());
//			c.setId(ncf.getIdentifiant());
//			ContactService cs = new ContactService();
//			cs.deleteContact(c,a,p);
//			return mapping.findForward("SuppOK");
//		}else{
//			return mapping.findForward("EchecSupp");
//		}
//	}

}
