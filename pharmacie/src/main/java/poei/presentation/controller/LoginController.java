package poei.presentation.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import poei.presentation.bean.UserDto;
import poei.service.IUserService;

@WebServlet("/login")
public class LoginController extends HttpServlet {

	@Autowired
	private IUserService userService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			authenticate(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void authenticate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		final UserDto connectedUser = userService.findUserForConnexion(username, password);

		if (connectedUser != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("login-success.jsp");
			dispatcher.forward(request, response);
		} else {
			throw new Exception("Login not successful..");
		}
	}

}
