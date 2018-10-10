package com.tang.demo.kafka;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:applicationContext-kafka-producer.xml"
})
public class KafkaProduceTest {

    Logger logger = LoggerFactory.getLogger(KafkaProduceTest.class);

    @Autowired
    private KafkaTemplate aresKafkaTemplate;
    @Autowired
    private KafkaTemplate zeusKafkaTemplate;
    @Test
    public void sendCredentialMsgAresTest(){
        JSONObject msgObj = new JSONObject();
        msgObj.put("msgStatus", 1);
        msgObj.put("houseCode", "103100000006");
        msgObj.put("officeAddress", "888888");
        msgObj.put("standardHouseId", "103100000006");
        msgObj.put("uploader", "1000000020165182");
        msgObj.put("delType", "1");
        JSONArray credentials = new JSONArray();
        JSONObject credential = new JSONObject();

        credential.put("credentialType", "deedPhoto");
        credential.put("uploadUcid", "1000000020165182");
        credential.put("createdTime", new Date());
        credential.put("credentialId", (int) (Math.random() * 10000));
        credentials.add(credential);
        msgObj.put("content", credentials);
        aresKafkaTemplate.send("iprd-queue-crm-qc-dev", msgObj);
    }

    @Test
    public void sendCredentialMsgZeusTest(){
        JSONObject msgObj = new JSONObject();
        msgObj.put("msgStatus", 1);
        msgObj.put("houseCode", "103100000006");
        msgObj.put("officeAddress", "888888");
        msgObj.put("standardHouseId", "103100000006");
        msgObj.put("uploader", "1000000020165182");
        msgObj.put("delType", "1");
        JSONArray credentials = new JSONArray();
        JSONObject credential = new JSONObject();

        credential.put("credentialType", "deedPhoto");
        credential.put("uploadUcid", "1000000020165182");
        credential.put("createdTime", new Date());
        credential.put("credentialId", (int) (Math.random() * 10000));
        credentials.add(credential);
        msgObj.put("content", credentials);
        zeusKafkaTemplate.send("iprd-queue-crm-qc-dev", msgObj);
    }
}
