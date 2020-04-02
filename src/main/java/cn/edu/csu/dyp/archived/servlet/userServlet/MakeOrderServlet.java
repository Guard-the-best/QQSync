package cn.edu.csu.dyp.archived.servlet.userServlet;

import cn.edu.csu.dyp.archived.model.user.Address;
import cn.edu.csu.dyp.archived.model.user.LineItem;
import cn.edu.csu.dyp.archived.model.user.Order;
import cn.edu.csu.dyp.archived.model.user.User;
import cn.edu.csu.dyp.Service.CartService;
import cn.edu.csu.dyp.Service.OrderService;
import cn.edu.csu.dyp.Service.UserService;
import cn.edu.csu.dyp.Service.util.OrderStat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet(name = "MakeOrderServlet")
public class MakeOrderServlet extends HttpServlet {
    private static final String CONFIRM_PAGE = "WEB-INF/jsp/AfterLogin/confirmedProductInfo.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserService userService = new UserService();
        User user = (User)session.getAttribute("user");

        String name = request.getParameter("Name2");
        String detailAddress = request.getParameter("Address2");
        String phoneNumber = request.getParameter("PhoneNumber2");
        String city = request.getParameter("City2");
        String state = request.getParameter("State2");
        String country = request.getParameter("Country2");

        Address address = new Address(name, phoneNumber, state, city, country, "nameless", detailAddress);
        userService.setAddress(user.getUserId(), address);

        List<LineItem> cart = new CartService().getCart(user.getUserId());

        boolean ifSucceed = new OrderService().makeOrder(user.getUserId(), address.toString(), address.toString(), cart);

        Order order = new Order(null, user.getUserId(), new Date(), address.toString(), address.toString(), OrderStat.Success, cart);
        request.setAttribute("order", order);
        request.setAttribute("Address", address);

        request.getRequestDispatcher(CONFIRM_PAGE).forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
