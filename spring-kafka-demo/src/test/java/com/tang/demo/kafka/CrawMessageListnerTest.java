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
import java.util.UUID;
import java.util.concurrent.TimeUnit;


/**
 * Created by tangliling on 2017/8/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:applicationContext-kafka.xml"
})
public class CrawMessageListnerTest {
    Logger logger = LoggerFactory.getLogger(CrawMessageListnerTest.class);

    @Autowired
    private CrawlMessageListner crawlMessageListner;

    @Autowired
    private KafkaTemplate KafkaTemplate;

    @Test
    public void consumerMessageTest() {
        try {
            crawlMessageListner.countDownLatch.await(10, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void sendMessageTest() {
        String houseMsg =
                "{\"housedelCode\":104100016681,\"ownerName\":\"shiyujie\",\"resblockName\":\"随园\",\"buildingName\":\"6号楼\",\"cityId\":320100,\"ownerMobilePhone1\":\"C22EC3CD8412B90AAACBBE5B192FC459\",\"ownerMobilePhone2\":\"\",\"ownerHomePhone\":\"67A80164738C5B9FF21CF7E19A51FC97\",\"houseName\":\"401\",\"floor\":\"4\",\"totalFloor\":6,\"unitName\":\"1单元\",\"resblockId\":1411000000621,\"buildSize\":120,\"totalPrice\":2300000.00,\"buildingId\":2512052234626}";
        String addHouse = "{\"housedelCode\":104100636611,\"ownerName\":\"曾姐\",\"resblockName\":\"融创凡尔赛领馆一期\",\"buildingName\":\"11幢\",\"cityId\":500000,\"crmActionType\":1,\"ownerMobilePhone1\":\"F3AE476A22B0613770D2730DB3AC0F8A\",\"ownerMobilePhone2\":\"\",\"ownerHomePhone\":\"\",\"houseName\":\"2906\",\"floor\":\"29\",\"totalFloor\":33,\"unitName\":\"0单元\",\"resblockId\":369188411452453,\"buildSize\":91.62,\"totalPrice\":1050000.00,\"buildingId\":369188567428529}";
        String invalideHouse = "{\"cityId\":110000,\"crmActionType\":3}";
        String updateHouse = "{\"housedelCode\":101100781234,\"cityId\":110000,\"crmActionType\":2,\"ownerMobilePhone1\":\"EDE28827D8615A2BC6FE7D75F93B0B4E\",\"ownerMobilePhone2\":\"E7A5DE80698C7D0C33917FEBFB8F14A3\"}";
        String clueMsg =
                "{\"dbTableName\":\"nanjing\",\"parentUrl\":\"中央金地218平方产权房产权房可注册公司\",\"housePrice\":\"650万（29817元/㎡）\",\"ownerTel\":\"http://nj.sell.house365.com/person_publish.php?mobile=13913899024\",\"isNeedNewId\":\"true\",\"community\":\"小区： 中央金地（鼓楼区建宁路）（\uE619周边交通）\",\"areaInfo\":\"南京二手房>南京二手房出售>鼓楼区二手房>建宁路二手房>中央金地218平方产权房产权房可注册公司\",\"thisPageKey\":\"中央金地218平方产权房产权房可注册公司\",\"houseName\":\"中央金地218平方产权房产权房可注册公司\",\"ownerName\":\"李小姐\",\"thisUrl\":\"http://nj.sell.house365.com/s_162884817.html\",\"communityName\":\"小区： 中央金地（鼓楼区建宁路）（\uE619周边交通）\",\"childUrl\":{},\"id\":\"http://nj.sell.house365.com/s_162884817.html\",\"memoInfo\":\"365-nanjing\",\"pushTime\":\"发布时间2017-08-30 12:03:20(17分钟前更新)\",\"info\":\"365-detail\"}";
        String credentailMsg =
                "{\"content\":\"[{\\\"uploadUcid\\\":1000000010002346,\\\"credentialType\\\":\\\"registerPhoto\\\"},{\\\"uploadUcid\\\":1000000010002346,\\\"credentialType\\\":\\\"registerDelPhoto\\\"},{\\\"uploadUcid\\\":1000000010002346,\\\"credentialType\\\":\\\"identify\\\"},{\\\"uploadUcid\\\":1000000010002346,\\\"credentialType\\\":\\\"serviceMattersNotice\\\"},{\\\"uploadUcid\\\":1000000010002346,\\\"credentialType\\\":\\\"houseConditionStatement\\\"},{\\\"uploadUcid\\\":1000000010002346,\\\"credentialType\\\":\\\"purchasePhoto\\\"},{\\\"uploadUcid\\\":1000000010002346,\\\"credentialType\\\":\\\"govRecordNo\\\"},{\\\"uploadUcid\\\":1000000010002346,\\\"credentialType\\\":\\\"verificationPhoto\\\"},{\\\"uploadUcid\\\":1000000010002346,\\\"credentialType\\\":\\\"deedPhoto\\\"}]\",\"housedelCode\":101100542300,\"standardHouseId\":1115040998400,\"officeAddress\":110000,\"msgStatus\":1,\"delType\":1}";
        String msg = "{\"biz_type\":\"LINK_CMS\",\"channel\":\"link_secondhouse\",\"from_ucid\":\"LINK_PIGEON\",\"msg_payload\":\"终于从坑里爬出来了--\",\"msg_type\":\"-1\",\"push_option\":\"1\",\"to_ucids\":\"1000000020228075\"}";
//                KafkaTemplate.send("search-queue-spider-house-clue", clueMsg);
//        KafkaTemplate.send("mobile-api-common-im-low-priority", msg);
//        KafkaTemplate.send("iprd-queue-crm-qc-dev", credentailMsg);
//        KafkaTemplate.send("iprd-queue-crm-dev", addHouse);
//        KafkaTemplate.send("iprd-queue-crm-dev", updateHouse);
//        KafkaTemplate.send("iprd-queue-crm-dev", invalideHouse);

//        KafkaTemplate.send("sinan-certificate-audit-result", credentialAppealMsg());
//        Long[] str = new Long[3];
//        str[0] = 12L;
//        str[1] = 14L;
//        str[2] = 11L;
//        logger.info("param {}", JSON.toJSON(str));
//
//        ExceptionMonitor.put(new MonitorMsg("test1","ldjfldjf"));
//        ExceptionMonitor.put(new MonitorMsg("test2","sdlfdjlfdj"));
//        ExceptionMonitor.put(new MonitorMsg("test3","ldjfldjf"));

//        sendCredentialAddMsgTest();

        sendMsg2Hdic("sinan-hidic-cridential-audit-result-test");
        try {
            crawlMessageListner.countDownLatch.await(10, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void sendCredentialAddMsgTest() {
        JSONObject msgObj = new JSONObject();
        msgObj.put("msgStatus", 1);
        msgObj.put("houseCode", "103100000006");
        msgObj.put("officeAddress", "888888");
        msgObj.put("standardHouseId", "103100000006");
        msgObj.put("uploader", "1000000020165182");
        msgObj.put("delType", "1");
        JSONArray credentials = new JSONArray();
        JSONObject credential = new JSONObject();

        credential.put("credentialType","deedPhoto");
        credential.put("uploadUcid","1000000020165182");
        credential.put("createdTime",new Date());
        credential.put("credentialId",(int) (Math.random() * 10000));
        credentials.add(credential);
        msgObj.put("content", credentials);
        sendMsg("iprd-queue-crm-qc-dev",msgObj);
//        sendMsg("hdic-sparepart-queue-checkstatus-transfer",msgObj);
    }

    @Test
    public void sendCredentialAppealMsgTest() {
        JSONObject msgObj = new JSONObject();
        msgObj.put("uniqueCode", (int) (Math.random() * 10000));
        msgObj.put("houseCode", "103100000006");
        msgObj.put("credentialType", "deedPhoto");
        msgObj.put("credentialTypeName", "契税票");
        msgObj.put("uploader", "1000000020165182");
        msgObj.put("cityCode", "888888");
        msgObj.put("failureReason", "3#4");
        msgObj.put("upstreamRemark", "的接口废掉节流阀");
        msgObj.put("uploadDate", "2017-10-24 11:11:11");
        msgObj.put("adminAddress", "测试小区测试楼栋测试单元");
        msgObj.put("credentialId", (int) (Math.random() * 10000));
        sendMsg("iprd-queue-crm-qc-dev",msgObj);
    }


    @Test
    public void sendQcAddTaskMessageTest() {
        /**
         * {"action":1,"data":{"cityCode":"110000",
         * "houseCode":"11000000000007491210",
         * "houseUrl":"http://m.zufangzi.com/redirect?id=11000000000007491210&type=house&city_id=110000",
         * "phoneNum":"18911928054","preProblemRemark":"上架时间:2017-12-29 10:42:35",
         "preProblemSource":"100000","preProblemType":"上线多天不出房！"},
         "project":"rentHouseAudit",
         "taskId":"425",
         "taskType":"31",
         "timestamp":1517219249075}
         */
        JSONObject msgObj = new JSONObject();
        msgObj.put("timestamp", System.currentTimeMillis());
        msgObj.put("action", "1");
        msgObj.put("project", "rentHouseAudit");
        msgObj.put("taskType", "31");
        msgObj.put("taskId", System.currentTimeMillis());

        JSONObject data = new JSONObject();
        data.put("cityCode", "110000");
        data.put("houseCode", "11000000000007491210");
        data.put("houseUrl", "http://m.zufangzi.com/redirect?id=11000000000007491210&type=house&city_id=110000");
        data.put("phoneNum", "18911928054");
