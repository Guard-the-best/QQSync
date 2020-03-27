package cn.edu.csu.dyp.archived.servlet.goodsServlet;

import cn.edu.csu.dyp.archived.model.goods.Product;
import cn.edu.csu.dyp.archived.service.GoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchProductByKeyServlet")
public class SearchProductByKeyServlet extends HttpServlet {
    private static final String CATEGORY_PAGE = "";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GoodsService goodsService = new GoodsService();
        HttpSession session = request.getSession();
        String key = request.getParameter("key");

        List<Product> productList = goodsService.searchProductByKey(key);

        session.setAttribute("productList", productList);
        response.sendRedirect(CATEGORY_PAGE);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
