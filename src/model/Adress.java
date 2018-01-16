package model;

public class Adress {
	private long adress_ID;
	private String street;
	private String city;
	private String zip;
	private String country;
	private Contact contact;

	public Adress() {
	}

	public Adress(long id, String street, String city, String zip, String country) {
		this(street, city, zip, country);
		this.adress_ID = id;
	}
	

	public Adress(long adress_ID, String street, String city, String zip, String country, Contact contact) {
		this.adress_ID = adress_ID;
		this.street = street;
		this.city = city;
		this.zip = zip;
		this.country = country;
		this.contact = contact;
	}

	public Adress(String street, String city, String zip, String country) {
		this.street = street;
		this.city = city;
		this.zip = zip;
		this.country = country;
	}

	public long getAdress_ID() {
		return adress_ID;
	}

	public void setAdress_ID(long adress_ID) {
		this.adress_ID = adress_ID;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

}
