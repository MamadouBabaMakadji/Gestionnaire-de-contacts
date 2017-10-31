package model;

public class PhoneNumber {
	private long phone_ID;
	private String phoneNumber;
	private Contact contact;

	public PhoneNumber() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PhoneNumber(String phoneNumber) {
		super();
		this.phoneNumber = phoneNumber;
	}

	public long getPhone_ID() {
		return phone_ID;
	}

	public void setPhone_ID(long phone_ID) {
		this.phone_ID = phone_ID;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

}
