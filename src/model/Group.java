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
		result = prime * result + (int) (group_ID ^ (group_ID >>> 32));
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
		if (group_ID != other.group_ID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Group {groupName=" + groupName + "}";
	}
	
	

}
