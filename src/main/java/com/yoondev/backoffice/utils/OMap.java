package com.yoondev.backoffice.utils;

import java.util.HashMap;

public class OMap extends HashMap<String, Object> {

    public OMap() {

    }

    public int getInt(String key){
        int v = 0;
        Object o = get(key);

        if(o == null) return v;

        return Integer.parseInt(o.toString());
    }

    public int getInt(String key, int min){
        int v = getInt(key);

        return Math.max(v, min);
    }
}
