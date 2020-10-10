package com.wjj.servlet;

import com.wjj.entity.Auction;
import com.wjj.service.AuctionService;
import com.wjj.service.impl.AuctionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String index = request.getParameter("pageIndex");
        String name = request.getParameter("name");
        String desc = request.getParameter("desc");
        if (index==null){
            index = "1";
        }
        Integer pageIndex = Integer.parseInt(index);
        Integer pageSize = 5;
        AuctionService service = new AuctionServiceImpl();
        List<Auction> list = service.findByCondition(name, desc, pageIndex, pageSize);
        int totalPage = service.getPageCount(name, desc);
        int total;
        if (totalPage%pageSize==0){
            total = totalPage/pageSize;
        }else {
            total = totalPage/pageSize+1;
        }
        HttpSession session = request.getSession();
        session.setAttribute("list",list);
        session.setAttribute("totalPage",totalPage);
        session.setAttribute("total",total);
        session.setAttribute("pageIndex",pageIndex);
        session.setAttribute("name",name);
        session.setAttribute("desc",desc);
        response.sendRedirect("index.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
