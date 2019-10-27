package cn.edu.csu.dyp.web.servlet.userServlet;

import cn.edu.csu.dyp.model.user.User;
import cn.edu.csu.dyp.service.UserService;
import cn.edu.csu.dyp.service.util.ModifyInfoStat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserService();
        HttpSession session = request.getSession();

        String userName = ((User)session.getAttribute("user")).getUsername();
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");

        ModifyInfoStat modifyInfoStat = userService.modifyPassword(userName, oldPassword, newPassword);

        if (modifyInfoStat == ModifyInfoStat.Success) {
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
