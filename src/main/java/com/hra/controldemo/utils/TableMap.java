package com.hra.controldemo.utils;

import java.util.HashMap;
import java.util.Map;

public class TableMap {
    public static final Map<String,String> TABLE_MAP = new HashMap<>();

    static {
        TABLE_MAP.put("network_control","setNetworkControl");
    }

}
