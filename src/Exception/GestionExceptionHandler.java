package Exception;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ExceptionHandler;
import org.apache.struts.config.ExceptionConfig;

public class GestionExceptionHandler extends ExceptionHandler{

	@Override
	public ActionForward execute(Exception arg0, ExceptionConfig arg1, ActionMapping arg2, ActionForm arg3,
			HttpServletRequest arg4, HttpServletResponse arg5) throws ServletException 
	{
		// TODO Auto-generated method stub
		//return super.execute(arg0, arg1, arg2, arg3, arg4, arg5);
		logException(arg0);
		return arg2.findForward("erreur Application");
	}
	

}
