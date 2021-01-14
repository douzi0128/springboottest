package com.ym.springbootdemo1.util;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;

import java.sql.SQLException;
import java.util.Map;
import java.util.Set;

public class DbUtil {
    public static void create(String tableName, Map<String,String> keyMap)  {
        try {
            Entity entity = Entity.create("tableName");
            Set<String> set = keyMap.keySet();
            for (String s:set){
                entity.set(s,keyMap.get(s));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


//    public static


}
