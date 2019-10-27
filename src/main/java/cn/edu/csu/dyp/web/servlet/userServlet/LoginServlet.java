package cn.edu.csu.dyp.web.servlet.userServlet;

import cn.edu.csu.dyp.model.user.User;
import cn.edu.csu.dyp.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {

    // ----Need to fill the location---- //
//    private static final String LOGIN_PAGE = "/WEB-INF/jsp/BeforeLogin/login.jsp";
    private static final String LOGIN_PAGE = "/toLoginAndRegister";
    private static final String INDEX_PAGE = "/toMain";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("email");
        String password = request.getParameter("password");

        User user = new UserService().login(username, password);

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect(INDEX_PAGE);
        }
        else {
            // May need to leave a message in request.
            request.getRequestDispatcher(LOGIN_PAGE).forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
