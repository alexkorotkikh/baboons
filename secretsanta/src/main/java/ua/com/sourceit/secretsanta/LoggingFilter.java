package ua.com.sourceit.secretsanta;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * User: alexkorotkikh
 * Date: 1/30/14
 * Time: 5:06 PM
 */
public class LoggingFilter implements Filter {

    private Logger log;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log = Logger.getLogger(LoggingFilter.class.getName());
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        log.info("Request with method " + req.getMethod() + " was made on path: " + req.getRequestURI());

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // do nothing
    }
}
