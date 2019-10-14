package cn.edu.csu.dyp.web.servlet;

import cn.edu.csu.dyp.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Main extends HttpServlet {
    private static String defaultPage="/WEB-INF/jsp/index.jsp";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Cookie[] cookies= req.getCookies();
//        for(Cookie cookie:cookies){
//            if(cookie.getName().equals("")){
//                req.setAttribute("",cookie.getValue());
//                Cookie newCookie = new Cookie("","");
//                newCookie.setMaxAge(0);
//                resp.addCookie(newCookie);
//            }
//        }
        req.setAttribute("User",new User(null,"admin",null,null,"Jake"));
        req.getRequestDispatcher(defaultPage).forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
