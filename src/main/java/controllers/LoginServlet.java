package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Database;
import dao.JpaData;
import models.User;

/**
 * Servlet implementation class LoginServlet
 */

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       JpaData data=new JpaData();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String username = request.getParameter("email");
		String password = request.getParameter("mot_passe");
		User user = new User();
		user.setEmail(username);
		user.setMotdepasse(password);
		
			if (data.validate(user)) {
				user=data.setAttributes(user);
				System.out.println(user);
				HttpSession session = request.getSession();
				session.setAttribute("user",user);
				response.sendRedirect("success.jsp");
			} else {
				//HttpSession session = request.getSession();
				response.setContentType("text/html");
				
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Invalid Email or Password');");
				out.println("</script>");
				RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
				rd.include(request, response);

				

				
				//session.setAttribute("user", username);
				//response.sendRedirect("login.jsp");
			}
		
	}

}
