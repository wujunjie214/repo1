package com.wjj.service.impl;

import com.wjj.dao.AuctionDao;
import com.wjj.dao.impl.AuctionDaoImpl;
import com.wjj.entity.Auction;
import com.wjj.service.AuctionService;

import java.util.List;

public class AuctionServiceImpl implements AuctionService {
    AuctionDao dao = new AuctionDaoImpl();
    @Override
    public List<Auction> findByCondition(String auctionName, String auctionDesc, Integer pageIndex, Integer pageSize) {
        return dao.findByCondition(auctionName,auctionDesc,pageIndex,pageSize);
    }

    @Override
    public Auction findByID(Integer id) {
        return dao.findByID(id);
    }

    @Override
    public int getPageCount(String auctionName, String auctionDesc) {
        return dao.getPageCount(auctionName,auctionDesc);
    }

    @Override
    public int add(Auction auction) {
        return dao.add(auction);
    }

    @Override
    public int update(Auction auction) {
        return dao.update(auction);
    }

    @Override
    public int delete(Integer id) {
        return dao.delete(id);
    }
}
