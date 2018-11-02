package com.seriable;

import java.io.*;

/**
 * Created by sc on 2018/11/2.
 */
public class Seriable implements Serializable {

    public final static Seriable INSTANCE = new Seriable();

    public static Seriable getInstance() {
        return INSTANCE;
    }

    //如果采用序列化的单例只有实现了这个方法才会是单例
    private  Object readResolve(){
        return  INSTANCE;
    }

    public static void main(String[] args) {
        Seriable s1=null;
        Seriable s2 = Seriable.getInstance();
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("Seriable.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s2);
            oos.flush();
            oos.close();


            FileInputStream fis = new FileInputStream("Seriable.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            s1 = (Seriable)ois.readObject();
            ois.close();

            System.out.println(s1);
            System.out.println(s2);
            System.out.println(s1 == s2);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
