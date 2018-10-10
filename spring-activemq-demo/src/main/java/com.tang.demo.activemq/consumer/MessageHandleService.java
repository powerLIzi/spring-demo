package com.tang.demo.activemq.consumer;

/**
 * Created by tangliling on 2017/8/17.
 */
public interface MessageHandleService {

    void invalidHouseVerifyTaskByHouseId(Long houseCode);

    void invalidCredentialTaskAndInfo(Long houseCode);
}
