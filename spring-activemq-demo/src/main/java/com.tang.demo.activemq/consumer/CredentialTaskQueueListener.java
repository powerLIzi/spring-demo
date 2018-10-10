package com.tang.demo.activemq.consumer;

import com.lianjia.common.datasource.transaction.DataRegionsTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by Zhujinsong on 2016/11/17.
 */
@Service("credentialTaskQueueListener")
public class CredentialTaskQueueListener implements MessageListener {


    private static final Logger LOGGER = LoggerFactory.getLogger(CredentialTaskQueueListener.class);

    @Override
    @DataRegionsTransactional
    public void onMessage(Message message) {
        try {
            if (message instanceof TextMessage) {
                String objMessage = ((TextMessage) message).getText();
                LOGGER.info("current thread :id={},name={}", Thread.currentThread().getId(), Thread.currentThread().getName());

                LOGGER.info("QueueMessageListener-certificate-objMessage:" + objMessage);
                System.out.println("--------" + objMessage);
                credentialMsgHandle(objMessage);
            }
        } catch (JMSException e) {
            LOGGER.error("occur jmsException MQmessage={} e.message={}", message, e.getMessage(), e);
        } catch (Exception e) {
            LOGGER.error("occur Exception MQmessage={} e.message={}", message, e.getMessage(), e);
        }
    }

    private void credentialMsgHandle(String objMessage) {

    }

}
