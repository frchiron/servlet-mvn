package org.esgi;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/book")
public class BookServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        System.out.println("on passe par la servlet BookServlet avec l'id="+id);

        String titleFound = null;
        if (id != null) {
            // TODO recuperer le titre du livre
            //titleFound = ...;
        }
        resp.getWriter().println(titleFound);

    }

}
