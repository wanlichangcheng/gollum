package com.tr.www.test;

import java.io.IOException;

/**
 * @Author Rong.Yun
 * @Date 2018/7/7 13 59 13:59
 * @Company 离职求学中
 * @Description
 */
public interface ISerializable {

    void write(Object obj, String filename) throws IOException;

    <T> T read(String file, Class<T> clazz) throws IOException;
}
