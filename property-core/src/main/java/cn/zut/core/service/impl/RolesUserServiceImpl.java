package cn.zut.core.service.impl;

import cn.zut.core.service.RolesUserService;
import cn.zut.dao.entity.MemberEntity;
import cn.zut.dao.entity.RolesEntity;
import cn.zut.dao.persistence.MemberMapper;
import cn.zut.dao.persistence.RolesMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author LiuBowen
 */
@Service("rolesUserService")
public class RolesUserServiceImpl implements RolesUserService {

    @Resource
    private MemberMapper memberMapper;
    @Resource
    private RolesMapper rolesMapper;

    @Override
    public Integer getUserRoles(Long memberId) {
        MemberEntity memberEntity = memberMapper.selectById(memberId);
        return memberEntity.getRolesId();
    }

    @Override
    public RolesEntity getRoles(Long memberId) {
        MemberEntity memberEntity = memberMapper.selectById(memberId);
        return rolesMapper.selectById(memberEntity.getRolesId());
    }

    @Override
    public boolean updateRoles(Integer roleId, Long memberId) {
        RolesEntity rolesEntity = rolesMapper.selectById(roleId);
        if (rolesEntity == null) {
            return false;
        }
        MemberEntity memberEntity = memberMapper.selectById(memberId);
        memberEntity.setRolesId(rolesEntity.getRolesId());
        return memberMapper.update(memberEntity) > 0;
    }
}
