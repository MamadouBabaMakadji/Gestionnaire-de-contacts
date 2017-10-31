package DAO;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import model.Contact;
import util.HibernateUtil;


public class ContactDAO {

	public ContactDAO() {
	}

	public boolean insertDB(Object object) throws Exception {
		boolean result = false;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			/*long id = (long) session.save(object);*/
			session.save(object);
			session.getTransaction().commit();
			
			/*System.out.println("Fin enregistrement, ID = " + id);*/
			session.close();
			result = true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return result;
	}

	public boolean insertContact(Contact contact) throws Exception {
		return insertDB(contact);
	}

	// public boolean ajouter(Contact contact) {
	// boolean result = false;
	// try {
	// Session session = HibernateUtil.getSessionFactory().openSession();
	// session.beginTransaction();
	// String nom = contact.getNom();
	// String prenom = contact.getPrenom();
	// String mail = contact.getMail();
	// System.out.println("Contact ==> " + nom + "|" + prenom + "|" + mail);
	// Contact c = new Contact(nom, prenom, mail);
	// System.out.println(" Enregistrement Table CONTACT");
	// long id = (long) session.save(c);
	// session.getTransaction().commit();
	// System.out.println("Fin enregistrement, ID Contact = " + id);
	// session.close();
	// result = true;
	// } catch (Exception e) {
	// // TODO: handle exception
	// }
	//
	// return result;
	// }
	//
	// public boolean ajouterAdress(Adress a) {
	// boolean result = false;
	// try {
	// Session session = HibernateUtil.getSessionFactory().openSession();
	// session.beginTransaction();
	// String street = a.getStreet();
	// String city = a.getCity();
	// String zip = a.getZip();
	// String country = a.getCountry();
	// Adress adress = new Adress(street, city, zip, country);
	// System.out.println("Adresse ==> " + street + "|" + city + "|" + zip + "|"
	// + country);
	// System.out.println("Enregistrement Table ADRESS");
	// long id = (long) session.save(adress);
	// session.getTransaction().commit();
	// System.out.println("Fin enregistrement, ID Adress = " + id);
	// result = true;
	// session.close();
	// } catch (Exception e) {
	// // TODO: handle exception
	// }
	// return result;
	// }
	//
	// public boolean ajouterPhone(PhoneNumber p) {
	// boolean result = false;
	// try {
	// Session session = HibernateUtil.getSessionFactory().openSession();
	// session.beginTransaction();
	// String phoneKind = "";// p.getPhoneKind();
	// String phoneNum = p.getPhoneNumber();
	// PhoneNumber phone = new PhoneNumber(phoneKind, phoneNum);
	// System.out.println("PhoneNumber ==> " + phoneNum);
	// System.out.println("Enregistrement Table PHONENUMBER");
	// long id = (long) session.save(phone);
	// session.getTransaction().commit();
	// System.out.println("Fin enregistrement, ID Phone = " + id);
	// result = true;
	// session.close();
	//
	// } catch (Exception e) {
	// // TODO: handle exception
	// }
	// return result;
	// }

