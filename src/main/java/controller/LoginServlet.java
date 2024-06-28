package controller;

import bean.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private final UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (userService.authenticate(username, password)) {
            User user = new User(username, password); // In a real app, don't store the password here
            request.getSession().setAttribute("user", user);
            response.sendRedirect("home-page.jsp"); // Redirect to welcome page
        } else {
            request.setAttribute("error", "Invalid credentials. Please try again.");
            request.getRequestDispatcher("home-page.jsp").forward(request, response);
        }
    }
}
