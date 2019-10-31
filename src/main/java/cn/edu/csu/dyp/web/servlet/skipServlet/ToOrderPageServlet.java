package cn.edu.csu.dyp.web.servlet.skipServlet;

import cn.edu.csu.dyp.model.goods.Product;
import cn.edu.csu.dyp.model.order.OrderToOutside;
import cn.edu.csu.dyp.model.user.LineItem;
import cn.edu.csu.dyp.model.user.Order;
import cn.edu.csu.dyp.model.user.User;
import cn.edu.csu.dyp.service.GoodsService;
import cn.edu.csu.dyp.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
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

        List<OrderToOutside> orderListOutside=new ArrayList<>();
        if (orderList != null) {
            orderLength = orderList.size();

            for(Order order:orderList) {
                for(LineItem lineItem:order.getLineItemList()) {
                    Product product = new GoodsService().getProductById(lineItem.getItem().getProductId());
                    orderListOutside.add(new OrderToOutside(order.getOrderId(),product.getProductName(),lineItem.getQuantity(),order.getOrderDate(),lineItem.getItem().getListPrice().multiply(new BigDecimal(lineItem.getQuantity())),order.getShipAddress()));
                }
            }
        }

        System.out.println(orderLength);

        request.setAttribute("orderList", orderListOutside);
        request.setAttribute("orderLength", orderLength);

        request.getRequestDispatcher(ORDER_PAGE).forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
