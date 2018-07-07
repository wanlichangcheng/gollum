package com.tr.www.test;

import com.yr.www.originserial.User;

import java.io.*;

/**
 * @Author Rong.Yun
 * @Date 2018/7/7 11 53 11:53
 * @Company 离职求学中
 * @Description 原生序列化方案 serializable based on JDK
 */
public class OriginSerial implements ISerializable{
    @Override
    public void write(Object obj,String filename) throws IOException {
        FileOutputStream fos  = null;
        ObjectOutputStream oos = null;
        try {

            fos = new FileOutputStream("user");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(null != fos) {
                fos.close();
            }
            if(null != oos){
                oos.close();
            }
        }

    }
    @Override
    public <T> T read(String file, Class<T> clazz) throws IOException {
        FileInputStream fis  = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            Object o = ois.readObject();
            return (T) o;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(null != fis) {
                fis.close();
            }
        }
        return null;
    }
}



