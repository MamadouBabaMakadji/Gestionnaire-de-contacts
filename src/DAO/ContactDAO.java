package DAO;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import model.Contact;
import util.HibernateUtil;


public class ContactDAO {

	public ContactDAO() {
	}

	//****************************** Code to Create ********************************
	/**
	 * Insert an object in database
	 * 
	 * @param object
	 * @return a boolean if instructions have finished without errors
	 * @throws HibernateException
	 */
	public boolean insertDB(Object object) throws Exception {
		boolean result = false;
		if (object == null)
			return result;
		else {
			try {
				Session session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
				session.save(object);
				session.getTransaction().commit();
				session.close();
				result = true;
			} catch (HibernateException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> executerRequete(String requete) throws SQLException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		List<Object[]> result = session.createQuery(requete).list();
		session.getTransaction().commit();
		session.close();
		return result;
	}

	//****************************** Code to Create ********************************
	/**
	 * Get a contact with session.get()
	 * 
	 * @param contact_ID
	 * @return an object Contact
	 */
	public Contact getContact(long contact_ID) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Contact contact = (Contact) session.createCriteria(Contact.class)
				.add(Restrictions.like("contact_ID", contact_ID)).uniqueResult();
		session.close();
		return contact;
	}

	@SuppressWarnings("unchecked")
	public List<Contact> getAllContact() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Contact> results = session.createCriteria(Contact.class).setCacheable(true).list();
		return results;
	}

	/**
	 * Save and update an object
	 * 
	 * @param contact
	 * @return
	 */
	public boolean saveUpdate(Contact contact) {
		boolean result = false;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.merge(contact);
			session.getTransaction().commit();
			result = true;
			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
			e.getMessage();
		}
		return result;
	}

	public boolean deleteContact(Contact contact) {
		boolean result = false;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(contact);
			session.getTransaction().commit();
			result = true;
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return result;
	}

	
	//
	/**
	 * Seach a Contact by : firstname, lastname, city, country, group name
	 * 
	 * @param keywords
	 * @return contacts : a set of Contact
	 */
	public Set<Contact> getContacts(String search) {
		Set<Contact> contacts = null;
		try {
			String[] words = search.split(" ");
			List<String> setKeyWords = new ArrayList<String>(Arrays.asList(words));
			Session session = HibernateUtil.getSessionFactory().openSession();

			// Build query
			StringBuilder sb = new StringBuilder();
			sb.append(
					"select c from Contact as c join c.groups as g where c.nom in (:keyWords) or c.prenom in (:keyWords) or c.adress.country in (:keyWords)");
			sb.append(" or c.adress.city in (:keyWords) or g.groupName in (:keyWords)");

			// Execute query
			Query query = session.createQuery(sb.toString());
			query.setParameterList("keyWords", setKeyWords);
			@SuppressWarnings("unchecked")
			List<Contact> list = (List<Contact>) query.list();
			contacts = new HashSet<>(list);
			session.close();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return contacts;
	}
	
	
}