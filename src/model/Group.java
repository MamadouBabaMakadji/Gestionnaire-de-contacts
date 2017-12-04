package model;

import java.util.HashSet;
import java.util.Set;

public class Group {
	private long group_ID;
	private String groupName;
	private Set<Contact> contacts = new HashSet<Contact>();
	private int version;

	public Group() {
	}

	public Group(String groupName) {
		this.groupName = groupName;
	}
	
	

	public Group(long group_ID, int version) {
		super();
		this.group_ID = group_ID;
		this.version = version;
	}

	public Group(long group_ID, String groupName, int version) {
		this.group_ID = group_ID;
		this.groupName = groupName;
		this.version = version;
	}

	public long getGroup_ID() {
		return group_ID;
	}

	public void setGroup_ID(long group_ID) {
		this.group_ID = group_ID;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Set<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((groupName == null) ? 0 : groupName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Group other = (Group) obj;
		if (groupName == null) {
			if (other.groupName != null)
				return false;
		} else if (!groupName.equals(other.groupName))
			return false;
		return true;
	}

	
	
	@Override
	public String toString() {
		return "Group { groupID = "+this.group_ID+", groupName=" + this.groupName + ", version = " + this.version+ "}";
	}
	
	

}
