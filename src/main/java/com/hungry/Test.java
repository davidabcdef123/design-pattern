package com.hungry;

import java.util.concurrent.CountDownLatch;

/**
 * Created by sc on 2018/10/31.
 */
public class Test {

    public static void main(String[] args) {
        int count=100;
        CountDownLatch countDownLatch = new CountDownLatch(count);

        for (int i = 0; i < count; i++) {
            new Thread(){
                @Override
                public void run() {
                    try {
                        countDownLatch.await();

                        System.out.println(HungrySingle.getInstance());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
            countDownLatch.countDown();
            System.out.println("-1");
            System.out.println("-2");
            System.out.println("-3");

        }


    }
}
