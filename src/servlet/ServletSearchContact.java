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
 * Servlet implementation class ServletSearchContact
 */
public class ServletSearchContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Contact contact = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSearchContact() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			String idContact =request.getParameter("id");
			ContactService cs = new ContactService();
			
			//cs.searchContact(idContact);
			
			//Il faudrait envoyer l'objet contact vers la JSP Search.jsp
			RequestDispatcher rd=request.getRequestDispatcher("Search.jsp");
			rd.forward(request,response);

		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
