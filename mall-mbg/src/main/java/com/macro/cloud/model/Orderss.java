package com.macro.cloud.model;

import java.io.Serializable;
import java.util.Date;

public class Orderss implements Serializable {
    private Long orderid;

    private String orderno;

    private Integer userid;

    private Integer status;

    private String comment;

    private Date createtime;

    private Date updatetime;

    private Boolean vaild;

    private static final long serialVersionUID = 1L;

    public Long getOrderid() {
        return orderid;
    }

    public void setOrderid(Long orderid) {
        this.orderid = orderid;
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Boolean getVaild() {
        return vaild;
    }

    public void setVaild(Boolean vaild) {
        this.vaild = vaild;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orderid=").append(orderid);
        sb.append(", orderno=").append(orderno);
        sb.append(", userid=").append(userid);
        sb.append(", status=").append(status);
        sb.append(", comment=").append(comment);
        sb.append(", createtime=").append(createtime);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", vaild=").append(vaild);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}