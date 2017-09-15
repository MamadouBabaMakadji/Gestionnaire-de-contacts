package org.apache.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionLogin extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
									HttpServletResponse response) throws Exception 
	{
		
		LoginForm f = (LoginForm) form;
		if(!f.getNom().equals(f.getPassword()) || f.getNom().length()<1 || f.getPassword().length()<1){
			return mapping.findForward("echec");
		}else{
			return mapping.findForward("succes");
		}
		
		
	}

}
