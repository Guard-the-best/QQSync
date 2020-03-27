package cn.edu.csu.dyp.archived.servlet.userServlet;

import cn.edu.csu.dyp.archived.model.user.User;
import cn.edu.csu.dyp.archived.service.UserService;
import cn.edu.csu.dyp.archived.service.util.RegisterStat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("registerID");
        String password = request.getParameter("registerPassword");
        String phoneNumber = request.getParameter("phoneNumber");

        RegisterStat registerStat = new UserService().register(new User(username, username, password, phoneNumber, username));

        request.getRequestDispatcher("/toLogin").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
