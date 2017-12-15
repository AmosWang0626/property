package cn.zut.core.service.impl;

import cn.zut.common.response.GenericResponse;
import cn.zut.common.security.EncryptionUtil;
import cn.zut.common.util.GenericIdUtil;
import cn.zut.common.util.RandomUtil;
import cn.zut.core.constant.PrivateConstant;
import cn.zut.core.service.MemberService;
import cn.zut.dao.entity.LoginInfoEntity;
import cn.zut.dao.entity.MemberEntity;
import cn.zut.dao.persistence.LoginInfoMapper;
import cn.zut.dao.persistence.MemberMapper;
import cn.zut.facade.request.RegisterForm;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * PROJECT: catherine
 * DATE: 2017/11/21
 *
 * @author DaoYuanWang
 */
@Service("memberService")
public class MemberServiceImpl implements MemberService {

    @SuppressWarnings("all")
    @Resource
    private MemberMapper memberMapper;
    @SuppressWarnings("all")
    @Resource
    private LoginInfoMapper loginInfoMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public GenericResponse save(RegisterForm registerForm) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.init();
        Long memberId = GenericIdUtil.genericMemberId();
        memberEntity.setMemberId(memberId);
        memberEntity.setPhoneNo(registerForm.getPhoneNo());
        memberEntity.setNickName(registerForm.getNickName());

        LoginInfoEntity loginInfoEntity = new LoginInfoEntity();
        loginInfoEntity.init();
        loginInfoEntity.setMemberId(memberId);
        // 生成密码盐
        String salt = RandomUtil.generateLetterString(PrivateConstant.SALT_LENGTH);
        String encryptPassword = EncryptionUtil.encrypt(salt + registerForm.getPassword(), EncryptionUtil.MD5);
        loginInfoEntity.setSalt(salt);
        loginInfoEntity.setPassword(encryptPassword);

        memberMapper.insert(memberEntity);
        loginInfoMapper.insert(loginInfoEntity);

        return GenericResponse.SUCCESS;
    }
}
