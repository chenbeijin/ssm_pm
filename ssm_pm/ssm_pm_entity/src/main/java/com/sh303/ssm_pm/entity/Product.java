package com.sh303.ssm_pm.entity;

import com.sh303.ssm_pm.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 产品实体类
 */

public class Product {
    private String id;              // 主键
    private String productNum;      // 编号 唯一
    private String productName;     // 名称
    private String cityName;        // 出发城市
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date departureTime;     // 出发时间
    private String departureTimeStr;
    private Double productPrice;    // 产品价格
    private String productDesc;     // 产品描述
    private Integer productStatus;  // 产品状态 0 关闭  1 开启
    private String productStatusStr;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public String getDepartureTimeStr() {
        if (this.departureTime != null) {
            this.departureTimeStr = DateUtils.date2String(this.departureTime, "yyyy-MM-dd HH:mm:ss");
        }
        return this.departureTimeStr;
    }

    public void setDepartureTimeStr(String departureTimeStr) {
        this.departureTimeStr = departureTimeStr;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public String getProductStatusStr() {
        if (this.productStatus != null) {
            if (this.productStatus == 0) {
                this.productStatusStr = "关闭";
            }
            if (this.productStatus == 1) {
                this.productStatusStr = "开启";
            }
        }
        return this.productStatusStr;
    }

    public void setProductStatusStr(String productStatusStr) {
        this.productStatusStr = productStatusStr;
    }
}
