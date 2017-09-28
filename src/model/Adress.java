package model;

public class Adress {
	private long id;
	private String street;
	private String city;
	private String zip;
	private String country;

	public Adress(long id, String street, String city, String zip, String country) {
		super();
		this.id = id;
		this.street = street;
		this.city = city;
		this.zip = zip;
		this.country = country;
	}

	public Adress(String st, String cit, String zip, String count) {
		this.street = st;
		this.city = cit;
		this.zip = zip;
		this.country = count;
	}

	public Adress() {
	}

	public long getId() {
		return id;
	}

	public String getStreet() {
		return street;
	}

	public String getCity() {
		return city;
	}

	public String getZip() {
		return zip;
	}

	public String getCountry() {
		return country;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
