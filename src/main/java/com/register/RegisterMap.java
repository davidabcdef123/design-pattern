package com.register;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sc on 2018/10/31.
 * //如果为了线程安全hashmap换成currenthasnmap
 */
public class RegisterMap {

    private static Map<String, Object> registerMap = new HashMap<>();

    public static RegisterMap getInstance(String name) {
        if (name == null) {
            name = RegisterMap.class.getName();
        }
        if (registerMap.get(name) == null) {
            registerMap.put(name, new RegisterMap());
        }
        return (RegisterMap) registerMap.get(name);
    }
}
