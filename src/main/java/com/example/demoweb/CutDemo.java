package com.example.demoweb;

import cn.hutool.core.io.IORuntimeException;
import cn.hutool.core.io.IoUtil;
import lombok.Cleanup;
import org.springframework.util.FileCopyUtils;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;

public class CutDemo {
    public static void main(String[] args) throws IOException {
        //调用cutFile()函数 传人参数分别为 （原大文件，切割后存放的小文件的路径，切割规定的内存大小）
//        cutFile("D:\\bigData\\elasticsearch-7.6.2-windows-x86_64.zip", "./",1024 * 1024 * 20);
//        cutFile("D:\\bigData\\kibana-7.5.1-windows-x86_64.zip", "./",1024 * 1024 * 20);
        megerFile("D:\\git\\demo-web\\", "kibana-7.5.1-windows-x86_64", 14);
    }

    private static void megerFile(String dir, String pref, int count) throws IOException {
        for (int i = 1; i <= count; i++) {
            @Cleanup final FileOutputStream out = new FileOutputStream(dir + pref + ".zip",true);
            @Cleanup FileInputStream in = new FileInputStream(dir+pref + "-" + i + ".zip");
            IoUtil.copy(in,out);
        }
    }

    private static void cutFile(String src, String endsrc, int num) {
        FileInputStream fis = null;
        File file = null;
        try {
            fis = new FileInputStream(src);
            file = new File(src);
            //创建规定大小的byte数组
            byte[] b = new byte[num];
            int len = 0;
            //name为以后的小文件命名做准备
            int name = 1;
            //遍历将大文件读入byte数组中，当byte数组读满后写入对应的小文件中
            while ((len = fis.read(b)) != -1) {
                //分别找到原大文件的文件名和文件类型，为下面的小文件命名做准备
                String name2 = file.getName();
                int lastIndexOf = name2.lastIndexOf(".");
                String substring = name2.substring(0, lastIndexOf);
                String substring2 = name2.substring(lastIndexOf, name2.length());
                FileOutputStream fos = new FileOutputStream(endsrc + "\\\\" + substring + "-" + name + substring2);
                //将byte数组写入对应的小文件中
                fos.write(b, 0, len);
                //结束资源
                fos.close();
                name++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    //结束资源
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}