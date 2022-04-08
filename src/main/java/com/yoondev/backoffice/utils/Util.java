package com.yoondev.backoffice.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Util {
    public static OMap convertToOMap(HashMap<String, Object> map){
        OMap oMap = new OMap();

        Set<String> keyList = map.keySet();
        for(String key : keyList){
            oMap.put(key, map.get(key));
        }

        return oMap;
    }

    public static boolean equalsStrs(String value, String ... str){
        boolean pass = false;
        for(String s : str){
            if(s == null){
                return false;
            }
            if (value.equals(s)) {
                pass = true;
            }
        }

        return pass;
    }

    public static boolean notEqualsStrs(String value, String ... str){
        for(String s : str){
            if(value.equals(s)){
                return false;
            }
        }

        return true;
    }

    public static String getQueryString(Map<String, Object> paramMap){
        StringBuilder sb = new StringBuilder();

        for(String p : paramMap.keySet()){
            sb.append(String.format("%s%s=%s", (sb.toString().equals("")) ? "" : "&", p, paramMap.get(p)));
        }

        return sb.toString();
    }


}
