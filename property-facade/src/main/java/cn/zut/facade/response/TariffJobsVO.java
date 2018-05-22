package cn.zut.facade.response;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * PROJECT: property
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/5/22
 */
@Data
public class TariffJobsVO implements Serializable {

    private static final long serialVersionUID = 8671679531164609499L;

    /**
     * 任务编号
     */
    private Long id;
    /**
     * 任务名称
     */
    private String jobName;
    /**
     * 任务描述
     */
    private String jobDesc;
    /**
     * 任务开始执行时间
     */
    private Date startTime;
    /**
     * 任务执行结束时间
     */
    private Date endTime;
    /**
     * 任务运行时间
     */
    private Long runTime;
    /**
     * 任务状态
     */
    private String status;
}
