package com.tang.demo.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;

/**
 * Created by tangliling on 2017/8/23.
 */
@Service
public class CrawlMessageListner implements MessageListener {
    private static final Logger logger = LoggerFactory.getLogger(CrawlMessageListner.class);

    public CountDownLatch countDownLatch = new CountDownLatch(10);
    @Override
    public void onMessage(Object data) {
        ConsumerRecord consumerRecord = (ConsumerRecord) data;
        logger.info("msg = {}", consumerRecord);
        logger.info("current thread is {}",Thread.currentThread().getId());
        countDownLatch.countDown();
    }

}
