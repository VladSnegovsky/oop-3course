package com.company;

import com.google.gson.Gson;

public class Man {
    String name;
    String sec_name;
    String age;
    String height;

    public Man(String name,String sec_name,String age,String height){
        this.name = name;
        this.sec_name = sec_name;
        this.age = age;
        this.height = height;
    }

    public String toJSon(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String show(){
        return name + " " + sec_name + " is " + age + " years old and is " + height + " cm height";
    }
}
