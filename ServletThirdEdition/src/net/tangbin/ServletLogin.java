package net.tangbin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by TangBin on 22/12/2016.
 */
@WebServlet(name = "ServletLogin", urlPatterns = "/ServletLogin")
public class ServletLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        String username=request.getParameter("name");
        String password=request.getParameter("password");
        User user = new User();
        user.setName(username);
        user.setPassword(password);
        if(userDao.checklogin(user))
            request.getRequestDispatcher("upload.jsp").forward(request, response);
        else
        {
            PrintWriter out = response.getWriter();
            out.println("user name or password id wrong!");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
