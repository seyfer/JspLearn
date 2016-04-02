package gui.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ContextController
 */
@WebServlet("/ContextController")
public class ContextController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContextController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//request scope
//		request.setAttribute("test", "test");
//		String test =(String) request.getAttribute("test");
		
		//session scope
//		HttpSession session = request.getSession();
//		session.setAttribute("test", "test");
		
		//app scope		
		ServletContext context = getServletContext();
		
		Integer hits = (Integer) context.getAttribute("hits");
		
		if (hits == null) {
			hits = 0;
		} else {
			hits ++;
		}
		 
		context.setAttribute("hits", hits);
		
		String username = context.getInitParameter("username");
		
		response.getWriter()
		.append("Hits " + hits)
		.append("\n").append(username)
		.append("\n Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
