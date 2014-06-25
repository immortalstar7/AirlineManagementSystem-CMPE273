package controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import wrapper.LoginWebServiceClient;

import model.UserMessageBean;


/**
 * Servlet implementation class LogonServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String HOME_PAGE = "Home.jsp";	
	private static final String LOGIN_FAILURE = "LoginFailure.jsp";
	LoginWebServiceClient loginWebServiceClient = new LoginWebServiceClient();
	UserMessageBean userMessageBean = null;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strEmail = request.getParameter("email");
		String strPassword = request.getParameter("password");
		String strMsg = null;
		HttpSession session = request.getSession();
		boolean isValidLogon = false;
		System.out.println("Input Type is: "+request.getParameter("type"));
		session.setAttribute("type", request.getParameter("type"));
		try {
			System.out.println("Inside post");
			userMessageBean = loginWebServiceClient.userValidation(strEmail, strPassword,request.getParameter("type"));
			if(userMessageBean.getUser() != null){
				session.setAttribute("user_id",userMessageBean.getUser().getUser_id());						
				strMsg = userMessageBean.getMessage();
				System.out.println("Message is: "+strMsg);
				session.setAttribute("msg", strMsg);
				isValidLogon = true;
			}else{
				strMsg =	userMessageBean.getMessage();
				session.setAttribute("msg", strMsg);
			}
		} catch(Exception e) {
			strMsg =	userMessageBean.getMessage();
			session.setAttribute("msg", strMsg);

		}
		if(isValidLogon) {
			System.out.println("Is valid");
			response.sendRedirect(HOME_PAGE);
		} else {
			session.setAttribute("errorMsg", strMsg);
			response.sendRedirect(LOGIN_FAILURE);
		}

	}
	
	private void setRequestAttributes(HttpServletRequest request) {
		Enumeration<String>  enumKeys =  request.getParameterNames();
		while(enumKeys.hasMoreElements()) {
			String key  = enumKeys.nextElement();
			request.setAttribute(key, request.getParameter(key))  ;
		}
	}
}
