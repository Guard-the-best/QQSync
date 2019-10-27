package cn.edu.csu.dyp.web.servlet.userServlet;

import cn.edu.csu.dyp.model.user.User;
import cn.edu.csu.dyp.service.UserService;
import cn.edu.csu.dyp.service.util.ModifyInfoStat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ModifyInfoServlet")
public class ModifyInfoServlet extends HttpServlet {
    // 需要填入
    private static final String MODIFY_INFO_PAGE = "";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String userId = ((User)session.getAttribute("user")).getUserId();
        String username = ((User)session.getAttribute("user")).getUsername();
        String password = request.getParameter("password");
        String phoneNumber = request.getParameter("phoneNumber");
        String nickname = request.getParameter("nickname");

        ModifyInfoStat modifyInfoStat = new UserService().modifyInfo(new User(userId, username, password, phoneNumber, nickname));

        request.setAttribute("status", modifyInfoStat.toString());
        request.getRequestDispatcher(MODIFY_INFO_PAGE);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
