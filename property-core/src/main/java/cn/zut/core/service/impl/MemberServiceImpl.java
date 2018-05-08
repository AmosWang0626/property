package cn.zut.core.service.impl;

import cn.zut.common.generic.GenericResponse;
import cn.zut.common.security.EncryptionUtil;
import cn.zut.common.util.RandomUtil;
import cn.zut.core.constant.PropertyConstant;
import cn.zut.core.service.MemberService;
import cn.zut.core.service.BusinessMenusService;
import cn.zut.core.service.BusinessRolesMenuService;
import cn.zut.core.service.BusinessRolesUserService;
import cn.zut.dao.entity.LoginInfoEntity;
import cn.zut.dao.entity.MemberEntity;
import cn.zut.dao.entity.BusinessMenusEntity;
import cn.zut.dao.persistence.LoginInfoMapper;
import cn.zut.dao.persistence.MemberMapper;
import cn.zut.facade.request.RegisterRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * PROJECT: property
 * DATE: 2017/11/21
 *
 * @author DaoYuanWang
 */
@Service("memberService")
public class MemberServiceImpl implements MemberService {
    @Resource
    private BusinessRolesMenuService businessRolesMenuService;
    @Resource
    private BusinessRolesUserService businessRolesUserService;
    @Resource
    private BusinessMenusService businessMenusService;

    @Resource
    private MemberMapper memberMapper;
    @Resource
    private LoginInfoMapper loginInfoMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public GenericResponse<Long> save(RegisterRequest registerRequest) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.init();
        memberEntity.setPhoneNo(registerRequest.getPhoneNo());
        memberEntity.setNickName(registerRequest.getNickName());
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

        return new GenericResponse<>(memberEntity.getMemberId());
    }

    @Override
    public List<BusinessMenusEntity> getMenus(Long menuId) {
        int roleId = businessRolesUserService.getUserRoles(menuId);
        List<Integer> list = businessRolesMenuService.getMenusIdList(roleId);
        return businessMenusService.getAllMenus(list);
    }
}
