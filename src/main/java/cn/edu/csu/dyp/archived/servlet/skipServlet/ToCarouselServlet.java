package cn.edu.csu.dyp.archived.servlet.skipServlet;

import cn.edu.csu.dyp.archived.model.user.User;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ToCarouselServlet")
public class ToCarouselServlet extends HttpServlet {
    private static Logger logger = Logger.getLogger(ToCarouselServlet.class);

    private static final String INDEX_PAGE= "/WEB-INF/jsp/AfterLogin/carousel.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        logger.info(user.getUserId() + "访问主页");
        request.getRequestDispatcher(INDEX_PAGE).forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
