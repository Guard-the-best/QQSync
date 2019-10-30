package cn.edu.csu.dyp.web.servlet.userServlet;

import cn.edu.csu.dyp.model.user.Address;
import cn.edu.csu.dyp.model.user.LineItem;
import cn.edu.csu.dyp.model.user.Order;
import cn.edu.csu.dyp.model.user.User;
import cn.edu.csu.dyp.service.CartService;
import cn.edu.csu.dyp.service.OrderService;
import cn.edu.csu.dyp.service.UserService;
import cn.edu.csu.dyp.service.util.OrderStat;
import com.sun.org.apache.xpath.internal.operations.Or;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

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
