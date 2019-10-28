package cn.edu.csu.dyp.web.servlet.goodsServlet;

import cn.edu.csu.dyp.model.goods.Product;
import cn.edu.csu.dyp.service.GoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchByKeyServlet")
public class SearchByKeyServlet extends HttpServlet {
    private static final String PRODUCT_PAGE = "/WEB-INF/jsp/AfterLogin/animal.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String key = request.getParameter("key");
        GoodsService goodsService = new GoodsService();

        List<Product> products = goodsService.searchProductByKey(key);
        request.setAttribute("productLength", products.size());
        request.setAttribute("product", products);

        request.getRequestDispatcher(PRODUCT_PAGE).forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
