package com.lazy;

import java.io.ObjectStreamClass;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by sc on 2018/11/2.
 */
public class LazyThree {

    private boolean initalized = false;

    private LazyThree() {
        synchronized (LazyThree.class) {
            if (initalized == false) {
                initalized = !initalized;
            } else {
                throw new RuntimeException("单例已被创建");
            }
        }
    }

    public static final LazyThree getInstance() {
        return lazyHolder.LAZY;
    }

    private static class lazyHolder {
        private static final LazyThree LAZY = new LazyThree();
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //通过反射拿到私有的构造方法
        Constructor c = LazyThree.class.getDeclaredConstructor(null);
        //强制访问
        c.setAccessible(true);
        Object o1 = c.newInstance();
        Object o2 = c.newInstance();
        System.out.println(o1==o2);

    }
}
