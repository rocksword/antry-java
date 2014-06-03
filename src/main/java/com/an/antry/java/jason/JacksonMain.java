package com.an.antry.java.jason;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JacksonMain {
    private static final Log logger = LogFactory.getLog(JacksonMain.class);

    private ObjectMapper objectMapper = null;
    private AccountBean bean = null;

    @Test
    public void readWriteJsonObj() {
        try {
            logger.info("ObjectMapper");
            String objStr = objectMapper.writeValueAsString(bean);
            logger.info("Object string: " + objStr);
            String newObjStr = objStr.replaceAll("null", "\"2014-03-10\"");
            logger.info("New object string: " + newObjStr);

            // AccountBean newObj = (AccountBean)objectMapper.readv
            AccountBean ab = objectMapper.readValue(newObjStr, AccountBean.class);
            logger.info(ab);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Before
    public void init() {
        logger.info("init");
        bean = new AccountBean();
        bean.setAddress("china-Guangzhou");
        bean.setEmail("hoojo_@126.com");
        bean.setId(1);
        bean.setName("hoojo");

        objectMapper = new ObjectMapper();
    }

    @After
    public void destory() {
        logger.info("destory");
        objectMapper = null;
        bean = null;
    }
}
