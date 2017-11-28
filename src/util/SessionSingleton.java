package util;

import org.hibernate.Session;

public class SessionSingleton {
	
	private static Session session;
	
	private SessionSingleton(){
		
	}
	
	public static Session getInstance(){
		if(session != null){
			return session; 
		}
		return (session = HibernateUtil.getSessionFactory().openSession());
	}
}