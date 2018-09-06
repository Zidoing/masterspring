package com.smart.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: zhoulei
 * Date: 05/09/2018
 * Time: 22:11
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class Car {

    private String brand;
    private String color;
    private int maxSpeed;


    public Car() {
    }

    public Car(String brand, String color, int maxSpeed) {
        this.brand = brand;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }


    public void introduce() {
        System.out.println("Car{" +
                "brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", maxSpeed=" + maxSpeed +
                '}');
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Car car = new Car();
        car.setBrand("hongqi");
        car.introduce();

//        j加载类对象
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class clazz = loader.loadClass("com.smart.reflect.Car");

        // 获取类的默认构造器实例化
        Constructor constructor = clazz.getDeclaredConstructor(null);
        Car car2 = (Car) constructor.newInstance();

        Method setBrand = clazz.getMethod("setBrand", String.class);

        setBrand.invoke(car2, "feiji");


        car2.introduce();



    }
}