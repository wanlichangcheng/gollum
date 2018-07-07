package com.tr.www.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yr.www.originserial.User;

import java.io.*;
import java.nio.ByteBuffer;

/**
 * @Author Rong.Yun
 * @Date 2018/7/7 15 24 15:24
 * @Company 离职求学中
 * @Description
 */
public class JacksonSerial implements ISerializable {
    ObjectMapper mapper = new ObjectMapper();
    @Override
    public void write(Object obj, String filename) throws IOException {

        byte[] bytes = mapper.writeValueAsBytes(obj);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(filename);
            fos.write(bytes);
        } finally {
            if (null != fos) {
                fos.close();
            }

        }
    }

    @Override
    public <T> T read(String file, Class<T> clazz) throws IOException {

            T t = mapper.readValue(new File(file), clazz);
            // T t = JSON.toJavaObject(, clazz);
            return t ;

    }
}
