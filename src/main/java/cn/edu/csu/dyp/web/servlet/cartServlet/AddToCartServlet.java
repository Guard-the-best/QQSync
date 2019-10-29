package cn.edu.csu.dyp.web.servlet.cartServlet;

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

@WebServlet(name = "AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String itemId = request.getParameter("itemId");
        CartService cartService = new CartService();
        PrintWriter out = response.getWriter();
        System.out.println(itemId);

        cartService.addToCart(user.getUserId(), itemId);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
