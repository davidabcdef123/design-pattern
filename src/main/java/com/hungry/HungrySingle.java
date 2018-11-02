package com.hungry;

/**
 * Created by sc on 2018/10/31.
 */
public class HungrySingle {

    //线程安全
    private static final HungrySingle hungrySingle = new HungrySingle();

    public static HungrySingle getInstance(){
        return hungrySingle;
    }
}
