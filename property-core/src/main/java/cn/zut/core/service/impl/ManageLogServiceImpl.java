package cn.zut.core.service.impl;

import cn.zut.core.service.ManageLogService;
import cn.zut.dao.entity.ManageLogEntity;
import cn.zut.dao.persistence.ManageLogMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author YangShangYu
 */
@Service("manageLogService")
public class ManageLogServiceImpl implements ManageLogService {

    @Resource
    private ManageLogMapper manageLogMapper;

    @Override
    public boolean addLog(Long memberId, String name, String operate) {
        ManageLogEntity manageLogEntity = new ManageLogEntity();
        manageLogEntity.setMemberId(memberId);
        manageLogEntity.setName(name);
        manageLogEntity.setOperate(operate);
        manageLogEntity.setOperateTime(new Date());

        return manageLogMapper.insert(manageLogEntity) > 0;
    }
}
