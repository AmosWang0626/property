package cn.zut.core.service.impl;

import cn.zut.common.generic.GenericResponse;
import cn.zut.core.service.BusinessMenusService;
import cn.zut.core.service.BusinessRolesUserService;
import cn.zut.dao.entity.BusinessMenusEntity;
import cn.zut.dao.entity.BusinessRolesEntity;
import cn.zut.dao.entity.MemberEntity;
import cn.zut.dao.persistence.BusinessRolesMapper;
import cn.zut.dao.persistence.MemberMapper;
import cn.zut.facade.response.MenuFirstLevelVO;
import cn.zut.facade.response.MenuSecondLevelVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LiuBowen
 */
@Service("businessRolesUserService")
public class BusinessRolesUserServiceImpl implements BusinessRolesUserService {

    @Resource
    private MemberMapper memberMapper;
    @Resource
    private BusinessRolesMapper businessRolesMapper;
    @Resource
    private BusinessMenusService businessMenusService;

    @Override
    public BusinessRolesEntity getRoles(Long memberId) {
        MemberEntity memberEntity = memberMapper.selectById(memberId);
        return businessRolesMapper.selectById(memberEntity.getRolesId());
    }

    @Override
    public boolean updateRoles(Integer roleId, Long memberId) {
        BusinessRolesEntity businessRolesEntity = businessRolesMapper.selectById(roleId);
        if (businessRolesEntity == null) {
            return false;
        }
        MemberEntity memberEntity = memberMapper.selectById(memberId);
        memberEntity.setRolesId(businessRolesEntity.getRolesId());
        return memberMapper.update(memberEntity) > 0;
    }

    @Override
    public GenericResponse<List<MenuFirstLevelVO>> getMenus(Long memberId) {
        MemberEntity memberEntity = memberMapper.selectById(memberId);

        // First Menu List
        List<MenuFirstLevelVO> menuFirstLevelVOList = new ArrayList<>();

        // Second Menu List By FatherId
        Map<Integer, List<MenuSecondLevelVO>> secondMenuMapByFatherId = new HashMap<>();

        List<BusinessMenusEntity> allMenus = businessMenusService.menus(memberEntity.getRolesId());
        if (CollectionUtils.isEmpty(allMenus)) {
            return null;
        }

        allMenus.forEach(businessMenusEntity -> {

            // Check is First Level Menu ?
            if (businessMenusEntity.getFatherId() == 0) {
                MenuFirstLevelVO menuFirstLevelVO = new MenuFirstLevelVO();
                menuFirstLevelVO.setMenuId(businessMenusEntity.getMenuId());
                menuFirstLevelVO.setMenuIcon(businessMenusEntity.getMenuIcon());
                menuFirstLevelVO.setMenuName(businessMenusEntity.getMenuName());
                menuFirstLevelVO.setPriority(businessMenusEntity.getPriority());
                menuFirstLevelVOList.add(menuFirstLevelVO);
            } else {
                MenuSecondLevelVO menuSecondLevelVO = new MenuSecondLevelVO();
                BeanUtils.copyProperties(businessMenusEntity, menuSecondLevelVO);

                List<MenuSecondLevelVO> menuSecondLevelVOS = secondMenuMapByFatherId.get(businessMenusEntity.getFatherId());
                if (menuSecondLevelVOS == null) {
                    menuSecondLevelVOS = new ArrayList<>();
                }
                menuSecondLevelVOS.add(menuSecondLevelVO);
                secondMenuMapByFatherId.put(businessMenusEntity.getFatherId(), menuSecondLevelVOS);
            }
        });

        menuFirstLevelVOList.forEach(menuFirstLevelVO -> {
            menuFirstLevelVO.setSecondLevel(secondMenuMapByFatherId.get(menuFirstLevelVO.getMenuId()));
        });

        return new GenericResponse<>(menuFirstLevelVOList);
    }
}
