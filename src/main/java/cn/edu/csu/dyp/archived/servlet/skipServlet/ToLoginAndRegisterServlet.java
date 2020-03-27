package cn.edu.csu.dyp.archived.servlet.skipServlet;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ToLoginAndRegisterServlet")
public class ToLoginAndRegisterServlet extends HttpServlet {
    private static final String LOGIN_AND_REGISTER_PAGE = "/WEB-INF/jsp/BeforeLogin/logAndregister.jsp";
    private static Logger logger = Logger.getLogger(ToLoginAndRegisterServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("to LOGIN_AND_REGISTER_PAGE");
        logger.info("用户访问登录或注册页面");
        request.getRequestDispatcher(LOGIN_AND_REGISTER_PAGE).forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
