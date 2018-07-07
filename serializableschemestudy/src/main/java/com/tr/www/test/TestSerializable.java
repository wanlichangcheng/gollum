package com.tr.www.test;

import com.yr.www.originserial.User;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @Author Rong.Yun
 * @Date 2018/7/7 11 33 11:33
 * @Company 离职求学中 during dimission
 * @Description
 * <h1>用来测试各种序列化方案并加以比较</br>
 * comparing different serializable scheam</h1>
 *
 * 什么是序列化？
 * java对象存在于内存中，但是也会存在其他场景
 * 两个系统的对象调用，系统停机后 java对象的持久化保存
 * 序列化就是将内存中的java对象转化为字节 ，一边在网络或其他设备行传输
 * 序列化需要实现serializable接口 当然也可以实现Externalizable 一个更具定制化的序列化接口
 * java序列化技术 存在效率低 空间大 不能跨语言等缺点
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
public class TestSerializable {

    public static  void main(String[] args) throws IOException {
        User  user = new User("LILI", "bbbb", "女");
        //原声方案
        OriginSerial oserial = new OriginSerial();
        processWrite(oserial, user, "user");
        processRead(oserial,  "user");

        //序列化方案:heission,
        HessionSerial hessionSerial = new HessionSerial();
        processWrite(hessionSerial, user, "hessionuser");
        processRead(hessionSerial,  "hessionuser");

        //fastJson
        FastJsonSerial fastJsonSerial = new FastJsonSerial();
        processWrite(fastJsonSerial, user, "fastjsonuser.json");
        processRead(fastJsonSerial,  "fastjsonuser.json");

        //Jackson
        JacksonSerial jacksonSerial = new JacksonSerial();
        processWrite(jacksonSerial, user, "jacksonuser.json");
        processRead(jacksonSerial,  "jacksonuser.json");
    }

    public static void processWrite(ISerializable iSerializable, Object obj, String fileName) throws IOException {
        long start = System.currentTimeMillis();
        iSerializable.write(obj, fileName);
        long end = System.currentTimeMillis();
        String simpleName = iSerializable.getClass().getSimpleName();
        System.out.println(simpleName+"运行时长["+(end-start)+"]");
    }
    public static User processRead(ISerializable iSerializable, String fileName) throws IOException {
        long start = System.currentTimeMillis();
        User read = iSerializable.read(fileName, User.class);
        long end = System.currentTimeMillis();
        String simpleName = iSerializable.getClass().getSimpleName();
        System.out.println(read);
        return read;
    }






}
