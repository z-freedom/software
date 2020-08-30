package com.example.demoweb.demo;

import org.omg.CORBA.PUBLIC_MEMBER;

import javax.xml.crypto.Data;

public class Test {
    public static void main(String[] args) {
        final Hero deMa = new DeMa();
        poform(deMa);

        final GuangHui guangHui = new GuangHui();
        poform(guangHui);

    }

    public static void poform(Hero hero){
        hero.DaZhao();
        hero.Skin();
        hero.speend();
    }
}
