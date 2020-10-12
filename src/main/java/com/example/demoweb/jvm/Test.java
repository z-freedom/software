package com.example.demoweb.jvm;

import java.util.ArrayList;

public class Test {
    private byte[] arr=new byte[1024];
    public static void main(String[] args) throws InterruptedException {
        final ArrayList<Test> list = new ArrayList<>();
        int counter=0;
        while (counter++<1000){
            list.add(new Test());
            Thread.sleep(1000);
        }
    }
}
