package picturesquirrel.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainController
 */
@WebServlet("/MainController")
public class MainController extends HttpServlet {
	private Map<String, String> actionMap = new HashMap<>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MainController() {
		// Build a Map of action parameters to pages

		actionMap.put("image", "/image.jsp");
		actionMap.put("rate", "/image.jsp");
		actionMap.put("home", "/home.jsp");
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	private void doForward(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Get the action parameter
		String action = request.getParameter("action");

		// If the action parameter is null or the map doesn't contain
		// a page for this action, set the action to the home page
		if (action == null || !actionMap.containsKey(action)) {
			action = "home";
		}

		// Forward to the requested page.
		request.getRequestDispatcher("/picturesquirrel/" + actionMap.get(action)).forward(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doForward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doForward(request, response);
	}
}
