package com.wjj.dao.impl;

import com.wjj.dao.AuctionUserDao;
import com.wjj.entity.AuctionUser;
import com.wjj.tool.BaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuctionUserDaoImpl extends BaseDao implements AuctionUserDao{

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    @Override
    public AuctionUser checkLogin(AuctionUser auctionUser) {
        AuctionUser user = null;
        conn = getConnection();
        try {
            ps = conn.prepareStatement("select * from auctionuser where userName=?");
            ps.setString(1,auctionUser.getUserName());
            rs = ps.executeQuery();
            while (rs.next()){
                user = new AuctionUser();
                String password = rs.getString("userpassword");
                user.setUserPassword(password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll(conn,ps,rs);
        }
        return user;
    }

    @Override
    public int addUser(AuctionUser auctionUser) {
        int result = 0;
        String sql = "insert into auctionuser values(0,?,?,?,?,?,?)";
        Object[] params = {auctionUser.getUserName(),auctionUser.getUserPassword(),auctionUser.getUserCardNo(),auctionUser.getUserTel(),auctionUser.getUserAddress(),auctionUser.getUserPostNumber()};
        try {
            result = executeUpdate(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
