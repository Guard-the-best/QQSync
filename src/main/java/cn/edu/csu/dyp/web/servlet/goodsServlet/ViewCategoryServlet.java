package cn.edu.csu.dyp.web.servlet.goodsServlet;

import cn.edu.csu.dyp.model.goods.Category;
import cn.edu.csu.dyp.model.goods.Product;
import cn.edu.csu.dyp.service.GoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowCategoryServlet")
public class ViewCategoryServlet extends HttpServlet {
    private static final String CATEGORY_PAGE = "";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GoodsService goodsService = new GoodsService();
        String categoryId = request.getParameter("categoryId");
        HttpSession session = request.getSession();
        Category category = goodsService.getCategoryById(categoryId);
        List<Product> productList= goodsService.getProductsByCategory(categoryId);

        session.setAttribute("category", category);
        session.setAttribute("productList", productList);

        response.sendRedirect(CATEGORY_PAGE);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
