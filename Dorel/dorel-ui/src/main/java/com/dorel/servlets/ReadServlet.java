package com.dorel.servlets;

import com.dorel.db.manager.HSQLDBManager;
import com.dorel.dto.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by bsoimu on 7/30/2016.
 */

@WebServlet("/read")
public class ReadServlet extends HttpServlet {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 3553124310749435624L;

    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {

        User user = new User();
        user.setUser(request.getParameter("name"));

        System.out.println(user.getUser());
        System.out.println(user.getPass());


        try {
            getDBManager(request).getConnection().prepareStatement(("select USER_PASS from USERS where USER_USER='\" + user.getUser() + \"';"))
                    .executeQuery();

        } catch (final SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        request.setAttribute("user", user);
        request.getRequestDispatcher("/Read.jsp").forward(request, response);
    }

    private HSQLDBManager getDBManager(final HttpServletRequest request) {

        final ServletContext ctx = request.getServletContext();
        final HSQLDBManager dbManager = (HSQLDBManager) ctx.getAttribute("HSQLDBManager");
        return dbManager;

    }

}
