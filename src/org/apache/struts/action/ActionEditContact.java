package org.apache.struts.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Adress;
import model.Contact;
import model.Group;
import model.PhoneNumber;
import service.ContactService;

public class ActionEditContact extends Action
{
	private int recup_IdGroup(String groupName) {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost/contact_db";
		String login = "root";
		String mdp = "root";
		Statement stmt = null;
		Connection connect = null;
		ResultSet rs = null;
		int id = -1;

		try {
			Class.forName(driver);
			connect = DriverManager.getConnection(url, login, mdp);
			stmt = connect.createStatement();
			String requete = "select id from contact_group where name='" + groupName + "'";
			System.out.println(requete);
			rs = stmt.executeQuery(requete);
			while (rs.next())
				id = rs.getInt(1);
			System.out.println("id = " + id);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Echec de la connexion");
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (connect != null) {
					connect.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return id;
	}

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		EditContactForm ncf = (EditContactForm) form;
		// java.util.regex.Pattern p =
		// java.util.regex.Pattern.compile("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)+$");
		// Matcher verif_mail=p.matcher(ncf.getMail());
		// System.out.println("ACCCCCCCCCCCCCCCTTTTTTTTTTIIIIIIIIIIIIIOOOOOOONNNNNNNNNNN");
		if (ncf.getNom() != null && ncf.getPrenom() != null && ncf.getMail().length() > 5) {
//			Contact c = new Contact(ncf.getNom(), ncf.getPrenom(), ncf.getMail());
//			Adress a = new Adress(ncf.getIdentifiant(), ncf.getAdress(), ncf.getVille(), ncf.getCode_postal(),
//					ncf.getPays());
//			PhoneNumber p = new PhoneNumber(ncf.getIdentifiant(), ncf.getTel());
//			c.setId(ncf.getIdentifiant());
//			ContactService cs = new ContactService();
//			cs.editContact(c);
//			cs.editAdress(a);
//			cs.editPhone(p);
//			cs.editGroup(new Group(recup_IdGroup(ncf.getGroup()), ncf.getGroup(), ncf.getIdentifiant()));
			return mapping.findForward("EditOK");
		} else {
			return mapping.findForward("EchecEdit");
		}
	}

}
