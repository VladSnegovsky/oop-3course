package com.company;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Main {

    public static void getClassDescription(String className) {
        try {
            Class<?> clas_s = Class.forName(className);
            System.out.println("Attributes of class " + className + ": " + Arrays.toString(clas_s.getDeclaredFields()));
            System.out.println("Methods of class " + className + ": " + Arrays.toString(clas_s.getDeclaredMethods()));
            Class<?> base = clas_s.getSuperclass();
            System.out.println("Interfaces of class " + className + ": " + Arrays.toString(clas_s.getAnnotatedInterfaces()));
            System.out.println("Base class of class " + className + ": " + base.getName() + "\n");
            if(!base.getName().equals("java.lang.Object")) {
                getClassDescription(base.getName());
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        getClassDescription("com.company.A");
    }
}