package cn.edu.csu.dyp.web.servlet.userServlet;

import cn.edu.csu.dyp.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "IsUserNameExistServlet")
public class IsUserNameExistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        UserService userService = new UserService();
        PrintWriter out = response.getWriter();
        if (userService.isUsernameExist(username)) {
            out.print("Exist");
        } else {
            out.print("Not Exist");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
