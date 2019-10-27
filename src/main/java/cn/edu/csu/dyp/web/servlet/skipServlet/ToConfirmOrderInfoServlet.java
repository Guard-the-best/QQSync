package cn.edu.csu.dyp.web.servlet.skipServlet;

import cn.edu.csu.dyp.model.user.Order;
import cn.edu.csu.dyp.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ToConfirmOrderServlet")
public class ToConfirmOrderInfoServlet extends HttpServlet {
    private static final String CONFIRM_ORDER_PAGE = "/WEB-INF/jsp/AfterLogin/confirmProductInfo.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderId = request.getParameter("orderId");
        OrderService orderService = new OrderService();

        Order order = orderService.getOrder(orderId);
        request.setAttribute("order", order);

        // 此处获得一个lineItem的List并加入request中

        request.getRequestDispatcher(CONFIRM_ORDER_PAGE).forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
