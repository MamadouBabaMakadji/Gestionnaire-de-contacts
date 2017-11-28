package org.apache.struts.action;

import javax.servlet.http.HttpServletRequest;

public class SuppContactForm extends ActionForm {

	private static final long serialVersionUID = 1L;
	private int identifiant;
	private String nom;
	private String prenom;
	private String mail;
	private String adress;
	private String ville;
	private String code_postal;
	private String pays;
	private String tel;
	private String tel2;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCode_postal() {
		return code_postal;
	}

	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getTel2() {
		return tel2;
	}

	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}

	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		// java.util.regex.Pattern p =
		// java.util.regex.Pattern.compile("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)+$");
		// Matcher verif_mail=p.matcher(mail);
		if (nom == null || nom.length() < 1) {
			errors.add("nom", new ActionMessage("erreur.nom"));
		}
		if (prenom == null || prenom.length() < 1) {
			errors.add("prenom", new ActionMessage("erreur.prenom"));
		}
		if (mail.length() < 5) {
			errors.add("mail", new ActionMessage("erreur.mail"));
		}
		if (tel.length() < 10) {
			errors.add("tel", new ActionMessage("erreur.tel"));
		}
		if (code_postal.length() != 5) {
			errors.add("code_postal", new ActionMessage("erreur.code_postal"));
		}

		return errors;
	}
}
