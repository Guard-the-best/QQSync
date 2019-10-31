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

@WebServlet(name = "RemoveFormCartServlet")
public class RemoveFormCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String itemId = request.getParameter("delId");
        CartService cartService = new CartService();
        cartService.removeItem(user.getUserId(), itemId);

        request.getRequestDispatcher("/toCart").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
