package ua.com.sourceit.secretsanta;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * User: alexkorotkikh
 * Date: 2/1/14
 * Time: 12:03 PM
 */
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String username = request.getParameter("username");
        final String password = request.getParameter("password");
        if (username.equals("test") && password.equals("test")) {
            final Cookie sessionId = new Cookie("sessionId", "1234567890");
            sessionId.setMaxAge(2 * 60 * 60);
            response.addCookie(sessionId);

            PrintWriter out = response.getWriter();
            out.println("<h1>Hello</h1>");
        } else {
            PrintWriter out = response.getWriter();
            out.println("<h1>Wrong password</h1>");
        }
    }
}
