package cn.edu.csu.dyp.archived.servlet.userServlet;

import cn.edu.csu.dyp.archived.model.goods.Category;
import cn.edu.csu.dyp.archived.model.goods.Product;
import cn.edu.csu.dyp.archived.model.order.Cart;
import cn.edu.csu.dyp.archived.model.user.LineItem;
import cn.edu.csu.dyp.archived.model.user.User;
import cn.edu.csu.dyp.archived.service.CartService;
import cn.edu.csu.dyp.archived.service.GoodsService;

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

@WebServlet(name = "ViewCartServlet")
public class ViewCartServlet extends HttpServlet {
    private static final String CART_PAGE = "WEB-INF/jsp/AfterLogin/cart.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        // 根据user相关属性搜索购物车并setAttribute
        CartService cartService = new CartService();
        List<LineItem> cart = cartService.getCart(user.getUserId());
        List<Cart> shownCart = new ArrayList<>();

        BigDecimal price = new BigDecimal(0);
        for(LineItem lineItem:cart) {
            Product product = new GoodsService().getProductById(lineItem.getItem().getProductId());
            Category category = new GoodsService().getCategoryById(product.getCategoryId());
            shownCart.add(new Cart(lineItem.getItem().getItemId(),product.getProductName(),category.getCategoryName(),lineItem.getItem().getListPrice(),lineItem.getQuantity()));
            price = price.add(lineItem.getItem().getListPrice().multiply(new BigDecimal(lineItem.getQuantity())));
        }
        request.setAttribute("lineItems", shownCart);
        request.setAttribute("cartLength", shownCart.size());
        request.setAttribute("totalPrice", price);

        request.getRequestDispatcher(CART_PAGE).forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
