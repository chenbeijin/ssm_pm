package com.sh303.ssm_pm.entity;

/**
 * 旅客实体类
 */
public class Traveller {

    private String id;              // 编号
    private String name;            // 姓名
    private String sex;             // 性别
    private String phoneNum;        // 手机号
    private Integer credentialsType;    // 证件类型 0 身份证 1 护照 2 军官证
    private String credentialsTypeStr;
    private String credentialsNum;
    private Integer travellerType;      // 旅客类型（人群）0 成人 1 儿童
    private String travellerTypeStr;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Integer getCredentialsType() {
        return credentialsType;
    }

    public void setCredentialsType(Integer credentialsType) {
        this.credentialsType = credentialsType;
    }

    public String getCredentialsTypeStr() {
        if (this.credentialsType != null) {
            if (this.credentialsType == 0) {
                this.credentialsTypeStr = "身份证";
            }
            if (this.credentialsType == 1) {
                this.credentialsTypeStr = "护照";
            }
            if (this.credentialsType == 2) {
                this.credentialsTypeStr = "军官证";
            }
        }
        return credentialsTypeStr;
    }

    public void setCredentialsTypeStr(String credentialsTypeStr) {
        this.credentialsTypeStr = credentialsTypeStr;
    }

    public String getCredentialsNum() {
        return credentialsNum;
    }

    public void setCredentialsNum(String credentialsNum) {
        this.credentialsNum = credentialsNum;
    }

    public Integer getTravellerType() {
        return travellerType;
    }

    public void setTravellerType(Integer travellerType) {
        this.travellerType = travellerType;
    }

    public String getTravellerTypeStr() {
        if (this.travellerType != null) {
            if(this.travellerType == 0){
                this.travellerTypeStr = "成人";
            }
            if(this.travellerType == 1){
                this.travellerTypeStr = "儿童";
            }
        }
        return travellerTypeStr;
    }

    public void setTravellerTypeStr(String travellerTypeStr) {
        this.travellerTypeStr = travellerTypeStr;
    }
}
