package org.apache.struts.action;

import javax.servlet.http.HttpServletRequest;

public class CreateGroupForm extends ActionForm{

	private static final long serialVersionUID = 1L;
	private String nom;
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		//java.util.regex.Pattern p = java.util.regex.Pattern.compile("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)+$");
		//Matcher verif_mail=p.matcher(mail);
		if( nom.length()<1){
			errors .add("nom", new ActionMessage("erreur.nom"));
		}
		return errors;
	}

}
