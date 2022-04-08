package com.yoondev.backoffice;

import com.yoondev.backoffice.repository.ManagementRepository;
import com.yoondev.backoffice.utils.OMap;
import com.yoondev.backoffice.utils.Util;
import net.minidev.json.parser.JSONParser;
import org.apache.ibatis.jdbc.Null;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

class BackOfficeApplicationTests {
    @Autowired
    ManagementRepository managementRepository;
    @Test
    void contextLoads() {
        OMap param = new OMap();
        param.put("idx", 1155);
        param.put("subject", "qweqwe");
        managementRepository.updateBoardData(param);
    }

    @Test
    void StringsEqualsTest(){
        System.out.println(Util.equalsStrs("hello", "hello", "hello3", "hello4"));
    }

    @Test
    void getQueryStringEqualsTest(){
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("param1", "testVal1");
        paramMap.put("param2", "testVal2");
        paramMap.put("param3", "testVal3");

        String param1 = (String) paramMap.get("param1");
        String param2 = (String) paramMap.get("param2");
        String param3 = (String) paramMap.get("param3");

        String queryString = String.format("param3=%s&param1=%s&param2=%s", param3, param1, param2);
        String expectedQueryStr = Util.getQueryString(paramMap);

        System.out.println(queryString);
        System.out.println(expectedQueryStr);
    }

    @Test
    void httpUrlConntectionTest(){
        try{
            URL url = new URL("http://localhost:8080/management/test");
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();

            conn.setRequestMethod("GET");
            conn.setDoOutput(true);

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();


            System.out.println(br.readLine());
            conn.disconnect();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void getStrTest(){
        OMap oMap = new OMap();
        oMap.put("testKey", "value");

        System.out.println("testKey Value : " + oMap.getStr("testKey"));
        System.out.println("unknownKey Value : " + oMap.getStr("unknownKey"));
        assertThat("value", is(oMap.getStr("testKey")));
        assertThat("", is(oMap.getStr("unknownKey")));
    }
}
