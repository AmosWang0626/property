package cn.zut.core.service.impl;

import cn.zut.common.generic.GenericResponse;
import cn.zut.common.security.EncryptionUtil;
import cn.zut.common.util.RandomUtil;
import cn.zut.core.constant.PropertyConstant;
import cn.zut.core.service.BusinessMenusService;
import cn.zut.core.service.MemberService;
import cn.zut.dao.entity.BusinessMenusEntity;
import cn.zut.dao.entity.BusinessRolesEntity;
import cn.zut.dao.entity.LoginInfoEntity;
import cn.zut.dao.entity.MemberEntity;
import cn.zut.dao.persistence.BusinessRolesMapper;
import cn.zut.dao.persistence.LoginInfoMapper;
import cn.zut.dao.persistence.MemberMapper;
import cn.zut.facade.enums.SystemRolesEnum;
import cn.zut.facade.request.RegisterRequest;
import cn.zut.facade.response.MenuFirstLevelVO;
import cn.zut.facade.response.MenuSecondLevelVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * PROJECT: property
 * DATE: 2017/11/21
 *
 * @author DaoYuanWang
 */
@Service("memberService")
public class MemberServiceImpl implements MemberService {
    @Resource
    private BusinessMenusService businessMenusService;

    @Resource
    private MemberMapper memberMapper;
    @Resource
    private LoginInfoMapper loginInfoMapper;

    @Resource
    private BusinessRolesMapper businessRolesMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public GenericResponse<MemberEntity> save(RegisterRequest registerRequest) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.init();
        memberEntity.setPhoneNo(registerRequest.getPhoneNo());
        memberEntity.setNickName(registerRequest.getNickName());

        // 设置用户默认权限
        BusinessRolesEntity businessRolesEntity = new BusinessRolesEntity();
        businessRolesEntity.setRolesName(SystemRolesEnum.USER.name());
        businessRolesEntity = businessRolesMapper.selectByExample(businessRolesEntity);
        if (businessRolesEntity != null) {
            memberEntity.setRolesId(businessRolesEntity.getRolesId());
        }
        memberMapper.insert(memberEntity);

        LoginInfoEntity loginInfoEntity = new LoginInfoEntity();
        loginInfoEntity.init();
        loginInfoEntity.setMemberId(memberEntity.getMemberId());
        // 生成密码盐
        String salt = RandomUtil.generateLetterString(PropertyConstant.SALT_LENGTH);
        String encryptPassword = EncryptionUtil.encrypt(salt + registerRequest.getPassword(), EncryptionUtil.MD5);
        loginInfoEntity.setSalt(salt);
        loginInfoEntity.setPassword(encryptPassword);

        loginInfoMapper.insert(loginInfoEntity);

        return new GenericResponse<>(memberEntity);
    }

    @Override
    public GenericResponse<List<MenuFirstLevelVO>> getMenus(Long memberId) {
        MemberEntity memberEntity = memberMapper.selectById(memberId);

        // First Menu List
        List<MenuFirstLevelVO> menuFirstLevelVOList = new ArrayList<>();

        // Second Menu List By FatherId
        Map<Integer, List<MenuSecondLevelVO>> secondMenuMapByFatherId = new HashMap<>();

        List<BusinessMenusEntity> allMenus = businessMenusService.getAllMenus(memberEntity.getRolesId());
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
