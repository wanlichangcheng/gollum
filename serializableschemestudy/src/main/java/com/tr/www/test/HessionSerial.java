package com.tr.www.test;

import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;
import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author Rong.Yun
 * @Date 2018/7/7 14 01 14:01
 * @Company 离职求学中
 * @Description heission序列化
 */
public class HessionSerial implements ISerializable{



    @Override
    public void write(Object obj, String filename) throws IOException {
        FileOutputStream fos = null;
        Hessian2Output ho = null;
        try {
            fos = new FileOutputStream(filename);
            ho = new Hessian2Output(fos);
            ho.writeObject(obj);
        } finally {
            if(null != ho){
                ho.close();
            }
            if(null != fos){
                fos.close();
            }
        }
    }

    @Override
    public <T> T read(String file, Class<T> clazz) throws IOException {
        FileInputStream fis = null;
        Hessian2Input hi2 = null;
        T o = null;
        try {
            fis = new FileInputStream(file);
            hi2 = new Hessian2Input(fis);
            o = (T) hi2.readObject(clazz);
            return o;
        } finally {
            if(null != hi2){
                hi2.close();
            }
            if(null != fis){
                fis.close();
            }
        }

    }
}
