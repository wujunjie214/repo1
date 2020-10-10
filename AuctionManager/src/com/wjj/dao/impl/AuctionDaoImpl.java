package com.wjj.dao.impl;

import com.wjj.dao.AuctionDao;
import com.wjj.entity.Auction;
import com.wjj.tool.BaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuctionDaoImpl extends BaseDao implements AuctionDao {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    @Override
    public List<Auction> findByCondition(String auctionName, String auctionDesc, Integer pageIndex, Integer pageSize) {
        List<Auction> list = new ArrayList<>();
        String sql = "select * from auction where 1=1";
        if (auctionName!=null && auctionName!=""){
            sql += " and auctionName like '%"+auctionName+"%'";
        }
        if (auctionDesc!=null && auctionDesc!=""){
            sql += " and auctionDesc like '%"+auctionDesc+"%'";
        }
        sql += " limit ?,?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,(pageIndex-1)*pageSize);
            ps.setInt(2,pageSize);
            rs = ps.executeQuery();
            while (rs.next()){
                Auction auction = new Auction();
                auction.setAuctionId(rs.getInt("auctionId"));
                auction.setAuctionName(rs.getString("AuctionName"));
                auction.setAuctionDesc(rs.getString("auctionDesc"));
                auction.setAuctionStartTime(rs.getString("AuctionStartTime"));
                auction.setAuctionEndTime(rs.getString("AuctionEndTime"));
                auction.setAuctionStartPrice(rs.getInt("AuctionStartPrice"));
                list.add(auction);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll(conn,ps,rs);
        }
        return list;
    }

    @Override
    public Auction findByID(Integer id) {
        Auction auction = new Auction();
        try {
            conn = getConnection();
            ps = conn.prepareStatement("select * from auction where auctionId=?");
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while (rs.next()){
                auction.setAuctionId(id);
                auction.setAuctionName(rs.getString("AuctionName"));
                auction.setAuctionStartPrice(rs.getInt("AuctionStartPrice"));
                auction.setAuctionEndTime(rs.getString("AuctionEndTime"));
                auction.setAuctionStartTime(rs.getString("AuctionStartTime"));
                auction.setAuctionDesc(rs.getString("AuctionDesc"));
                auction.setAuctionPic(rs.getString("AuctionPic"));
                auction.setAuctionPicType(rs.getString("AuctionPicType"));
                auction.setAuctionUpset(rs.getInt("AuctionUpset"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll(conn,ps,rs);
        }
        return auction;
    }

    @Override
    public int getPageCount(String auctionName, String auctionDesc){
        int result = 0;
        String sql = "select count(*) from auction where 1=1";
        if (auctionName!=null && auctionName!=""){
            sql += " and auctionName like '%"+auctionName+"%'";
        }
        if (auctionDesc!=null && auctionDesc!=""){
            sql += " and auctionDesc like '%"+auctionDesc+"%'";
        }
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                result = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll(conn,ps,rs);
        }
        return result;
    }

    @Override
    public int add(Auction auction) {
        int result = 0;
        String sql = "insert into auction values(0,?,?,?,?,?,?,?,?)";
        Object[] params = {auction.getAuctionName(),auction.getAuctionStartPrice(),auction.getAuctionUpset(),auction.getAuctionStartTime(),auction.getAuctionEndTime(),auction.getAuctionPic(),auction.getAuctionPicType(),auction.getAuctionDesc()};
        try {
            result = executeUpdate(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int update(Auction auction) {
        int result = 0;
        String sql = "update auction set AuctionName=?,AuctionStartPrice=?,AuctionUpset=?,AuctionStartTime=?,AuctionEndTime=?,AuctionPic=?,AuctionPicType=?,AuctionDesc=? where auctionId=?";
        Object[] params = {auction.getAuctionName(),auction.getAuctionStartPrice(),auction.getAuctionUpset(),auction.getAuctionStartTime(),auction.getAuctionEndTime(),auction.getAuctionPic(),auction.getAuctionPicType(),auction.getAuctionDesc(),auction.getAuctionId()};
        try {
            result = executeUpdate(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int delete(Integer id) {
        int result = 0;
        String sql = "delete from auction where auctionId=?";
        Object[] params = {id};
        try {
            result = executeUpdate(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
