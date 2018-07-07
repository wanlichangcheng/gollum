package com.tr.www.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONPObject;
import com.alibaba.fastjson.TypeReference;
import com.yr.www.originserial.User;

import java.io.*;

/**
 * @Author Rong.Yun
 * @Date 2018/7/7 14 52 14:52
 * @Company 离职求学中
 * @Description
 */
public class FastJsonSerial implements ISerializable{
    @Override
    public void write(Object obj, String filename) throws IOException {
        String s = JSON.toJSONString(obj);
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(filename );
            fileOutputStream.write(s.getBytes());
        } finally {
            if(null != fileOutputStream) {
                fileOutputStream.close();
            }
        }

    }

    @Override
    public <T> T read(String file, Class<T> clazz) throws IOException {
        FileInputStream fis  = null;
        BufferedReader bufferedReader = null;
        try {
            fis = new FileInputStream(file);
            //拼接读到的字符串
            StringBuilder stringBuilder = new StringBuilder();
            bufferedReader = new BufferedReader(new InputStreamReader(fis));
            boolean firstLine = true;
            String line = null; ;
            while((line = bufferedReader.readLine()) != null){
                if(!firstLine){
                    stringBuilder.append(System.getProperty("line.separator"));
                }else{
                    firstLine = false;
                }
                stringBuilder.append(line);
            }
            User user = (User) JSON.parseObject(stringBuilder.toString(), new TypeReference<User>() { });
            // T t = JSON.toJavaObject(, clazz);
            return (T) user ;
        } finally {
            if(null !=bufferedReader){
                bufferedReader.close();
            }
            if(null != fis) {
                fis.close();
            }
        }

    }
}
