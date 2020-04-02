package cn.edu.csu.dyp.archived.servlet.skipServlet;

import cn.edu.csu.dyp.archived.model.user.User;
import cn.edu.csu.dyp.Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ToModifyInfoServlet")
public class ToModifyInfoServlet extends HttpServlet {
    private static final String MODIFY_INFO_PAGE = "/WEB-INF/jsp/AfterLogin/personalInfo.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        request.setAttribute("address", new UserService().getAddress(user.getUserId()));

        request.getRequestDispatcher(MODIFY_INFO_PAGE).forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
