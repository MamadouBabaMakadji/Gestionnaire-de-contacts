package model;

public class Adress {
	private int id;
	private String street;
	private String city;
	private String zip;
	private String country;
	

	public Adress(int id, String st, String cit, String zip, String count) {
		this.id = id;//requete dans ActionNewContact()
		this.street = st;
		this.city = cit;
		this.zip = zip;
		this.country = count;
	}
	
			
			public Adress(String st, String cit, String zip, String count) {
		 		this.street = st;
		 		this.city = cit;
		 		this.zip = zip;
		 		this.country = count;
		 	}
	
	public Adress() {
		this(null, null, null, null);
	}

	public int getId() {
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
	
	

}