	// public boolean delete(String idContact) {
	// boolean result = false;
	//
	// String driver = "com.mysql.jdbc.Driver";
	// String url = "jdbc:mysql://localhost/contact_db";
	// String login = "root";
	// String mdp = "root";
	// String requete = "DELETE from contact where id = '" + idContact + "'";
	//
	// System.out.println("La requete suppression = " + requete);
	//
	// Statement stmt = null;
	// Connection connect = null;
	//
	// try {
	// Class.forName(driver);
	// connect = DriverManager.getConnection(url, login, mdp);
	// stmt = connect.createStatement();
	// // Exécute la requête
	// stmt.executeUpdate(requete);
	// result = true;
	//
	// // Test for me
	// // System.out.println("Passage Supression");
	// } catch (Exception e) {
	// e.printStackTrace();
	// System.out.println("Echec de la connexion");
	// } finally {
	// try {
	//
	// if (stmt != null) {
	// stmt.close();
	// }
	// if (connect != null) {
	// connect.close();
	// }
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	//
	// }
	//
	// return result;
	// }
	//
	// public boolean edit(Contact contact) {
	// boolean result = false;
	//
	// String driver = "com.mysql.jdbc.Driver";
	// String url = "jdbc:mysql://localhost/contact_db";
	// String login = "root";
	// String mdp = "root";
	// String requete1 = "UPDATE contact set nom = '" + contact.getNom() + "',
	// prenom = '" + contact.getPrenom()
	// + "', mail ='" + contact.getMail() + "' " + "where id='" +
	// contact.getId() + "'";
	// // System.out.println("La requete = " +requete);
	//
	// Statement stmt = null;
	// Connection connect = null;
	//
	// try {
	// Class.forName(driver);
	// connect = DriverManager.getConnection(url, login, mdp);
	// stmt = connect.createStatement();
	// stmt.executeUpdate(requete1); // Exécute la requête
	// result = true;
	//
	// // Test for me
	// /*
	// * System.out.println("Le contact d'Id : " +contact.getId()+
	// * ",de nom : " +contact.getNom()+ ", de prénom : "
	// * +contact.getPrenom()+ ", et de mail :" +contact.getMail());
	// * System.out.println("Update effectué");
	// */
	// } catch (Exception e) {
	// e.printStackTrace();
	// System.out.println("Echec de la connexion");
	// } finally {
	// try {
	//
	// if (stmt != null) {
	// stmt.close();
	// }
	// if (connect != null) {
	// connect.close();
	// }
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	//
	// }
	// return result;
	// }
	//
	// public boolean edit_a(Adress a) // Pour modifier la partie Adresse
	// {
	// boolean result = false;
	//
	// String driver = "com.mysql.jdbc.Driver";
	// String url = "jdbc:mysql://localhost/contact_db";
	// String login = "root";
	// String mdp = "root";
	// String requete1 = "UPDATE adress set street = '" + a.getStreet() + "',
	// city = '" + a.getCity() + "', zip ='"
	// + a.getZip() + "',country= '" + a.getCountry() + "'" + "where id='" +
	// a.getId() + "'";
	// // System.out.println("La requete = " +requete);
	//
	// Statement stmt = null;
	// Connection connect = null;
	//
	// try {
	// Class.forName(driver);
	// connect = DriverManager.getConnection(url, login, mdp);
	// stmt = connect.createStatement();
	// stmt.executeUpdate(requete1); // Exécute la requête
	// result = true;
	//
	// // Test for me
	// /*
	// * System.out.println("Le contact d'Id : " +contact.getId()+
	// * ",de nom : " +contact.getNom()+ ", de prénom : "
	// * +contact.getPrenom()+ ", et de mail :" +contact.getMail());
	// * System.out.println("Update effectué");
	// */
	// } catch (Exception e) {
	// e.printStackTrace();
	// System.out.println("Echec de la connexion");
	// } finally {
	// try {
	//
	// if (stmt != null) {
	// stmt.close();
	// }
	// if (connect != null) {
	// connect.close();
	// }
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	//
	// }
	// return result;
	// }
	//
	// public boolean edit_p(PhoneNumber p) // Pour modifier la partie
	// PhoneNumber
	// {
	// boolean result = false;
	//
	// String driver = "com.mysql.jdbc.Driver";
	// String url = "jdbc:mysql://localhost/contact_db";
	// String login = "root";
	// String mdp = "root";
	// String requete1 = "UPDATE phonenumber set phoneNumber = '" +
	// p.getPhoneNumber() + "' where id='" + p.getId()
	// + "'";
	// // System.out.println("La requete = " +requete);
	//
	// Statement stmt = null;
	// Connection connect = null;
	//
	// try {
	// Class.forName(driver);
	// connect = DriverManager.getConnection(url, login, mdp);
	// stmt = connect.createStatement();
	// stmt.executeUpdate(requete1); // Exécute la requête
	// result = true;
	//
	// // Test for me
	// /*
	// * System.out.println("Le contact d'Id : " +contact.getId()+
	// * ",de nom : " +contact.getNom()+ ", de prénom : "
	// * +contact.getPrenom()+ ", et de mail :" +contact.getMail());
	// * System.out.println("Update effectué");
	// */
	// } catch (Exception e) {
	// e.printStackTrace();
	// System.out.println("Echec de la connexion");
	// } finally {
	// try {
	//
	// if (stmt != null) {
	// stmt.close();
	// }
	// if (connect != null) {
	// connect.close();
	// }
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	//
	// }
	// return result;
	// }
	//
	// public boolean edit_group(Group gp) // Pour modifier la partie
	// // PhoneNumber
	// {
	// boolean result = false;
	//
	// String driver = "com.mysql.jdbc.Driver";
	// String url = "jdbc:mysql://localhost/contact_db";
	// String login = "root";
	// String mdp = "root";
	// String requete1 = "UPDATE list_group_contact " + "set id_groupContact= '"
	// + gp.getGroupId() + "', nameGroup='"
	// + gp.getGroupName() + "' " + "where id_contact='" + gp.getIdContact() +
	// "'";
	// // System.out.println("La requete = " +requete);
	//
	// Statement stmt = null;
	// Connection connect = null;
	//
	// try {
	// Class.forName(driver);
	// connect = DriverManager.getConnection(url, login, mdp);
	// stmt = connect.createStatement();
	// stmt.executeUpdate(requete1); // Exécute la requête
	// result = true;
	//
	// // Test for me
	// /*
	// * System.out.println("Le contact d'Id : " +contact.getId()+
	// * ",de nom : " +contact.getNom()+ ", de prénom : "
	// * +contact.getPrenom()+ ", et de mail :" +contact.getMail());
	// * System.out.println("Update effectué");
	// */
	// } catch (Exception e) {
	// e.printStackTrace();
	// System.out.println("Echec de la connexion");
	// } finally {
	// try {
	//
	// if (stmt != null) {
	// stmt.close();
	// }
	// if (connect != null) {
	// connect.close();
	// }
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	//
	// }
	// return result;
	// }

