package com.yoondev.backoffice.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

public class HttpUtil {
    public static final String GET_STATUS_CHECK = "http://localhost:8080/management/statusChk";

    public static HashMap<String, Object> getApiResult(URL url){
        HttpURLConnection conn = null;
        StringBuilder sb = new StringBuilder();
        HashMap<String, Object> resultMap = new HashMap<>();

        try{
            conn = (HttpURLConnection)url.openConnection();

            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);
            conn.connect();

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;

            while((line = br.readLine()) != null){
                sb.append(line);
            }

            ObjectMapper mapper = new ObjectMapper();
            resultMap = mapper.readValue(sb.toString(),
                    new TypeReference<HashMap<String, Object>>() {
                    });
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(conn != null){
                conn.disconnect();
            }
        }

        return resultMap;
    }
}
