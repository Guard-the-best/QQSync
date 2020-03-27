package cn.edu.csu.dyp.archived.servlet.skipServlet;

import cn.edu.csu.dyp.archived.model.user.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ToMainServlet")
public class ToMainServlet extends HttpServlet {
    private static final String INDEX_PAGE = "/WEB-INF/jsp/AfterLogin/main.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        System.out.println(user.getUserId());


        request.getRequestDispatcher(INDEX_PAGE).forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
