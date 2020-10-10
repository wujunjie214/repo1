package com.wjj.entity;

public class Auction {
    private Integer auctionId;
    private String auctionName;
    private Integer auctionStartPrice;
    private Integer auctionUpset;
    private String auctionStartTime;
    private String auctionEndTime;
    private String auctionPic;
    private String auctionPicType;
    private String auctionDesc;

    public Auction(){}
    public Auction(Integer auctionId, String auctionName, Integer auctionStartPrice, Integer auctionUpset, String auctionStartTime, String auctionEndTime, String auctionPic, String auctionPicType, String auctionDesc) {
        this.auctionId = auctionId;
        this.auctionName = auctionName;
        this.auctionStartPrice = auctionStartPrice;
        this.auctionUpset = auctionUpset;
        this.auctionStartTime = auctionStartTime;
        this.auctionEndTime = auctionEndTime;
        this.auctionPic = auctionPic;
        this.auctionPicType = auctionPicType;
        this.auctionDesc = auctionDesc;
    }

    public Integer getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(Integer auctionId) {
        this.auctionId = auctionId;
    }

    public String getAuctionName() {
        return auctionName;
    }

    public void setAuctionName(String auctionName) {
        this.auctionName = auctionName;
    }

    public Integer getAuctionStartPrice() {
        return auctionStartPrice;
    }

    public void setAuctionStartPrice(Integer auctionStartPrice) {
        this.auctionStartPrice = auctionStartPrice;
    }

    public Integer getAuctionUpset() {
        return auctionUpset;
    }

    public void setAuctionUpset(Integer auctionUpset) {
        this.auctionUpset = auctionUpset;
    }

    public String getAuctionStartTime() {
        return auctionStartTime;
    }

    public void setAuctionStartTime(String auctionStartTime) {
        this.auctionStartTime = auctionStartTime;
    }

    public String getAuctionEndTime() {
        return auctionEndTime;
    }

    public void setAuctionEndTime(String auctionEndTime) {
        this.auctionEndTime = auctionEndTime;
    }

    public String getAuctionPic() {
        return auctionPic;
    }

    public void setAuctionPic(String auctionPic) {
        this.auctionPic = auctionPic;
    }

    public String getAuctionPicType() {
        return auctionPicType;
    }

    public void setAuctionPicType(String auctionPicType) {
        this.auctionPicType = auctionPicType;
    }

    public String getAuctionDesc() {
        return auctionDesc;
    }

    public void setAuctionDesc(String auctionDesc) {
        this.auctionDesc = auctionDesc;
    }
}
