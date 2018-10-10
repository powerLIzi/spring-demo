package com.tang.demo.activemq.consumer;

import com.lianjia.common.datasource.transaction.DataRegionsTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by tangliling on 2017/8/17.
 */
public class MessageHandleServiceImpl implements MessageHandleService{
    Logger logger = LoggerFactory.getLogger(MessageHandleServiceImpl.class);
    @Override
    @DataRegionsTransactional
    public void invalidHouseVerifyTaskByHouseId(Long houseCode) {
        logger.info("无效房源回访任务,houseCode={}",houseCode);
    }

    @Override
    @DataRegionsTransactional
    public void invalidCredentialTaskAndInfo(Long houseCode) {
        logger.info("查询房源houseCode={}对应的备件",houseCode);
        logger.info("无效备件1");
        logger.info("无效备件2");
        logger.info("无效备件3");
        logger.info("无效备件4");

    }
}
