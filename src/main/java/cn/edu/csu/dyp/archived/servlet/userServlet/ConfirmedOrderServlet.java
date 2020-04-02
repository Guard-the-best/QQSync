package cn.edu.csu.dyp.archived.servlet.userServlet;

import cn.edu.csu.dyp.archived.model.user.Address;
import cn.edu.csu.dyp.archived.model.user.User;
import cn.edu.csu.dyp.Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ConfirmedOrderServlet")
public class ConfirmedOrderServlet extends HttpServlet {

    private static final String CONFIRM_ORDER_PAGE = "/WEB-INF/jsp/AfterLogin/confirmProductInfo.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserService userService = new UserService();
        User user = (User)session.getAttribute("user");
        Address address = userService.getAddress(user.getUserId());


        request.getRequestDispatcher(CONFIRM_ORDER_PAGE).forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
