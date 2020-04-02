package cn.edu.csu.dyp.archived.servlet.skipServlet;

import cn.edu.csu.dyp.archived.model.user.Address;
import cn.edu.csu.dyp.archived.model.user.User;
import cn.edu.csu.dyp.Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ToProductInfoServlet")
public class ToProductInfoServlet extends HttpServlet {
    private static final String PRODUCT_INFO_PAGE = "WEB-INF/jsp/AfterLogin/productInfo.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Address address = new UserService().getAddress(user.getUserId());
        if (address != null) {
            request.setAttribute("address", address);
            System.out.println(address.toString());
        }
        request.getRequestDispatcher(PRODUCT_INFO_PAGE).forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
