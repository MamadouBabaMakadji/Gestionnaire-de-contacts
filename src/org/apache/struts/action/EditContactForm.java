package org.apache.struts.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class EditContactForm extends ActionForm {

	private static final long serialVersionUID = 1L;
	private int contactId;
	private int versionContact;
	private String nom;
	private String prenom;
	private String mail;
	private long adressId;
	private String adress;
	private String ville;
	private String code_postal;
	private String pays;
	
	private Long[] phonesId = new Long[20];
	private String[] phonesNumber = new String[20];
	
	private Long[] groupsId = new Long[20];
	private String[] groupsName = new String[20];
	private Integer[] versionGroup = new Integer[20];

	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getContactId() {
		return contactId;
	}

	public void setContactId(int identifiant) {
		this.contactId = identifiant;
	}
	
	public int getVersionContact() {
		return versionContact;
	}
	
	public void setVersionContact(int version) {
		this.versionContact = version;
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

	public long getAdressId() {
		return adressId;
	}

	public void setAdressId(long adressId) {
		this.adressId = adressId;
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

	public Long[] getPhonesId() {
		return phonesId;
	}

	public void setPhonesId(Long[] phonesId) {
		this.phonesId = phonesId;
	}

	public String[] getPhonesNumber() {
		return phonesNumber;
	}

	public void setPhonesNumber(String[] phonesNumber) {
		this.phonesNumber = phonesNumber;
	}

	public Long[] getGroupsId() {
		return groupsId;
	}

	public void setGroupsId(Long[] groupsId) {
		this.groupsId = groupsId;
	}

	public String[] getGroupsName() {
		return groupsName;
	}

	public void setGroupsName(String[] groupsName) {
		this.groupsName = groupsName;
	}
	
	public Integer[] getVersionGroup() {
		return versionGroup;
	}

	public void setVersionGroup(Integer[] versionGroup) {
		this.versionGroup = versionGroup;
	}

	
	
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();

		if (nom == null || nom.length() < 1) {
			errors.add("nom", new ActionMessage("erreur.nom"));
		}
		if (prenom == null || prenom.length() < 1) {
			errors.add("prenom", new ActionMessage("erreur.prenom"));
		}

		if (!mail.matches("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)+$")) {
			errors.add("mail", new ActionMessage("erreur.mail"));
		}
		
		for (String tel : phonesNumber) {
			if (tel.length() != 10) {
				errors.add("tel", new ActionMessage("erreur.tel"));
			}
		}
		
		if (code_postal.length() != 5) {
			errors.add("code_postal", new ActionMessage("erreur.code_postal"));
		}

		return errors;
	}

}
