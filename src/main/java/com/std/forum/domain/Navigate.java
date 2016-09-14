package com.std.forum.domain;

import com.std.forum.dao.base.ABaseDO;

/**
 * 导航
 * @author: xieyj 
 * @since: 2016年9月14日 下午3:30:01 
 * @history:
 */
public class Navigate extends ABaseDO {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 访问Url
    private String url;

    // 图片
    private String pic;

    // 标题
    private String title;

    // 状态(1 显示 0 不显示)
    private String status;

    // 类型(1 菜单 2 banner 3 模块 4 引流)
    private String type;

    // 是否全局(1 是 0 否)
    private String isGlobal;

    // 相对位置编号
    private int orderNo;

    // 父编号
    private String parentCode;

    // 站点编号
    private String siteCode;

    // 备注
    private String remark;

    // ********** db properties ***********

    private String titleForQuery;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIsGlobal() {
        return isGlobal;
    }

    public void setIsGlobal(String isGlobal) {
        this.isGlobal = isGlobal;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getSiteCode() {
        return siteCode;
    }

    public void setSiteCode(String siteCode) {
        this.siteCode = siteCode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTitleForQuery() {
        return titleForQuery;
    }

    public void setTitleForQuery(String titleForQuery) {
        this.titleForQuery = titleForQuery;
    }
}
