package ua.com.sourceit.secretsanta;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * User: alexkorotkikh
 * Date: 1/26/14
 * Time: 10:25 AM
 */
public class SecretSantaServlet extends HttpServlet {
    private SecretSanta santa;
    private Map<String, String> menuMapping;

    @Override
    public void init() throws ServletException {
        santa = new SecretSanta();
        menuMapping = new HashMap<String, String>();
        menuMapping.put("/addgroup", "1");
        menuMapping.put("/adduser", "2");
        menuMapping.put("/addpresent", "3");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        out.println("<h1>Hello World</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();
        String menuItemNbr = menuMapping.get(path);
        SecretSantaCommand command = santa.createCommand(menuItemNbr);
        for (String paramName : command.getParamNames()) {
            command.addInput(req.getParameter(paramName));
        }
        command.executeCommand();

        PrintWriter out = resp.getWriter();
        out.println(command.getSuccessDescription());
    }
}
