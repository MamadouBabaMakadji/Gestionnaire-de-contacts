package model;

import java.util.List;

public class Contact {
	private long id;
	private String nom;
	private String prenom;
	private String mail;
	private int tel;
	private Adress adress;
	private List<PhoneNumber> listPhone;
	private List<GroupeContact> listGroup;

	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Contact(String nom, String prenom, String mail, String street, String city, String zip, String country,
			int phone) {
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.adress = new Adress(street, city, zip, country);
		this.tel = phone;
	}

	public Contact(String nom, String prenom, String mail, String street, String city, String zip, String country,
			int phone, List<GroupeContact> listGroup) {
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.adress = new Adress(street, city, zip, country);
		this.tel = phone;
		this.listGroup = listGroup;
	}

//	public Contact(int id, String nom, String prenom, String mail) {
//		super();
//		this.id = id;
//		this.nom = nom;
//		this.prenom = prenom;
//		this.mail = mail;
//	}

	public Contact(String nom, String prenom, String mail) {
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
	}

	// ************* Getters and Setters ************************

	public long getId() {
		return id;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return this.nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public Adress getAdress() {
		return adress;
	}

	public String getMail() {
		return this.mail;
	}

	public List<GroupeContact> getListGroup() {
		return listGroup;
	}

	public void setListGroup(List<GroupeContact> listGroup) {
		this.listGroup = listGroup;
	}

	public List<PhoneNumber> getListPhone() {
		return listPhone;
	}

	public void setListPhone(List<PhoneNumber> listPhone) {
		this.listPhone = listPhone;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	// *************************************************************

}
