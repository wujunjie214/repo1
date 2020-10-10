package com.wjj.dao;

import com.wjj.entity.AuctionUser;

public interface AuctionUserDao {
    public AuctionUser checkLogin(AuctionUser auctionUser);
    public int addUser(AuctionUser auctionUser);
}
