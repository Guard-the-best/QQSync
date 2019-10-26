package cn.edu.csu.dyp.web.servlet;

import cn.edu.csu.dyp.model.User;
import cn.edu.csu.dyp.service.UserService;
import cn.edu.csu.dyp.service.util.RegisterStat;

import javax.jws.soap.SOAPBinding;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String phoneNumber = request.getParameter("phoneNumber");
        String nickname = request.getParameter("nickname");

        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        RegisterStat registerStat = new UserService().register(new User(null, username, password, phoneNumber, nickname));

        out.print(registerStat.toString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
