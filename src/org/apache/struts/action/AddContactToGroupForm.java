package org.apache.struts.action;

public class AddContactToGroupForm extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long contact_ID;
	private long group_ID;
	
	public long getContact_ID() {
		return contact_ID;
	}
	public void setContact_ID(long contact_ID) {
		this.contact_ID = contact_ID;
	}
	public long getGroup_ID() {
		return group_ID;
	}
	public void setGroup_ID(long group_ID) {
		this.group_ID = group_ID;
	}
	
}
