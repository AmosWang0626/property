package cn.zut.common.dao;

import java.util.List;

/**
 * 查询列表页
 */
public interface SelectListPageByExample<T, S> extends SelectCountByExample<S> {

    List<T> selectListPageByExample(PageModel<S> model);
}
