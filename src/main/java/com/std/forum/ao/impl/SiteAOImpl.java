/**
 * @Title SiteAOImpl.java 
 * @Package com.std.forum.ao.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年8月29日 下午2:03:31 
 * @version V1.0   
 */
package com.std.forum.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.std.forum.ao.ISiteAO;
import com.std.forum.bo.ISiteBO;
import com.std.forum.bo.base.Paginable;
import com.std.forum.domain.Site;

/** 
 * @author: xieyj 
 * @since: 2016年8月29日 下午2:03:31 
 * @history:
 */
@Service
public class SiteAOImpl implements ISiteAO {
    @Autowired
    protected ISiteBO siteBO;

    /** 
     * @see com.std.forum.ao.ISiteAO#addSite(com.std.forum.domain.Site)
     */
    @Override
    public String addSite(Site data) {
        siteBO.isExistSite(data.getName());
        return siteBO.saveSite(data);
    }

    /** 
     * @see com.std.forum.ao.ISiteAO#editSite(com.std.forum.domain.Site)
     */
    @Override
    public int editSite(Site data) {
        return siteBO.refreshSite(data);
    }

    /** 
     * @see com.std.forum.ao.ISiteAO#querySitePage(int, int, com.std.forum.domain.Site)
     */
    @Override
    public Paginable<Site> querySitePage(int start, int limit, Site condition) {
        return siteBO.getPaginable(start, limit, condition);
    }

    /** 
     * @see com.std.forum.ao.ISiteAO#querySiteList(com.std.forum.domain.Site)
     */
    @Override
    public List<Site> querySiteList(Site condition) {
        return siteBO.querySiteList(condition);
    }

    @Override
    public int editSiteDef(Site data) {
        return siteBO.refreshSiteDef(data);
    }

    @Override
    public int editSitePri(Site data) {
        return siteBO.refreshSitePri(data);
    }

    @Override
    public Site getSiteByJW(Site condition) {
        Site condition1 = new Site();
        List<Site> list = siteBO.querySiteList(condition1);
        double lo = Double.valueOf(condition.getLongitude());
        double la = Double.valueOf(condition.getLatitude());
        for (Site site : list) {
            String[] los = site.getLongitude().split("-");
            String[] las = site.getLatitude().split("-");
            if (los.length > 1 && las.length > 1) {
                double lo1 = Double.valueOf(los[0]);
                double lo2 = Double.valueOf(los[1]);
                double la1 = Double.valueOf(las[0]);
                double la2 = Double.valueOf(las[1]);
                if (lo >= lo1 && lo <= lo2 && la >= la1 && la <= la2) {
                    return site;
                }
            }
        }
        return null;
    }
}
