package com.wjj.servlet;

import com.wjj.entity.Auction;
import com.wjj.service.AuctionService;
import com.wjj.service.impl.AuctionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ToUpdateServlet")
public class ToUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        AuctionService service = new AuctionServiceImpl();
        Auction auction = service.findByID(Integer.parseInt(id));
        request.getSession().setAttribute("auction",auction);
        response.sendRedirect("update.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
