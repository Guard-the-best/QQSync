package cn.edu.csu.dyp.web.servlet.userServlet;

import cn.edu.csu.dyp.model.user.LineItem;
import cn.edu.csu.dyp.model.user.User;
import cn.edu.csu.dyp.service.CartService;
import cn.edu.csu.dyp.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ViewCartServlet")
public class ViewCartServlet extends HttpServlet {
    private static final String CART_PAGE = "WEB-INF/jsp/AfterLogin/cart.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        // 根据user相关属性搜索购物车并setAttribute
        CartService cartService = new CartService();
        List<LineItem> cart = cartService.getCart(user.getUserId());
        request.setAttribute("itemCart", cart);

        request.getRequestDispatcher(CART_PAGE);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
