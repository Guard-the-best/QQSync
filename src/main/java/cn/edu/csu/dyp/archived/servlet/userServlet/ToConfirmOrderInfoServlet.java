package cn.edu.csu.dyp.archived.servlet.userServlet;

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
        request.getRequestDispatcher(CONFIRM_ORDER_PAGE).forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
