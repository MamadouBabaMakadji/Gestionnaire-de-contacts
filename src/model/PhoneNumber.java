package model;

public class PhoneNumber {
	private long id;
	private String phoneKind;
	private String phoneNumber;
	private Contact contact;

	public PhoneNumber(long id, String phoneKind, String phoneNumber) {
		super();
		this.id = id;
		this.phoneKind = phoneKind;
		this.phoneNumber = phoneNumber;
	}
	public PhoneNumber() {
	}
	

	public PhoneNumber(long id, String phoneNumber) {
		super();
		this.id = id;
		this.phoneNumber = phoneNumber;
	}
	public PhoneNumber(String phoneKind, String phoneNumber) {
		super();
		this.phoneKind = phoneKind;
		this.phoneNumber = phoneNumber;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setPhoneKind(String phoneKind) {
		this.phoneKind = phoneKind;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public long getId() {
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

}
