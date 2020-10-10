package com.wjj.service;

import com.wjj.entity.AuctionUser;

public interface AuctionUserService {
    public AuctionUser checkLogin(AuctionUser auctionUser);
    public int addUser(AuctionUser auctionUser);
}
