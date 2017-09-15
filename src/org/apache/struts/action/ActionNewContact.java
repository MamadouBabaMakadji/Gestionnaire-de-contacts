package org.apache.struts.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Adress;
import model.Contact;
import model.GroupeContact;
import model.PhoneNumber;
import service.ContactService;

public class ActionNewContact extends Action{
	
	
	private int recup_id_contact()
	{
		String driver= "com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost/contact_db";
		String login="root";
		String mdp="root";
		int id = -1;
		Statement stmt = null;
		Connection connect = null;
		String requete = "Select id from Contact order by id DESC";
		
		try{
			Class.forName(driver);
			connect= DriverManager.getConnection(url,login,mdp);
			stmt=connect.createStatement();
			
			//Exécution de la requête
			ResultSet rs = stmt.executeQuery(requete);
			if(rs.next()){
				id = rs.getInt(1);
			}
		
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Echec de la connexion");
		}finally{
			try{
				if(stmt !=null){
					stmt.close();
				}
				if(connect !=null){
					connect.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}	
		}
	return id;
	}
	
	private int recup_IdGroup(String groupName)
	{
		String driver= "com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost/contact_db";
		String login="root";
		String mdp="root";
		Statement stmt = null;
		Connection connect = null;
		ResultSet rs = null;
		int id = -1;
		
		try{
			Class.forName(driver);
			connect= DriverManager.getConnection(url,login,mdp);
			stmt=connect.createStatement();
			String requete = "select id from contact_group where name='"+groupName+"'";
			System.out.println(requete);
			rs = stmt.executeQuery(requete);
			while(rs.next()) id= rs.getInt(1);
			System.out.println("id = " +id);
			

		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Echec de la connexion");
		}finally{
			try{
				if(stmt !=null){
					stmt.close();
				}
				if(connect !=null){
					connect.close();
				}
				if(rs != null)
				{
					rs.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}	
		}
	return id;
	}

	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception 
	{
		
		NewContactForm ncf = (NewContactForm) form;
		//java.util.regex.Pattern p = java.util.regex.Pattern.compile("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)+$");
		//Matcher verif_mail=p.matcher(ncf.getMail());
		if(ncf.getNom() != null && ncf.getPrenom()!= null && ncf.getMail().length()>5)
		{
			ContactService cs = new ContactService();
			Contact c = new Contact(ncf.getNom(),ncf.getPrenom(),ncf.getMail());
			cs.createContact(c);
			int id_c = recup_id_contact();
			System.out.println("id = " +id_c);
			Adress adress = new Adress(id_c,ncf.getAdresse(),ncf.getVille(),ncf.getCode_postal(),ncf.getPays());
			cs.ajoutAdress(adress);
			PhoneNumber p = new PhoneNumber(id_c,ncf.getTel());
			cs.ajoutPhoneNumber(p);
			
			System.out.println("id = " + recup_IdGroup(ncf.getGroup()));
			System.out.println("nameGroup =" +ncf.getGroup() );
			if(ncf.getGroup()!= "")
			{
				GroupeContact gc = new GroupeContact(recup_IdGroup(ncf.getGroup()),ncf.getGroup());
				cs.ajoutContactInGroup(gc,id_c);
			}
								
			return mapping.findForward("AjoutOK");
		}
		
		else
			return mapping.findForward("EchecAjout");

	}
	
}
