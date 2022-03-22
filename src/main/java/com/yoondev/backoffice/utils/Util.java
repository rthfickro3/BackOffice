package com.yoondev.backoffice.utils;

import java.util.HashMap;
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
}
