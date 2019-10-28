package cn.edu.csu.dyp.web.servlet.skipServlet;

import cn.edu.csu.dyp.model.user.Order;
import cn.edu.csu.dyp.model.user.User;
import cn.edu.csu.dyp.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ToCheckOrderServlet")
public class ToOrderPageServlet extends HttpServlet {
    private static final String ORDER_PAGE = "WEB-INF/jsp/AfterLogin/orderItem.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        OrderService orderService = new OrderService();
        User user = (User)session.getAttribute("user");

        List<Order> orderList = orderService.getOrderByUser(user.getUserId());
        int orderLength = 0;

        if (orderList != null) {
            orderLength = orderList.size();
        }

        System.out.println(orderLength);

//        request.setAttribute("order", orderList);
        request.setAttribute("orderLength", orderLength);

        request.getRequestDispatcher(ORDER_PAGE).forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
