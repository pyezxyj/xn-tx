package com.std.forum.api.impl;

import com.std.forum.ao.ISiteAO;
import com.std.forum.api.AProcessor;
import com.std.forum.api.converter.SiteConverter;
import com.std.forum.common.JsonUtil;
import com.std.forum.domain.Site;
import com.std.forum.dto.req.XN610011Req;
import com.std.forum.exception.BizException;
import com.std.forum.exception.ParaException;
import com.std.forum.spring.SpringContextHolder;

/** 
 * 列表查询站点信息
 * @author: zuixian 
 * @since: 2016年9月14日 下午5:10:26 
 * @history:
 */
public class XN610011 extends AProcessor {

    private ISiteAO siteAO = SpringContextHolder.getBean(ISiteAO.class);

    private XN610011Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Site condition = SiteConverter.converter(req);
        return siteAO.querySiteList(condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN610011Req.class);
    }

}
