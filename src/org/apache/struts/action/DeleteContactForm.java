package org.apache.struts.action;

public class DeleteContactForm extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long contact_ID;

	public long getContact_ID() {
		return contact_ID;
	}

	public void setContact_ID(long contact_ID) {
		this.contact_ID = contact_ID;
	}
	
}
