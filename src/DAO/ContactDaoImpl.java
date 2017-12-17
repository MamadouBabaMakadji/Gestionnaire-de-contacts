package DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
					ht.save(o);
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
	@Transactional
	public Contact getContact(long contact_ID) {
		Contact contact = null;
		try {
			DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Contact.class)
					.add(Restrictions.like("contact_ID", contact_ID));
			@SuppressWarnings("unchecked")
			List<Contact> list = (List<Contact>) getHibernateTemplate().findByCriteria(detachedCriteria);
			contact = list.get(0);
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
	public List<Contact> getAllContacts() {
		ArrayList<Contact> contacts = new ArrayList<Contact>();
		try {
			Iterator<Contact> listContacts = (Iterator<Contact>) getHibernateTemplate().find("from Contact").iterator();
			while (listContacts
					.hasNext()) /* (Contact contact : listContacts) */ {
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
			String pattern = " ";
			String[] wordsSearch = search.split(pattern);
			String[] paramNames = { "c.nom", "c.prenom", "c.adress.country", "g.groupName" };
			System.out.println("Length wordsSearch " + wordsSearch.length);

			// Build query
			StringBuilder sb = new StringBuilder();
			sb.append(
					"select c from Contact as c join c.groups as g where c.nom = :c.nom or c.prenom = :c.prenom or c.adress.country = :c.adress.country");
			sb.append(" or g.groupName = :g.groupName");

			/*
			 * List<String> params = new ArrayList<>(); List<String> words = new
			 * ArrayList<>(); for (int p = 0; p<paramNames.length; p++) { for
			 * (int w = 0; w<wordsSearch.length; w++) {
			 * params.add(paramNames[p]); words.add(wordsSearch[w]); } }
			 */

			List<String> listKey = Arrays.asList(wordsSearch);
			Object[] keyWords = new Object[paramNames.length];
			for (int i = 0; i < paramNames.length; i++) {
				keyWords[i] = listKey;
			}

			/*
			 * for (int i =0; i<keyWords.length; i++) { for (int j =0;
			 * j<keyWords[i].length; j++) { System.out.println(); } }
			 */

			/*
			 * String[] parameters = params.toArray(paramNames); //Object[]
			 * keyWords = words.toArray();
			 * 
			 * System.out.println("Size params " + params.size());
			 * System.out.println("Length paramaters " + parameters.length);
			 * System.out.println("Size words " + words.size());
			 * System.out.println("Length words " + parameters.length);
			 */

			// Execute query
			@SuppressWarnings("unchecked")
			List<Contact> list = (List<Contact>) getHibernateTemplate()
					.findByNamedParam(sb.toString(), paramNames, keyWords).iterator();
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
			ht.setCheckWriteOperations(false);
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

}


