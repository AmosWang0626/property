package cn.zut.core.service;

/**
 * @author LiuBowen
 */
public interface ManageLogService {

    /**
     * 增加日志
     *
     * @param memberId 用户编号
     * @param name     用户名
     * @param operate  操作描述
     * @return 添加成功/失败
     */
    boolean addLog(Long memberId, String name, String operate);

}
