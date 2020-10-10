package com.wjj.service.impl;

import com.wjj.dao.AuctionUserDao;
import com.wjj.dao.impl.AuctionUserDaoImpl;
import com.wjj.entity.AuctionUser;
import com.wjj.service.AuctionUserService;

public class AuctionUserServiceImpl implements AuctionUserService {
    AuctionUserDao dao = new AuctionUserDaoImpl();
    @Override
    public AuctionUser checkLogin(AuctionUser auctionUser) {
        return dao.checkLogin(auctionUser);
    }

    @Override
    public int addUser(AuctionUser auctionUser) {
        return dao.addUser(auctionUser);
    }
}
