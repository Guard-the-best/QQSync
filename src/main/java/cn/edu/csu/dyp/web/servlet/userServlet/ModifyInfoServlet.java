package cn.edu.csu.dyp.web.servlet.userServlet;

import cn.edu.csu.dyp.model.user.Address;
import cn.edu.csu.dyp.model.user.User;
import cn.edu.csu.dyp.service.UserService;
import cn.edu.csu.dyp.service.util.ModifyInfoStat;
import javafx.util.Pair;

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
    private static final String CONFIRM_INFO_PAGE = "/WEB-INF/jsp/AfterLogin/confirmedPersonInfo.jsp";
    private static final String MODIFY_INFO_PAGE = "/WEB-INF/jsp/AfterLogin/personalInfo.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserService userService = new UserService();
        User user = (User) session.getAttribute("user");
        String userId = (user.getUserId());
        String username = (user.getUsername());
        String password = request.getParameter("passWord2");
        String phoneNumber = request.getParameter("PhoneNumber");
        String nickname = request.getParameter("NickName");

        String detailAddress = request.getParameter("Address");
        String name = request.getParameter("Name");
        String city = request.getParameter("City");
        String state = request.getParameter("State");
        String county = request.getParameter("Country");

        Address address = new Address(name, phoneNumber, state, city, county, "nameless", detailAddress);

        // ModifyInfoStat modifyInfoStat = new UserService().modifyInfo(new User(userId, username, password, phoneNumber, nickname));
        Pair<User, ModifyInfoStat> pair = userService.modifyInfo(new User(userId, username, password, phoneNumber, nickname));

        if (pair.getKey() != null) {
            userService.setAddress(userId, address);

            request.setAttribute("status", pair.getValue().toString());
            session.setAttribute("user", pair.getKey());
            request.setAttribute("address", address);
            request.getRequestDispatcher(CONFIRM_INFO_PAGE).forward(request, response);
        }
        else if (pair.getValue() == ModifyInfoStat.NothingChanged) {
            address = userService.getAddress(userId);
            request.setAttribute("address", address);
            request.setAttribute("msg", "Nothing Changed");
            request.getRequestDispatcher(CONFIRM_INFO_PAGE).forward(request, response);
        }
        else {
            address = userService.getAddress(userId);
            request.setAttribute("address", address);
            request.setAttribute("msg", "wrongPassword");
            request.getRequestDispatcher(MODIFY_INFO_PAGE).forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
