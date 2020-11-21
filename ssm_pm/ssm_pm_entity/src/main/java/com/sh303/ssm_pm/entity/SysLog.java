package com.sh303.ssm_pm.entity;

import com.sh303.ssm_pm.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class SysLog {

    private int id;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date visitTime;
    private String visitTimeStr;

    public String getVisitTimeStr() {
        if(visitTime != null){
            visitTimeStr = DateUtils.date2String(visitTime, "yyyy-MM-dd HH:mm:ss");
        }
        return visitTimeStr;
    }

    public void setVisitTimeStr(String visitTimeStr) {
        this.visitTimeStr = visitTimeStr;
    }

    private String username;
    private String ip;
    private String url;
    private long executionTime;
    private String method;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(long executionTime) {
        this.executionTime = executionTime;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
