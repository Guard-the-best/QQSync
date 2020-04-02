package cn.edu.csu.dyp.archived.servlet.goodsServlet;

import cn.edu.csu.dyp.archived.model.goods.Product;
import cn.edu.csu.dyp.Service.GoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "DynamicSearchByKeyServlet")
public class DynamicSearchByKeyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String key = request.getParameter("key");
        GoodsService goodsService = new GoodsService();

        List<Product> products = goodsService.searchProductByKey(key);

        String result = "[ ";
//        String result = "";

        int maxIndex = products.size() - 1;
        int ic = 0;

        for (Product product:products) {
            result += "\"" + product.getProductName() + "\"";
//            result += product.getProductName();
            if (ic == maxIndex) {
                break;
            }
            result += ",";
            ic++;
        }
        result += " ]";

        PrintWriter out = response.getWriter();
        out.print(result);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
