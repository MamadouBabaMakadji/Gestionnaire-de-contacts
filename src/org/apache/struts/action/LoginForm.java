package org.apache.struts.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class LoginForm extends ActionForm{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nom;
	private String password;
	public String getNom(){
		return this.nom;
	}
	public String getPassword(){
		return this.password;
	}
	public void setNom(String name){
		this.nom=name;
	}
	public void setPassword(String mdp){
		this.password= mdp; // mdp = Mot de passe 
	}
	
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request){
		ActionErrors errors = new ActionErrors();
		if(nom == null || nom.length()<1){
			errors .add("nom", new ActionMessage("erreur.nom.utilisateur"));
		}
		if(password == null || password.length()<1){
			errors.add("password", new ActionMessage("erreur.password.utilisateur"));
		}
		if(!nom.equals(password)){
			errors.add("NotEquals", new ActionMessage("erreur.passwordNotEqualsName"));
		}
		return errors;
	}
}