//        data.put("recordUrl", "http://record1.eqitong.com/monitor/20180116/053155624088_015601183566_093511.mp3");
        data.put("preProblemSource", "300000");
        data.put("preProblemRemark", "上架时间:2017-12-29 10:42:35");
        data.put("preProblemType", "上线多天不出房！");
        msgObj.put("data",data);
        logger.info(msgObj.toJSONString());
        sendMsg("sinan-audit-task-offline",msgObj);
    }

    @Test
    public void sendQcInvalidTaskMessageTest() {
        JSONObject msgObj = new JSONObject();
        msgObj.put("timestamp", System.currentTimeMillis());
        msgObj.put("action", "0");
        msgObj.put("project", "rentHouseAudit");
        msgObj.put("taskType", "31");
        msgObj.put("taskId", "1516854236854");
        sendMsg("sinan-audit-task-dev",msgObj);
    }

    @Test
    public void sendQcAuditResultMessageTest() {
        JSONObject msgObj = new JSONObject();
        msgObj.put("action", "2");
        msgObj.put("timestamp", System.currentTimeMillis());
        msgObj.put("project", "rentHouseAudit");
        msgObj.put("taskType", "31");
        msgObj.put("taskId", "25");
        JSONObject data = new JSONObject();
        data.put("problemTypeCn", "信息不符-物业地址不符,虚假信息-虚假户型");
        data.put("auditRemark", "都会好的");
        data.put("auditResult", "100");
        data.put("problemType", "100001,200002");
        msgObj.put("data",data);
        sendMsg("sinan-audit-task-result-dev",msgObj);
    }


    private void sendMsg(String topic,JSONObject object){
        String result = object.toJSONString();
        logger.info("send topic = {},msg={}",topic,result);
        KafkaTemplate.send(topic, result);



        try {
            crawlMessageListner.countDownLatch.await(10, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void sendMsg2Hdic(String topic){
        String msg1 = "{\"tplKey\":\"08dd1d130b5553ff\",\"auditUserId\":1000000020186866,\"appKey\":\"houseSourceEntrust\",\"cityId\":\"110000\",\"submitData\":[{\"id\":1115033553015,\"list\":[{\"itemKey\":\"propAddr\",\"itemValue\":\"黄村丽园路丽园/15号楼/3单元/6层/602\"},{\"itemKey\":\"buildArea\",\"itemValue\":\"100.20\"},{\"itemKey\":\"insideArea\",\"itemValue\":\"89.15\"},{\"itemKey\":\"buildYear\",\"itemValue\":\"2007\"},{\"itemKey\":\"dealProperty\",\"itemValue\":\"307500000001\"},{\"itemKey\":\"statFunction\",\"itemValue\":\"107500000003\"},{\"itemKey\":\"propertyAgeLimit\",\"itemValue\":\"307600000003\"}]},\"dataSource\":\"0400060023\",\"user\":{\"phone\":\"70873778592\",\"name\":\"谢XX\",\"userId\":1000000010101572}}]";
        String msg2 = "{\"tplKey\":\"08dd1d130b5553ff\",\"auditUserId\":1000000020186866,\"appKey\":\"houseSourceEntrust\",\"cityId\":\"110000\",\"submitData\":[{\"id\":1112027393726,\"list\":[{\"itemKey\":\"buildStructure\",\"itemValue\":\"100700000002\"}]},\"dataSource\":\"0400060023\",\"user\":{\"phone\":\"70873778592\",\"name\":\"谢XX\",\"userId\":1000000010101572}}]";
        KafkaTemplate.send(topic,msg1);
        KafkaTemplate.send(topic,msg2);
    }
}
