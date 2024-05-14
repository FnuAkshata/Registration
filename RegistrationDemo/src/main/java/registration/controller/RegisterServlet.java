package registration.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.RegisterBean;
import registration.dao.RegisterDAO;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private RegisterDAO registerDAO = new RegisterDAO();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String contact = request.getParameter("contact");
		
		RegisterBean registerBean = new RegisterBean();
		registerBean.setLastName(firstName);
		registerBean.setLastName(lastName);
		registerBean.setLastName(userName);
		registerBean.setLastName(password);
		registerBean.setLastName(contact);
		
		try {
			registerDAO.registerUser(registerBean);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/registrationSuccess.jsp");
		dispatcher.forward(request, response);
	}


	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/register.jsp");
		dispatcher.forward(req, resp);
	}

}
