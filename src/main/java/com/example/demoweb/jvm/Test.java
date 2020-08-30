package com.example.demoweb.jvm;

import java.util.ArrayList;

public class Test {
    private byte[] arr=new byte[1024];
    public static void main(String[] args) {
        final ArrayList<Test> list = new ArrayList<>();
        while (true){
            list.add(new Test());
        }
    }
}
