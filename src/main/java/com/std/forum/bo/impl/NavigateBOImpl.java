package com.std.forum.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.std.forum.bo.INavigateBO;
import com.std.forum.bo.base.PaginableBOImpl;
import com.std.forum.core.OrderNoGenerater;
import com.std.forum.dao.INavigateDAO;
import com.std.forum.domain.Navigate;
import com.std.forum.enums.EPrefixCode;
import com.std.forum.exception.BizException;

/** 
 * @author: zuixian 
 * @since: 2016年9月14日 上午10:57:31 
 * @history:
 */
@Component
public class NavigateBOImpl extends PaginableBOImpl<Navigate> implements
        INavigateBO {

    @Autowired
    private INavigateDAO navigateDAO;

    @Override
    public void isExistNavigate(String title) {
        Navigate condition = new Navigate();
        condition.setTitle(title);
        long count = navigateDAO.selectTotalCount(condition);
        if (count > 0) {
            throw new BizException("xn000000", "该导航标题已存在");
        }
    }

    @Override
    public String saveNavigate(Navigate data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generateM(EPrefixCode.NAVIGATE.getCode());
            data.setCode(code);
            navigateDAO.insert(data);
        }
        return code;
    }

    @Override
    public int refreshNavigate(Navigate data) {
        int count = 0;
        if (data != null && data.getCode() != null) {
            count = navigateDAO.update(data);
        }
        return count;
    }

    @Override
    public List<Navigate> queryNavigateList(Navigate condition) {
        return navigateDAO.selectList(condition);
    }

    @Override
    public int deleteNavigate(Navigate data) {
        int count = 0;
        if (data != null && data.getCode() != null) {
            count = navigateDAO.delete(data);
        }
        return count;
    }

}
