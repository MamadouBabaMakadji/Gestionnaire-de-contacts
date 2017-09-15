package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

/**
 * Servlet implementation class ServletLogin
 */
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {
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
		RequestDispatcher dispatcher;
		
		String nom = request.getParameter("nom");
		String password = request.getParameter("password");
		if(!nom.isEmpty() || !password.isEmpty())
		{
			if(!nom.equals(password)){
				RequestDispatcher rd=request.getRequestDispatcher("Index.jsp");
				System.out.println("Mauvais login");
				rd.forward(request,response);
				
				//System.out.println("entre non vide");
				
			}else{
				dispatcher = request.getRequestDispatcher("Main.jsp");
				dispatcher.forward(request,response);
			}
		}
		else
		{
			System.out.println("entre  vide");
			dispatcher = request.getRequestDispatcher("Index.jsp");
			dispatcher.forward(request, response);
			// faire un truc de ce genre pour écrire une phrase
			boolean flag = true;
		}
		System.out.println("Login = " + nom+ " et pswd = " +password);
		
		
	}

}
