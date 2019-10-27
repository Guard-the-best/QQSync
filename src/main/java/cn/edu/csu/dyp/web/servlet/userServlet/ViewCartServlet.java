package cn.edu.csu.dyp.web.servlet.userServlet;

import cn.edu.csu.dyp.model.user.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ToCartServlet")
public class ViewCartServlet extends HttpServlet {
    private static final String CART_PAGE = "WEB-INF/jsp/AfterLogin/cart.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        // 根据user相关属性搜索购物车并setAttribute

        request.getRequestDispatcher(CART_PAGE);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
