package cn.zut.core.service.impl;

import cn.zut.core.service.BusinessRolesUserService;
import cn.zut.dao.entity.BusinessRolesEntity;
import cn.zut.dao.entity.MemberEntity;
import cn.zut.dao.persistence.BusinessRolesMapper;
import cn.zut.dao.persistence.MemberMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author LiuBowen
 */
@Service("businessRolesUserService")
public class BusinessRolesUserServiceImpl implements BusinessRolesUserService {

    @Resource
    private MemberMapper memberMapper;
    @Resource
    private BusinessRolesMapper businessRolesMapper;

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
}
