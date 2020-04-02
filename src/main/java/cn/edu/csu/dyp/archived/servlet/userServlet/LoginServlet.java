package cn.edu.csu.dyp.archived.servlet.userServlet;

import cn.edu.csu.dyp.archived.model.user.User;
//import com.captcha.botdetect.web.servlet.Captcha;
import org.apache.log4j.Logger;

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

    private static Logger logger = Logger.getLogger(LoginServlet.class);
    private static final String LOGIN_PAGE = "/toLoginAndRegister";
    private static final String INDEX_PAGE = "/toMain";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("email");
        String password = request.getParameter("password");

//        Captcha captcha = Captcha.load(request, "loginCaptcha");
//        boolean isHuman = captcha.validate(request.getParameter("captchaCode"));
        User user = null;
        String msg = "密码错误";

//        if (isHuman) {
//            user = new UserService().login(username, password);
//        }
//        else {
//            msg = "验证码错误";
//        }

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            logger.info(user.getUserId() + "登录了");
            response.sendRedirect(INDEX_PAGE);
        }
        else {
            // May need to leave a message in request.
            logger.info(msg);
            request.setAttribute("msg", msg);
            request.getRequestDispatcher(LOGIN_PAGE).forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
