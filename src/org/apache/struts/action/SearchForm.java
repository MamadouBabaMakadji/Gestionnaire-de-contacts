package org.apache.struts.action;

import javax.servlet.http.HttpServletRequest;

public class SearchForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nom;

	
	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) 
	{	
		ActionErrors errors = new ActionErrors();
		if(nom == null || nom.length()<1)
		{
			errors .add("nom", new ActionMessage("erreur.search.nom"));
		}
		return errors;
	}

}