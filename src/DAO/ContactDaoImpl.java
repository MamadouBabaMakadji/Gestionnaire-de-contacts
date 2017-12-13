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
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
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
	public boolean insertDBObjects(List<Object> objects) throws Exception {
		boolean result = false;
		if (objects == null)
			return result;
		else {
			try {
				for (Object o : objects) {
					getHibernateTemplate().save(o);
				}
				result = true;
			} catch (HibernateException e) {
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
		System.out.println("JE suis bien dedans");
		try {
			DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Contact.class)
					.add(Restrictions.like("contact_ID", contact_ID));
			// Session session =
			// HibernateUtil.getSessionFactory().openSession();
			// contact = new Contact((Contact)
			// session.createCriteria(Contact.class)
			// .add(Restrictions.like("contact_ID",
			// contact_ID)).uniqueResult());
			// session.close();
			contact = (Contact) getHibernateTemplate().findByCriteria(detachedCriteria);
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return contact;
	}

	public Contact getContactHQL(long contactId) {
		Contact contact = null;
		try {
			// Session session =
			// HibernateUtil.getSessionFactory().openSession();

			// Build query
			StringBuilder sb = new StringBuilder();
			sb.append("select c from Contact as c left join  fetch c.groups as g");

			// Execute query

			// Query query = session.createQuery(sb.toString());

			@SuppressWarnings("unchecked")
			List<Contact> list = (List<Contact>) getHibernateTemplate().find(sb.toString()).iterator();
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
	 * Get a set of all groups
	 * 
	 * @return an hashset of all groups
	 */
	@SuppressWarnings("unchecked")
	public Set<Group> getAllGroups() {
		List<Group> listGroups = null;
		try {
			DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Group.class);
			// Session session =
			// HibernateUtil.getSessionFactory().openSession();
			// listGroups = session.createCriteria(Group.class).list();
			listGroups = (List<Group>) getHibernateTemplate().findByCriteria(detachedCriteria).listIterator();
			// session.close();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new HashSet<Group>(listGroups);
	}
	
	
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
			group = (Group) getHibernateTemplate().findByCriteria(detachedCriteria).iterator();
			return group;
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return group;
	}

	public Set<Contact> getContactsByGroupId(long groupId) {
		Set<Contact> contacts = null;
		try {
			// Session session =
			// HibernateUtil.getSessionFactory().openSession();

			// Build query
			StringBuilder sb = new StringBuilder();
			sb.append("select c from Contact as c join c.groups as g where g.group_ID = :groupId");

			// Execute query
			// Query query = session.createQuery(sb.toString());
			// query.setParameter("groupId", groupId);
			@SuppressWarnings("unchecked")
			List<Contact> list = (List<Contact>) getHibernateTemplate().find(sb.toString()).iterator();
			contacts = new HashSet<>(list);
			// session.close();
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
			String[] words = search.split(" ");
			List<String> setKeyWords = new ArrayList<String>(Arrays.asList(words));
			// Session session =
			// HibernateUtil.getSessionFactory().openSession();

			// Build query
			StringBuilder sb = new StringBuilder();
			sb.append(
					"select c from Contact as c join c.groups as g where c.nom in (:keyWords) or c.prenom in (:keyWords) or c.adress.country in (:keyWords)");
			sb.append(" or g.groupName in (:keyWords)");

			// Execute query
			@SuppressWarnings("unchecked")
			List<Contact> list = (List<Contact>) getHibernateTemplate().find(sb.toString(), setKeyWords).iterator();
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
			// Session session =
			// HibernateUtil.getSessionFactory().openSession();
			// session.beginTransaction();
			getHibernateTemplate().merge(contact);
			for (PhoneNumber pn : contact.getPhones()) {
				getHibernateTemplate().merge(pn);
			}
			// session.getTransaction().commit();
			// session.close();

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
	public boolean update(Group group) {
		boolean result = false;
		try {
			getHibernateTemplate().update(group);
			result = true;
		} catch (HibernateException e) {
			e.printStackTrace();
			e.getMessage();
		}
		return result;
	}
	
	

	// ****************************** Delete ********************************

	public boolean deleteContact(long contact_ID) {
		boolean result = false;
		try {
			// Session session =
			// HibernateUtil.getSessionFactory().openSession();
			// session.beginTransaction();
			Contact contact = (Contact) getHibernateTemplate().load(Contact.class, contact_ID);
			getHibernateTemplate().delete(contact);
			// session.getTransaction().commit();
			result = true;
			// session.close();
		} catch (HibernateException e) {
			e.getMessage();
			e.printStackTrace();
			result = false;
		} catch (Exception e) {
			e.getMessage();
			result = false;
		}

		System.out.println("Result = " + result);
		return result;
	}

	/**
	 * Method to delete a group
	 * 
	 * @param group_ID
	 * @return true if the group was deleted ; otherwise false
	 */
	public boolean deleteGroup(long group_ID) {
		boolean result = false;
		try {
			Group group = (Group) getHibernateTemplate().load(Group.class, group_ID);
			getHibernateTemplate().delete(group);
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
