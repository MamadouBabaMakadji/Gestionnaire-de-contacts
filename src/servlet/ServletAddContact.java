package servlet;

import model.Contact;
import service.ContactService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ServletAddContact
 */
public class ServletAddContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Contact contact;
   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAddContact() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		try{
			contact = new Contact(request.getParameter("nom"),request.getParameter("prenom"),
					request.getParameter("mail"));
			
			ContactService cs = new ContactService();
			if(cs.createContact(contact))
			{
				//Redirection vers une bonne page
				System.out.println("Contact " +contact.getNom()+ " a bien été crée");
			}
			else
			{
				//redirection vers une autre page pour indiquer que l'insertion n'a pas pu se faire
				System.out.println("Insertion non effectue");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
			
	}
	
	

}
