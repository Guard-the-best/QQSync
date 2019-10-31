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
import java.util.List;

@WebServlet(name = "GetCartLengthServlet")
public class GetCartLengthServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        CartService cartService = new CartService();

        int length = cartService.getNumber(user.getUserId());

        PrintWriter out = response.getWriter();
        out.print(length);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
