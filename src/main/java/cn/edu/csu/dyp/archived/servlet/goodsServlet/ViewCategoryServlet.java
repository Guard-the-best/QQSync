package cn.edu.csu.dyp.archived.servlet.goodsServlet;

import cn.edu.csu.dyp.archived.model.goods.Category;
import cn.edu.csu.dyp.archived.model.goods.Product;
import cn.edu.csu.dyp.Service.GoodsService;

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
    private static final String CATEGORY_PAGE = "/WEB-INF/jsp/AfterLogin/animal.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GoodsService goodsService = new GoodsService();
        String categoryId = request.getParameter("categoryId");
        System.out.println(categoryId);
        HttpSession session = request.getSession();
        Category category = goodsService.getCategoryById(categoryId);
        List<Product> productList= goodsService.getProductsByCategory(category.getCategoryName());

        System.out.println(productList.toString());
//        System.out.println(productList.get(0).getProductName());

        request.setAttribute("category", category);
        request.setAttribute("productList", productList);

        request.getRequestDispatcher(CATEGORY_PAGE).forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
