package com.wjj.dao;

import com.wjj.entity.Auction;

import java.util.List;

public interface AuctionDao {
    public List<Auction> findByCondition(String auctionName,String auctionDesc,Integer pageIndex,Integer pageSize);
    public Auction findByID(Integer id);
    public int getPageCount(String auctionName,String auctionDesc);
    public int add(Auction auction);
    public int update(Auction auction);
    public int delete(Integer id);
}
