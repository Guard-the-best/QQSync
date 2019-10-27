package cn.edu.csu.dyp.web.servlet.skipServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ToChangePasswordServlet")
public class ToChangePasswordServlet extends HttpServlet {
    private static final String CHANGE_PASSWORD_PAGE = "/WEB-INF/jsp/AfterLogin/changePassword.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(CHANGE_PASSWORD_PAGE).forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}