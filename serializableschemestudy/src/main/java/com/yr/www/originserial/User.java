package com.yr.www.originserial;

import java.io.Serializable;

/**
 * @Author Rong.Yun
 * @Date 2018/7/7 11 23 11:23
 * @Company 离职求学中
 * @Description
 */
public class User implements Serializable{
    //this is variable that like digest 这是类的一个摘要
  //  private static final long serialVersionUID = 6459845688498730812L;

    public User() {
    }

    public User(String name, String password, String sex) {
        this.name = name;
        this.password = password;
        this.sex = sex;
    }

    public static String uid = "2";
    public String  name;
    private String password;
    private transient  String sex;

    @Override
    public String toString() {
        //git比较能提吗
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
