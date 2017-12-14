package org.apache.struts.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class EditContactForm extends ActionForm {

	private static final long serialVersionUID = 1L;
	private long contactId;
	private int versionContact;
	private String nom;
	private String prenom;
	private String mail;
	private long adressId;
	private String adress;
	private String ville;
	private String code_postal;
	private String pays;
	private List<Long> phonesId = new ArrayList<>();
	private List<String> phonesNumber = new ArrayList<>();
	//private Long[] phonesId = new Long[20];
	//private String[] phonesNumber = new String[20];
	
	
	/*
	//private Long[] groupsId = new Long[20];
	//private Integer[] versionGroup = new Integer[20];
	private List<String> groupsName = new LinkedList<String>();
	private List<Long> groupsId = new LinkedList<Long>();
	private List<Integer> groupsVersion = new LinkedList<Integer>();
	*/
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	public void setContactId(long contactId) {
		this.contactId = contactId;
	}



	public void setPhonesId(List<Long> phonesId) {
		this.phonesId = phonesId;
	}



	public void setPhonesNumber(List<String> phonesNumber) {
		this.phonesNumber = phonesNumber;
	}



	public long getContactId() {
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

	public List<Long> getPhonesId() {
		return phonesId;
	}

	public void setPhonesId(Long phonesId) {
		System.out.println("PhoneId =" +phonesId);
		this.phonesId.add(phonesId);
	}
	

	public List<String> getPhonesNumber() {
		return phonesNumber;
	}

	public void setPhonesNumber(String phonesNumber) {
		System.out.println("PhoneNumber =" +phonesNumber);
		this.phonesNumber.add(phonesNumber);
	}
	
/*
	public List<String> getGroupsName() {
		return groupsName;
	}

	public void setGroupsName(List<String> groupsName) {
		this.groupsName = groupsName;
	}

	public List<Long> getGroupsId() {
		return groupsId;
	}

	public void setGroupsId(List<Long> groupsId) {
		this.groupsId = groupsId;
	}

	public List<Integer> getGroupsVersion() {
		return groupsVersion;
	}

	public void setGroupsVersion(List<Integer> groupsVersion) {
		this.groupsVersion = groupsVersion;
	}
*/
	
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		System.out.println("Passage EditActionForm");
		System.out.println("Version contact = " + versionContact);

		System.out.println("Size phonesId = " + phonesId.size());
		for (long id : phonesId) {
			System.out.println("Tel Id = " + id);
		}

		if (nom == null || nom.length() < 1) {
			errors.add("nom", new ActionMessage("erreur.nom"));
		}

		// if (prenom == null || prenom.length() < 1) {
		// errors.add("prenom", new ActionMessage("erreur.prenom"));
		// }

		if (!mail.matches("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)+$")) {
			errors.add("mail", new ActionMessage("erreur.mail"));
		}

		/*
		 * for (String tel : phonesNumber) { if (tel.length() != 10) {
		 * errors.add("tel", new ActionMessage("erreur.tel")); } }
		 */

		if (code_postal.length() != 5) {
			errors.add("code_postal", new ActionMessage("erreur.code_postal"));
		}

		return errors;
	}

}
