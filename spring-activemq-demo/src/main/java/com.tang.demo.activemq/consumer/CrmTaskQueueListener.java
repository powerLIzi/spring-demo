package com.tang.demo.activemq.consumer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lianjia.common.datasource.transaction.DataRegionsTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.*;

@Service("crmTaskQueueListener")
public class CrmTaskQueueListener implements MessageListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(CrmTaskQueueListener.class);
    @Resource
    private MessageHandleService messageHandleService;
    @DataRegionsTransactional
    public void onMessage(Message message) {
        try {
            if (message instanceof TextMessage) {
                String objMessage = ((TextMessage) message).getText();
                LOGGER.info("current thread :id={},name={}", Thread.currentThread().getId(), Thread.currentThread().getName());
                LOGGER.info("QueueMessageListener-objMessage:" + objMessage);
                JSONObject jo = JSON.parseObject(objMessage);
                Long houseCode = jo.getLong("houseCode");
                messageHandleService.invalidHouseVerifyTaskByHouseId(houseCode);
                messageHandleService.invalidCredentialTaskAndInfo(houseCode);
            } else if (message instanceof MapMessage) {
                MapMessage map = (MapMessage) message;
                LOGGER.info("QueueMessageListener-map:" + map);
            } else if (message instanceof ObjectMessage) {
            } else {
                LOGGER.info("occur exception MQmessage={} e.message={}", message, "不确定消息类型");
            }
        } catch (Exception e) {
            LOGGER.error("occur exception MQmessage={} e.message={}", message, e.getMessage(), e);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e1) {
                LOGGER.error("occur InterruptedException e.message={}", e1.getMessage(), e);
            }
        }
    }

}
