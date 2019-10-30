package cn.edu.csu.dyp.web.servlet.goodsServlet;

import cn.edu.csu.dyp.model.goods.Product;
import cn.edu.csu.dyp.service.GoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

@WebServlet(name = "DynamicSearchByKeyServlet")
public class DynamicSearchByKeyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String key = request.getParameter("key");
        GoodsService goodsService = new GoodsService();

        List<Product> products = goodsService.searchProductByKey(key);

        PrintWriter out = response.getWriter();
        if (products.size() > 0) {
        out.print(products.get(0).getProductName());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
