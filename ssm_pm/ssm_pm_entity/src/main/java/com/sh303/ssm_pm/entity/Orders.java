package com.sh303.ssm_pm.entity;

import com.sh303.ssm_pm.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * 订单实体类
 */
public class Orders {

    private String id;              // 主键
    private String orderNum;        // 编号
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date orderTime;         // 下单时间
    private String orderTimeStr;
    private int peopleCount;        // 订单人数
    private String orderDesc;       // 订单描述
    private Integer payType;            // 支付方式 0:支付宝   1:微信
    private String payTypeStr;
    private Integer orderStatus;        // 订单状态 0:未支付   1:已支付
    private String orderStatusStr;
    private Product product;                // 产品信息
    private List<Traveller> travellerList;  // 旅客信息
    private Member member;                  // 会员信息

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderTimeStr() {
        if (this.orderTime != null) {
            this.orderTimeStr = DateUtils.date2String(this.orderTime, "yyyy-MM-dd HH:mm:ss");
        }
        return orderTimeStr;
    }

    public void setOrderTimeStr(String orderTimeStr) {
        this.orderTimeStr = orderTimeStr;
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(int peopleCount) {
        this.peopleCount = peopleCount;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getPayTypeStr() {
        if (this.payType != null) {
            if (this.payType == 0) {
                this.payTypeStr = "支付宝";
            }
            if (this.payType == 1) {
                this.payTypeStr = "微信";
            }
            if (this.payType == 2) {
                this.payTypeStr = "其它";
            }
        }
        return payTypeStr;
    }

    public void setPayTypeStr(String payTypeStr) {
        this.payTypeStr = payTypeStr;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderStatusStr() {
        if (this.orderStatus != null) {
            if (this.orderStatus == 0) {
                this.orderStatusStr = "未支付";
            }
            if (this.orderStatus == 1) {
                this.orderStatusStr = "已支付";
            }
        }
        return orderStatusStr;
    }

    public void setOrderStatusStr(String orderStatusStr) {
        this.orderStatusStr = orderStatusStr;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Traveller> getTravellerList() {
        return travellerList;
    }

    public void setTravellerList(List<Traveller> travellerList) {
        this.travellerList = travellerList;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
