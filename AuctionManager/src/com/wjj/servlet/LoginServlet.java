package com.wjj.servlet;

import com.alibaba.fastjson.JSONArray;
import com.wjj.entity.AuctionUser;
import com.wjj.service.AuctionUserService;
import com.wjj.service.impl.AuctionUserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        AuctionUser user = new AuctionUser();
        user.setUserName(username);
        user.setUserPassword(password);
        AuctionUserService service = new AuctionUserServiceImpl();
        AuctionUser auctionUser = service.checkLogin(user);
        Map<String,Object> map = new HashMap<>();
        if (auctionUser==null){
            map.put("isexist",0);
            map.put("msg","用户名错误！");
        }else {
            if (auctionUser.getUserPassword().equals(password)){
                map.put("isexist",1);
            }else {
                map.put("isexist",0);
                map.put("msg","密码错误！");
            }
        }
        response.getWriter().print(JSONArray.toJSONString(map));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
