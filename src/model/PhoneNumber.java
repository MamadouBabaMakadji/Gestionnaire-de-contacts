package model;

public class PhoneNumber {
	private int id;
	private String phoneKind;
	private String phoneNumber;
	private Contact contact;
	
	
	public int getId() {
		return id;
	}

	public String getPhoneKind() {
		return phoneKind;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public Contact getContact() {
		return contact;
	}
	
	public PhoneNumber(int id,String phoneNumber)  {
		this.id = id;
		this.phoneNumber = phoneNumber;
	}
	/*
	public PhoneNumber(int phoneNumber, String kindPhone) 
	{
		this.phoneKind = (kindPhone != null? kindPhone:null );
		this.phoneNumber = phoneNumber;
	}
	
	
	public PhoneNumber() {
		this(-1,null);
	}
	*/
	
	
	
	

}
