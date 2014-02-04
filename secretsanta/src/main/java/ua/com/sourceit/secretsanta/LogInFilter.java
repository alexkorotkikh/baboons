package ua.com.sourceit.secretsanta;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * User: alexkorotkikh
 * Date: 2/1/14
 * Time: 12:39 PM
 */
public class LogInFilter implements Filter {
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        boolean isLoggedIn = false;
        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals("sessionId") && cookie.getValue().equals("1234567890")) {
                isLoggedIn = true;
                chain.doFilter(req, resp);
            }
        }

        if (!isLoggedIn) {
            HttpServletResponse response = (HttpServletResponse) resp;
            response.setStatus(401);
            PrintWriter out = response.getWriter();
            out.println("<h1>Please log in</h1>");
        }
    }

    public void destroy() {
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
