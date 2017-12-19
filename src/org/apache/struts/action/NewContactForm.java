package org.apache.struts.action;


import javax.servlet.http.HttpServletRequest;


public class NewContactForm extends ActionForm {

	private static final long serialVersionUID = 1L;

	private String nom;
	private String prenom;
	private String mail;
	private String tel;
	private String ville;
	private String code_postal;
	private String pays;
	private String adresse;
	private String group;
	private String tel2;
	private String siretEtp;
	private String typeContact;

	public String getTypeContact() {
		return typeContact;
	}

	public void setTypeContact(String typeContact) {
		this.typeContact = typeContact;
	}

	public String getSiretEtp() {
		return siretEtp;
	}

	public void setSiretEtp(String siretEtp) {
		this.siretEtp = siretEtp;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
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

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
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

	public String getTel2() {
		return tel2;
	}

	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}

	public boolean isCorrectNum(String num) {
		boolean result = false;
		try {
			long longFormat = Long.parseLong(num);
			if (longFormat < 100000000) {
				result = false;
			} else {
				result = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	public boolean isCorrectZip(String zip) {
		boolean result = false;
		try {
			long longFormat = Long.parseLong(zip);
			if (longFormat < 9999) {
				result = false;
			} else {
				result = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		if (nom == null || nom.length() < 1) {
			errors.add("nom", new ActionMessage("erreur.nom"));
		}
		if ("Personne".equals(typeContact) && prenom.length() < 1) {
			errors.add("prenom", new ActionMessage("erreur.prenom"));
		}

		if ("Entreprise".equals(typeContact) && siretEtp.length() < 5) {
			errors.add("siret", new ActionMessage("erreur.siret"));
		}

		if (!mail.matches("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)+$")) {
			errors.add("mail", new ActionMessage("erreur.mail"));
		}

		if (tel.length() != 10 || (!isCorrectNum(tel))) {
			errors.add("tel", new ActionMessage("erreur.tel"));
		}

		if ((!("".equals(tel2)) && tel2.length() != 10) || (!"".equals(tel2) && (!isCorrectNum(tel2)))) {
			errors.add("tel", new ActionMessage("erreur.tel"));
		}

		if (code_postal.length() != 5 || !isCorrectZip(code_postal)) {
			errors.add("code_postal", new ActionMessage("erreur.code_postal"));
		}
		return errors;
	}

}
