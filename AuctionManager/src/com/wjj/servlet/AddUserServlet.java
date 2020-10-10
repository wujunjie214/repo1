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

@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AuctionUser user = new AuctionUser();
        user.setUserName(request.getParameter("userName"));
        user.setUserPassword(request.getParameter("userPassword"));
        user.setUserCardNo(request.getParameter("userCardNo"));
        user.setUserTel(request.getParameter("userTel"));
        user.setUserAddress(request.getParameter("userAddress"));
        user.setUserPostNumber(request.getParameter("userPostNumber"));
        AuctionUserService service = new AuctionUserServiceImpl();
        Map<String,Object> map = new HashMap<>();
        int result = service.addUser(user);
        if (result==1){
            map.put("status",1);
            map.put("msg","添加成功！");
        }else {
            map.put("status",0);
            map.put("msg","添加失败！");
        }
        response.getWriter().print(JSONArray.toJSONString(map));

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
