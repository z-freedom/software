package com.example.demoweb.demo;

public abstract class Hero {
    public int age;
    int[] Wapen =new int[6];

    /**
     * 大招
     */
    public abstract void DaZhao();

    /**
     * 皮肤
     */
    public abstract void Skin();

    public void speend(){
        System.out.println(500);
    }
}