	/*
	 * public Contact search(String pId) { String driver=
	 * "com.mysql.jdbc.Driver"; String url="jdbc:mysql://localhost/contact_db";
	 * String login="root"; String mdp="root"; Contact contact = null;
	 * 
	 * Statement stmt = null; Connection connect = null; String requete =
	 * "Select * from Contact where id='" +pId+"'";
	 * 
	 * try{ Class.forName(driver); connect=
	 * DriverManager.getConnection(url,login,mdp);
	 * stmt=connect.createStatement();
	 * 
	 * //Exécution de la requête ResultSet rs = stmt.executeQuery(requete);
	 * 
	 * contact = new Contact(rs.getString("Id"), rs.getString("Nom"),
	 * rs.getString("Prenom"), rs.getString("Mail"));
	 * 
	 * //Test for me //System.out.println("List passage 1"); }catch(Exception e)
	 * { e.printStackTrace(); System.out.println("Echec de la connexion");
	 * }finally{ try{ if(stmt !=null){ stmt.close(); } if(connect !=null){
	 * connect.close(); } }catch(SQLException e){ e.printStackTrace(); }
	 * 
	 * }
	 * 
	 * return contact; }
	 */

	// public List<Contact> getContact() {
	// String driver = "com.mysql.jdbc.Driver";
	// String url = "jdbc:mysql://localhost/contact_db";
	// String login = "root";
	// String mdp = "root";
	//
	// List<Contact> listContact = new ArrayList<Contact>();
	//
	// Contact contact;
	// Statement stmt = null;
	// Connection connect = null;
	// String requete = "Select * from Contact";
	//
	// System.out.println("La requete = " + requete);
	//
	// try {
	// Class.forName(driver);
	// connect = DriverManager.getConnection(url, login, mdp);
	// stmt = connect.createStatement();
	//
	// // Exécute la requête
	// ResultSet rs = stmt.executeQuery(requete);
	//
	// while (rs.next()) {
	// /*
	// * contact = new Contact(rs.getString("Id"),
	// * rs.getString("Nom"), rs.getString("Prenom"),
	// * rs.getString("Mail"));
	// */
	//
	// listContact.add(new Contact(rs.getString("Nom"), rs.getString("Prenom"),
	// rs.getString("Mail")));
	//
	// // ****** test
	// // System.out.println("L'id est : " +contact.getId());
	// }
	//
	// // Test for me
	// // System.out.println("List passage 1");
	// } catch (Exception e) {
	// e.printStackTrace();
	// System.out.println("Echec de la connexion");
	// } finally {
	// try {
	// if (stmt != null) {
	// stmt.close();
	// }
	// if (connect != null) {
	// connect.close();
	// }
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	//
	// }
	// return listContact;
	//
	// }
	//
	// public List<Group> getNameGroup() {
	// ArrayList<Group> listNameGroup = null;
	// String driver = "com.mysql.jdbc.Driver";
	// String url = "jdbc:mysql://localhost/contact_db";
	// String login = "root";
	// String mdp = "root";
	// String requete = "select * from contact_group";
	// Statement stmt = null;
	// Connection connect = null;
	// Group gc = null;
	// try {
	// Class.forName(driver);
	// connect = DriverManager.getConnection(url, login, mdp);
	// stmt = connect.createStatement();
	// ResultSet rs = stmt.executeQuery(requete);
	// listNameGroup = new ArrayList<Group>();
	//
	// while (rs.next()) {
	// gc = new Group(rs.getInt("id"), rs.getString("name"));
	// listNameGroup.add(gc);
	// }
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// } finally {
	//
	// }
	//
	// return listNameGroup;
	// }
	//
	// public boolean deleteContact(Contact c, Adress a, PhoneNumber p) {
	// boolean result = false;
	//
	// String driver = "com.mysql.jdbc.Driver";
	// String url = "jdbc:mysql://localhost/contact_db";
	// String login = "root";
	// String mdp = "root";
	// String requete1 = "delete from contact where id='" + c.getId() + "'";
	// String requete2 = "delete from adress where adress.id='" + a.getId() +
	// "'";
	// String requete3 = "delete from phonenumber where id='" + p.getId() + "'";
	// // System.out.println("La requete = " +requete);
	//
	// Statement stmt = null;
	// Connection connect = null;
	//
	// try {
	// Class.forName(driver);
	// connect = DriverManager.getConnection(url, login, mdp);
	// stmt = connect.createStatement();
	// stmt.executeUpdate(requete1); // Exécute la requête
	// // stmt.executeUpdate(requete2);
	// // stmt.executeUpdate(requete3);
	// result = true;
	//
	// // Test for me
	// /*
	// * System.out.println("Le contact d'Id : " +contact.getId()+
	// * ",de nom : " +contact.getNom()+ ", de prénom : "
	// * +contact.getPrenom()+ ", et de mail :" +contact.getMail());
	// * System.out.println("Update effectué");
	// */
	// } catch (Exception e) {
	// e.printStackTrace();
	// System.out.println("Echec de la connexion");
	// } finally {
	// try {
	//
	// if (stmt != null) {
	// stmt.close();
	// }
	// if (connect != null) {
	// connect.close();
	// }
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// }
	// return result;
	// }
	//
	// public List<Contact> searchContact(String searchName) {
	// String driver = "com.mysql.jdbc.Driver";
	// String url = "jdbc:mysql://localhost/contact_db";
	// String login = "root";
	// String mdp = "root";
	// String requete = "select c.nom, c.prenom, c.mail, a.street, a.city,
	// a.zip,a.country, p.phoneNumber"
	// + " from contact c, adress a, phonenumber p" + " where (c.nom = '" +
	// searchName + "' or c.prenom='"
	// + searchName + "') and c.id=a.id and c.id =p.id ";
	//
	// Statement stmt = null;
	// Connection connect = null;
	// ResultSet rs = null;
	// ArrayList<Contact> listContact = null;
	// try {
	// Class.forName(driver);
	// connect = DriverManager.getConnection(url, login, mdp);
	// stmt = connect.createStatement();
	//
	// // Récupération de la recherche dans la variable rs
	// // Sera envoyé dans le return de la méthode
	// listContact = new ArrayList<Contact>();
	// rs = stmt.executeQuery(requete);
	// while (rs.next()) {
	// listContact.add(new Contact(rs.getString(1), rs.getString(2),
	// rs.getString(3), rs.getString(4),
	// rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8)));
	//
	// }
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// System.out.println("Echec de la connexion : " + e.getMessage());
	// } finally {
	// try {
	//
	// if (stmt != null) {
	// stmt.close();
	// }
	// if (connect != null) {
	// connect.close();
	// }
	// if (rs != null) {
	// rs.close();
	// }
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	//
	// }
	//
	// return listContact;
	// }
	//
	// public boolean createGroup(String nom) {
	// boolean result = false;
	//
	// String driver = "com.mysql.jdbc.Driver";
	// String url = "jdbc:mysql://localhost/contact_db";
	// String login = "root";
	// String mdp = "root";
	// String requete = "insert into contact_group(name) values('" + nom + "')";
	//
	// Statement stmt = null;
	// Connection connect = null;
	//
	// try {
	// Class.forName(driver);
	// connect = DriverManager.getConnection(url, login, mdp);
	// stmt = connect.createStatement();
	// // Exécute la requête
	// stmt.executeUpdate(requete);
	// result = true;
	//
	// // System.out.println("Requete pour l'ajout : exécuté");
	//
	// result = true;
	// } catch (Exception e) {
	// e.printStackTrace();
	// System.out.println("Echec de la connexion");
	// } finally {
	// try {
	//
	// if (stmt != null) {
	// stmt.close();
	// }
	// if (connect != null) {
	// connect.close();
	// }
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	//
	// }
	//
	// return result;
	// }
	//
	// public List<Contact> listContactOfGroup(String idGroup) {
	// String driver = "com.mysql.jdbc.Driver";
	// String url = "jdbc:mysql://localhost/contact_db";
	// String login = "root";
	// String mdp = "root";
	// String requete = "select c.nom, c.prenom, c.mail, ph.phoneNumber,
	// a.street, a.city, a.zip, "
	// + "a.country, lgc.nameGroup " + "from contact c, phonenumber ph, adress
	// a,list_group_contact lgc "
	// + "where (c.id=ph.id and c.id=a.id and c.id = lgc.id_contact and
	// lgc.id_groupContact = '" + idGroup
	// + "') ";
	// System.out.println(requete);
	// Statement stmt = null;
	// Connection connect = null;
	// ResultSet rs = null;
	// List<Contact> listContact = null;
	// try {
	// Class.forName(driver);
	// connect = DriverManager.getConnection(url, login, mdp);
	// stmt = connect.createStatement();
	//
	// // Récupération de la recherche dans la variable rs
	// // On ajoute les résultat à la list qu'on envoie dans le return
	// listContact = new ArrayList<Contact>();
	// rs = stmt.executeQuery(requete);
	// while (rs.next()) {
	// listContact.add(new Contact(rs.getString(1), rs.getString(2),
	// rs.getString(3), rs.getString(5),
	// rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(4)));
	// }
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// System.out.println("Echec de la connexion : " + e.getMessage());
	// } finally {
	// try {
	//
	// if (stmt != null) {
	// stmt.close();
	// }
	// if (connect != null) {
	// connect.close();
	// }
	// if (rs != null) {
	// rs.close();
	// }
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	//
	// }
	//
	// return listContact;
	// }
	//
	// public boolean ajouterContactInGroup(Group gc, int id_contact) {
	// boolean result = false;
	// String driver = "com.mysql.jdbc.Driver";
	// String url = "jdbc:mysql://localhost/contact_db";
	// String login = "root";
	// String mdp = "root";
	//
	// // System.out.println("La requete = " +requete);
	//
	// Statement stmt = null;
	// Connection connect = null;
	//
	// try {
	// Class.forName(driver);
	// connect = DriverManager.getConnection(url, login, mdp);
	// stmt = connect.createStatement();
	// String requete = "insert into list_group_contact (id_contact,
	// id_groupContact,nameGroup) values('"
	// + id_contact + "'," + "'" + gc.getGroupId() + "','" + gc.getGroupName() +
	// "')";
	// System.out.println(requete);
	// stmt.executeUpdate(requete);
	//
	// // Test for me
	// // System.out.println("Le contact d'Id : " +contact.getId()+ ",de
	// // nom : "
	// // +contact.getNom()+ ", de prénom : " +contact.getPrenom()+ ", et
	// // de mail :" +contact.getMail());
	// // System.out.println("Requete pour l'ajout : exécuté");
	//
	// result = true;
	// } catch (Exception e) {
	// e.printStackTrace();
	// System.out.println("Echec de la connexion");
	// } finally {
	// try {
	//
	// if (stmt != null) {
	// stmt.close();
	// }
	// if (connect != null) {
	// connect.close();
	// }
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	//
	// }
	//
	// return result;
	// }

}