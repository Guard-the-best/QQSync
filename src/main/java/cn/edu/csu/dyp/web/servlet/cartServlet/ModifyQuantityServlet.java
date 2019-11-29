package cn.edu.csu.dyp.web.servlet.cartServlet;

import cn.edu.csu.dyp.model.user.LineItem;
import cn.edu.csu.dyp.model.user.User;
import cn.edu.csu.dyp.service.CartService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;

@WebServlet(name = "ModifyQuantityServlet")
public class ModifyQuantityServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        CartService cartService = new CartService();
        List<LineItem> cart = cartService.getCart(user.getUserId());

        BigDecimal price = new BigDecimal(0);
        for (int i = 0; i < cart.size(); i++) {
            LineItem cartItem = cart.get(i);
            int newQuantity = Integer.parseInt(request.getParameter(cartItem.getItem().getItemId()));
            cartService.changeNumber(user.getUserId(), cartItem.getItem().getItemId(), newQuantity);
            price = price.add(cartItem.getItem().getListPrice().multiply(new BigDecimal(newQuantity)) );
        }

        PrintWriter out = response.getWriter();
        out.print(price.toPlainString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
