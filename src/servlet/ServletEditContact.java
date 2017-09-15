package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Contact;
import service.ContactService;

/**
 * Servlet implementation class ServletEditContact
 */
public class ServletEditContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Contact contact;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEditContact() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		try{
			contact = new Contact(request.getParameter("nom"),request.getParameter("prenom"), 
					request.getParameter("mail"));
			ContactService cs = new ContactService();
			if(cs.editContact(contact))
			{
				//Redirection vers une bonne page
				System.out.println("Contact " +contact.getNom()+ " a bien été modfier");
				RequestDispatcher rd=request.getRequestDispatcher("FormEditContact.jsp");
				rd.forward(request,response);
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
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
