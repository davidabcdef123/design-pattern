package com.lazy;

import com.hungry.HungrySingle;
import sun.security.jca.GetInstance;

import java.util.concurrent.CountDownLatch;

/**
 * Created by sc on 2018/10/31.
 * 非线程安全
 */
public class LazyOne {

    private static LazyOne lazyOne=null;

    public static LazyOne getInstance(){
        if(lazyOne==null){
            lazyOne=new LazyOne();
        }
        return lazyOne;
    }

    public static void main(String[] args) {
        int count=100;
        CountDownLatch countDownLatch = new CountDownLatch(count);

        for (int i = 0; i < count; i++) {
            new Thread(){
                @Override
                public void run() {
                    try {
                        countDownLatch.await();

                        System.out.println(LazyOne.getInstance());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
            countDownLatch.countDown();

        }
    }
}
