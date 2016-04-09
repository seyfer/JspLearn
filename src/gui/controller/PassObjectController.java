package gui.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.core.ApplicationContext;

import beans.User;

/**
 * Servlet implementation class PassObjectController
 */
@WebServlet("/PassObjectController")
public class PassObjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PassObjectController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user1 = new User("s@s.su", "ss");
		User user2 = new User("d@s.su", "dd");
		User user3 = new User("f@s.su", "ff");
		
		request.setAttribute("user1", user1);
		
		HttpSession session = request.getSession();
		session.setAttribute("user2", user2);
		
		ServletContext context = getServletContext();
		context.setAttribute("user3", user3);
		
		Map<String, String> map = new HashMap<>();
		map.put("fruit", "apple");
		
		request.setAttribute("map1", map);
		request.setAttribute("link", "http://tt.tt");
		
		List<User> users = new ArrayList<>();
		users.add(user1);
		users.add(user2);
		users.add(user3);
		
		session.setAttribute("list1", users);
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.getRequestDispatcher("/jstl/receiveObject.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
