package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletDelContact
 */
public class ServletDelContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String idContact;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDelContact() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
//		try{
//			idContact = request.getParameter("id");
//			
//			ContactService cs = new ContactService();
//			if(cs.deleteContact(idContact)){
//				
//				//Redirection vers une bonne page
//				System.out.println("Suppression effectué");
//			}
//			else{
//				//redirection vers une autre page pour indiquer que l'insertion n'a pas pu se faire
//				System.out.println("Suppression non effectué");
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//		}
		
		
	}

}
