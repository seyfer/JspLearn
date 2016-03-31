package mvc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User;

/**
 * Servlet implementation class FromController
 */
@WebServlet("/mvc/FormController")
public class FormController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FormController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		String page = null;

		response.getWriter().println("action is " + action);

		if (action == null) {
			page = "/index.jsp";
		} else if (action.equals("login")) {
			
			request.setAttribute("email", "");
			request.setAttribute("password", "");
			request.setAttribute("message", "");
			
			page = "/mvcform.jsp";
		}

		getServletContext().getRequestDispatcher(page).forward(request, response);

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		String page = null;

		response.getWriter().println("action is " + action);

		if (action == null) {
			page = "/index.jsp";
		} else if (action.equals("login")) {
			String email = request.getParameter("email");
			String password = request.getParameter("password");

			if (email != null)
				request.setAttribute("email", email);

			if (password != null)
				request.setAttribute("password", password);

			User user = new User(email, password);

			if (user.validate()) {
				page = "/loginsuccess.jsp";
			} else {
				request.setAttribute("message", user.getMessage());
				
				page = "/mvcform.jsp";
			}
		}

		getServletContext().getRequestDispatcher(page).forward(request, response);

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
