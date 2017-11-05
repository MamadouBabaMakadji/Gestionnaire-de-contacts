package DAO;


import java.sql.SQLException;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import model.Contact;
import model.Group;
import model.PhoneNumber;
import util.HibernateUtil;
import util.SessionSingleton;


public class ContactDAO {
	
	

	public ContactDAO() {
	}

	public boolean insertDB(Object object) throws Exception {
		boolean result = false;
		if(object==null) return result;
		else{
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

	public Session getSession() {
		Session session = SessionSingleton.getInstance();
		return session;
	}

	// Get a contact with session.get()
	public Contact getContact(long contact_ID) {
		//Session session = getSession();
		Session session = HibernateUtil.getSessionFactory().openSession(); 
		Contact contact = (Contact) session.get(Contact.class, contact_ID);
		session.close();
		return contact;
	}

	public boolean saveUpdate(Session session, Contact contact) {
		boolean result = false;
		try {
			session.beginTransaction();
			session.saveOrUpdate(contact);
			session.getTransaction().commit();
			result = true;
			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return result;
	}
}