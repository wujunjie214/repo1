package com.wjj.servlet;

import com.alibaba.fastjson.JSONArray;
import com.wjj.entity.Auction;
import com.wjj.service.AuctionService;
import com.wjj.service.impl.AuctionServiceImpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean flag = ServletFileUpload.isMultipartContent(request);
        if (flag){
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            try {
                Auction auction = new Auction();
                List<FileItem> list = upload.parseRequest(request);
                String realPath = request.getServletContext().getRealPath("images");
                for (FileItem item:list){
                    if (item.isFormField()){
                        if ("auctionId".equals(item.getFieldName())){
                            auction.setAuctionId(Integer.parseInt(item.getString()));
                        }
                        if ("auctionName".equals(item.getFieldName())){
                            auction.setAuctionName(item.getString("utf-8"));
                        }
                        if ("auctionStartPrice".equals(item.getFieldName())){
                            auction.setAuctionStartPrice(Integer.parseInt(item.getString()));
                        }
                        if ("auctionUpset".equals(item.getFieldName())){
                            auction.setAuctionUpset(Integer.parseInt(item.getString()));
                        }
                        if ("auctionStartTime".equals(item.getFieldName())){
                            auction.setAuctionStartTime(item.getString("utf-8"));
                        }
                        if ("auctionEndTime".equals(item.getFieldName())){
                            auction.setAuctionEndTime(item.getString("utf-8"));
                        }
                        if ("auctionDesc".equals(item.getFieldName())){
                            auction.setAuctionDesc(item.getString("utf-8"));
                        }
                        if ("auctionPic".equals(item.getFieldName())){
                            auction.setAuctionPic(item.getString("utf-8"));
                            auction.setAuctionPicType(item.getString("utf-8"));
                        }
                    }else {
                        String fileName = item.getName();
                        auction.setAuctionPic(fileName);
                        auction.setAuctionPicType(fileName);
                        File file = new File(realPath,fileName);
                        item.write(file);
                    }
                }
                AuctionService service = new AuctionServiceImpl();
                int result = service.update(auction);
                Map<String,Object> map = new HashMap<>();
                if (result==1){
                    map.put("status",1);
                    map.put("msg","修改成功！");
                }else {
                    map.put("status",0);
                    map.put("msg","修改失败！");
                }
                response.getWriter().print(JSONArray.toJSONString(map));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
