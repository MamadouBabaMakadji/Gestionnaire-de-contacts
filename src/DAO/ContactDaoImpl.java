package DAO;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import model.Contact;
import model.Group;
import model.PhoneNumber;
import util.HibernateUtil;

public class ContactDaoImpl extends HibernateDaoSupport implements IContactDao {

	// TODO getAllContacts
	// ****************************** Create ********************************
	/**
	 * Insert an object in database
	 * 
	 * @param object
	 * @return a boolean if instructions have finished without errors
	 * @throws HibernateException
	 */
	@Transactional
	public boolean insertDB(Object object) throws Exception {
		boolean result = false;
		if (object == null)
			return result;
		else {
			try {
				getHibernateTemplate().save(object);
				
				result = true;
			} catch (HibernateException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * Insert objects in database
	 * 
	 * @param object
	 * @return a boolean if instructions have finished without errors
	 * @throws HibernateException
	 */
	
	@Transactional(readOnly = false)
	public boolean insertDBObjects(List<Object> objects) throws Exception {
		boolean result = false;
		if (objects == null)
			return result;
		else {
			try {
				HibernateTemplate ht = getHibernateTemplate();
				for (Object o : objects) {
					try {
						ht.saveOrUpdate(o);
					} catch (DataAccessException e) {
						e.printStackTrace();
					}
				}
				result = true;
			} catch (HibernateException e) {
				e.printStackTrace();
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> executerRequete(String requete) throws SQLException {

		List<Object[]> result = (List<Object[]>) getHibernateTemplate().find(requete).listIterator();
		return result;
	}

	// ****************************** Read ********************************
	/**
	 * 
	 * @param contact_ID
	 * @return an object Contact
	 */
	public Contact getContact(long contact_ID) {
		Contact contact = null;
		try {
			contact = getHibernateTemplate().get(Contact.class, contact_ID);
			return contact;
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return contact;
	}

	public Contact getContactHQL(long contactId) {
		Contact contact = null;
		try {
			// Build query
			StringBuilder sb = new StringBuilder();
			sb.append("select c from Contact as c left join  fetch c.groups as g");

			@SuppressWarnings("unchecked")
			List<Contact> list = (List<Contact>) getHibernateTemplate().find(sb.toString());
			contact = list.get(1);
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return contact;
	}

	/**
	 * 
	 * @return
	 */
	@Override
	@SuppressWarnings({ "unchecked" })
	public Set<Contact> getAllContacts() {
		Set<Contact> contacts = new HashSet<Contact>();
		try {
			Iterator<Contact> listContacts = (Iterator<Contact>) getHibernateTemplate().find("from Contact").iterator();
			while (listContacts.hasNext()) {
				Contact contact = listContacts.next();
				Contact c = new Contact(contact);
				//c.setContact_ID(contact.getContact_ID());
				contacts.add(c);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return contacts;
	}

	/**
	 * 
	 * @return
	 */
	@Override
	@SuppressWarnings({ "unchecked" })
	public Set<Contact> getAllContactsWGroups() {
		Set<Contact> contacts = new HashSet<Contact>();
		try {
			Iterator<Contact> listContacts = (Iterator<Contact>) getHibernateTemplate()
					.find("from Contact as c join c.groups").iterator();
			while (listContacts.hasNext()) {
				Contact contact = listContacts.next();
				Contact c = new Contact(contact);
				c.setContact_ID(contact.getContact_ID());
				contacts.add(c);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return contacts;
	}

	
	/**
	 * Get a set of all groups
	 * 
	 * @return an hashset of all groups
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Set<Group> getAllGroups() {
		Set<Group> groups = new HashSet<Group>();
		try {
			DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Group.class);
			Iterator<Group> iteratorGroups = ((Iterator<Group>) getHibernateTemplate().findByCriteria(detachedCriteria)
					.listIterator());
			while (iteratorGroups.hasNext()) {
				Group group = iteratorGroups.next();
				Group g = new Group(group);
				groups.add(g);
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return groups;
	}

	// TODO: redo the method with Spring
	/**
	 * Get all contacts with lazy
	 */
	@Override
	public Set<Contact> getAllContactsLazy() {
		Set<Contact> contacts = new HashSet<Contact>();
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();

			// Build query
			StringBuilder sb = new StringBuilder();
			sb.append("from Contact");

			// Execute query
			Query query = session.createQuery(sb.toString());

			@SuppressWarnings("unchecked")
			List<Contact> list = (List<Contact>) query.list();
			for (Contact contact : list) {
				Contact c = new Contact(contact.getNom(), contact.getPrenom(), contact.getMail());
				c.setContact_ID(contact.getContact_ID());
				contacts.add(c);
			}

			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return contacts;
	}

	/**
	 * Get a group by an id
	 * 
	 * @param groupId
	 *            : long
	 * @return an object Group
	 */
	public Group getGroup(long groupId) {
		Group group = null;
		try {
			DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Group.class)
					.add(Restrictions.like("group_ID", groupId));
			@SuppressWarnings("unchecked")
			Iterator<Group> iteratorGroup = (Iterator<Group>) getHibernateTemplate().findByCriteria(detachedCriteria)
					.iterator();
			group = iteratorGroup.next();
			return group;
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return group;
	}

	public Set<Contact> getContactsByGroupId(long groupId) {
		Set<Contact> contacts = new HashSet<Contact>();
		try {
			// Build query
			StringBuilder sb = new StringBuilder();
			sb.append("select c from Contact as c join c.groups as g where g.group_ID = ?");

			@SuppressWarnings("unchecked")
			Iterator<Contact> iteratorContacts = (Iterator<Contact>) getHibernateTemplate().find(sb.toString(), groupId)
					.iterator();
			while (iteratorContacts.hasNext()) {
				Contact contact = iteratorContacts.next();
				Contact c = new Contact(contact);
				contacts.add(c);
			}
			contacts = new HashSet<>(contacts);
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return contacts;
	}

	/**
	 * Seach a Contact by : firstname, lastname, country, group name
	 * 
	 * @param keywords
	 * @return contacts : a set of Contact
	 */
	public Set<Contact> searchContacts(String search) {
		Set<Contact> contacts = null;
		try {
			String request = "from Contact where nom = ? or prenom = ?";
			Object[] paramNames = { search, search };
			// Execute query
			@SuppressWarnings("unchecked")
			List<Contact> list = (List<Contact>) getHibernateTemplate().find(request, paramNames);
			contacts = new HashSet<>(list);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return contacts;
	}

	
	// ****************************** Update ********************************

	/**
	 * Save and update an object
	 * 
	 * @param contact
	 * @return
	 */
	public boolean saveUpdate(Contact contact) {
		boolean result = false;
		try {
			getHibernateTemplate().merge(contact);
			for (PhoneNumber pn : contact.getPhones()) {
				getHibernateTemplate().merge(pn);
			}

			result = true;
		} catch (HibernateException e) {
			e.printStackTrace();
			e.getMessage();
		}
		return result;
	}

	@Override
	@Transactional
	public boolean update(Contact contact) {
		boolean result = false;
		try {
			getHibernateTemplate().update(contact);
			for (PhoneNumber pn : contact.getPhones()) {
				getHibernateTemplate().saveOrUpdate(pn);
			}
			result = true;
		} catch (HibernateException e) {
			e.printStackTrace();
			e.getMessage();
		}
		return result;
	}

	/**
	 * Save and update a group
	 * 
	 * @param contact
	 * @return
	 */
	@Override
	@Transactional
	public boolean update(Group group) {
		boolean result = false;
		try {
			HibernateTemplate ht = getHibernateTemplate();
			ht.update(group);
			result = true;
		} catch (HibernateException e) {
			e.printStackTrace();
			e.getMessage();
		}
		return result;
	}

	
	
	// ****************************** Delete ********************************
	@Transactional(readOnly = false)
	public boolean deleteContact(long contact_ID) {
		boolean result = false;
		try {
			HibernateTemplate ht = getHibernateTemplate();
			Contact contact = ht.get(Contact.class, contact_ID);
			System.out.println(contact.toString());
			for (Group group : contact.getGroups()) {
				group.getContacts().remove(contact);
			}
			try {
				contact.setGroups(null);
				ht.delete(contact);
			} catch (DataAccessException e) {
				e.printStackTrace();
			}
			result = true;
		} catch (HibernateException e) {
			e.getMessage();
			e.printStackTrace();
			result = false;
		} catch (Exception e) {
			e.getMessage();
			result = false;
		}
		return result;
	}

	/**
	 * Method to delete a group
	 * 
	 * @param group_ID
	 * @return true if the group was deleted ; otherwise false
	 */
	@Transactional(readOnly = false)
	public boolean deleteGroup(long group_ID) {
		boolean result = false;
		try {
			HibernateTemplate ht = getHibernateTemplate();
			Group group = ht.get(Group.class, group_ID);
			for (Contact contact : group.getContacts()) {
				contact.getGroups().remove(group);
				ht.update(contact);
			}
			ht.delete(group);
			result = true;
		} catch (HibernateException e) {
			e.getMessage();
			e.printStackTrace();
			result = false;
		} catch (Exception e) {
			e.getMessage();
			result = false;
		}
		return result;
	}
	
	/**
	 * Method to delete phone number
	 * 
	 * @param phone
	 * @return true if the phone was deleted ; otherwise false
	 */
	@Override
	@Transactional(readOnly = false)
	public boolean deletePhone(long phoneId, long contactId) {
		boolean result = false;
		try {
			HibernateTemplate ht = getHibernateTemplate();
			Contact contact = ht.get(Contact.class, contactId);
			PhoneNumber phone = ht.get(PhoneNumber.class, phoneId);
			System.out.println(phone.toString());
			phone.setContact(null);
			contact.getPhones().remove(phone);
			/*ht.update(contact);*/
			ht.delete(phone);
			result = true;
		} catch (HibernateException e) {
			e.getMessage();
			e.printStackTrace();
			result = false;
		} catch (Exception e) {
			e.getMessage();
			result = false;
		}
		return result;
	}


	@SuppressWarnings("unchecked")
	public long getNbContact(){
		long nb = 0;
		String hql = "select count (contact_ID) from Contact";
		List<Long> result = (List<Long>) getHibernateTemplate().find(hql);
		nb = result.get(0);
		
		return nb;
	}
	
	@SuppressWarnings("unchecked")
	public long getNbGroup(){
		long nb = 0;
		String hql = "select count (group_ID) from Group";
		List<Long> result = (List<Long>) getHibernateTemplate().find(hql);
		nb = result.get(0);
		
		return nb;
	}
	
	@SuppressWarnings("unchecked")
	public Set<Contact> getLastContacts(){
		HibernateTemplate ht = getHibernateTemplate();
		ht.setFetchSize(10);
//		ht.setMaxResults(0);
		String hql = "from Contact ORDER BY contact_ID desc"; //order by contact_ID DESC LIMIT 10";
		List<Contact> list = (List<Contact>) ht.find(hql);
		Set<Contact> contacts = new HashSet<>(list);
		
		return contacts;
	}
	
	public boolean updateGroupName(long id, String newName){
		boolean result = false;
		Group group = null;
		try {
			group = getGroup(id);
			group.setGroupName(newName);
			getHibernateTemplate().update(group);
			result = true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return result;
	}
	
}


