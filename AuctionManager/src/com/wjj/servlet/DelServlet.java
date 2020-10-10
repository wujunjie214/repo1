package com.wjj.servlet;

import com.wjj.service.AuctionService;
import com.wjj.service.impl.AuctionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DelServlet")
public class DelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        AuctionService service = new AuctionServiceImpl();
        int result = service.delete(Integer.parseInt(id));
        if(result==1){
            response.getWriter().print("{\"msg\":\"删除成功！\"}");
        }else {
            response.getWriter().print("{\"msg\":\"删除失败！\"}");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
