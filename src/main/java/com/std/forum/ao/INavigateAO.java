package com.std.forum.ao;

import java.util.List;

import com.std.forum.bo.base.Paginable;
import com.std.forum.domain.Navigate;

public interface INavigateAO {
    String DEFAULT_ORDER_COLUMN = "code";

    public String addNavigate(Navigate data);

    public int editNavigate(Navigate data);

    public int removeNavigate(Navigate data);

    public Paginable<Navigate> queryNavigatePage(int start, int limit,
            Navigate condition);

    public List<Navigate> queryNavigateList(Navigate condition);
}
