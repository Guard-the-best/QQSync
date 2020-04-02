package cn.edu.csu.dyp.archived.servlet.userServlet;

import cn.edu.csu.dyp.archived.model.user.User;
import cn.edu.csu.dyp.Service.UserService;
import cn.edu.csu.dyp.Service.util.ModifyInfoStat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserService();
        HttpSession session = request.getSession();

        String userName = ((User)session.getAttribute("user")).getUsername();
        String oldPassword = request.getParameter("origin");
        String newPassword = request.getParameter("new");

        ModifyInfoStat modifyInfoStat = userService.modifyPassword(userName, oldPassword, newPassword);

        PrintWriter out = response.getWriter();

        System.out.println("change");
        if (modifyInfoStat == ModifyInfoStat.Success) {
            out.print(1);
            response.sendRedirect("/toLogin");
        }
        else {
            request.setAttribute("msg", modifyInfoStat.toString());
            request.getRequestDispatcher("/toChangePassword").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
