package cn.zut.core.service;

import cn.zut.common.generic.GenericResponse;
import cn.zut.dao.entity.MemberEntity;
import cn.zut.facade.request.RegisterRequest;
import cn.zut.facade.response.MenuFirstLevelVO;

import java.util.List;

/**
 * PROJECT: property
 * DATE: 2017/11/21
 *
 * @author DaoYuanWang
 */
public interface MemberService {

    /**
     * 保存用户信息
     *
     * @param registerRequest 注册表单
     * @return 通用
     */
    GenericResponse<MemberEntity> save(RegisterRequest registerRequest);

    /**
     * 根据用户可查看的菜单
     *
     * @param memberId 用户编号
     * @return 二级菜单列表
     */
    GenericResponse<List<MenuFirstLevelVO>> getMenus(Long memberId);

}
