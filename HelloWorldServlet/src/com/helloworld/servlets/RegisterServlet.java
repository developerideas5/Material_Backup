package com.helloworld.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String name=request.getParameter("name");
		request.setAttribute("name",name );
		request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("fullname");
		String Addr = request.getParameter("address");
		String age = request.getParameter("age");
		String Qual = request.getParameter("qual");
		String Persent = request.getParameter("percent");
		String Year = request.getParameter("yop");
		if(name.isEmpty()||Addr.isEmpty()||age.isEmpty()||Qual.isEmpty()||Persent.isEmpty()||Year.isEmpty())
		{
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/register.jsp");
			out.println("<font color=red>Please fill all the fields</font>");
			rd.include(request, response);
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/home.jsp");
			rd.forward(request, response);
		}
	}
	

}
