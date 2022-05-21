package org.un.mapz;

import java.io.File;

public class FileEx {
    public static void main(String[] args) throws Exception {
        String filePath = "c:\\\\";
        File f1 = new File(filePath);
        String list[] = f1.list();
        for(int i = 0; i < list.length; i++) {
            File f2 = new File(filePath, list[i]);
            if(f2.isDirectory()) {
                System.out.printf("%s : 디렉토리 %n", list[i]);
            } else {
                System.out.printf("%s : 파일(%,dbyte%n", list[i], f2.length());
            }
        }
        File f3 = new File("c:\\\\ex\\\\test.txt");
        System.out.println(f3.createNewFile());
        System.out.println(f3.getAbsolutePath());
        System.out.println(f3.getCanonicalPath());
        System.out.println(f3.getPath());
        System.out.println(f3.getName());
        System.out.println(f3.getParent());

        File f4 = new File("c:\\\\ex\\\\test.txt");
        File f5 = new File("c:\\\\ex\\\\test1.txt");
        f4.renameTo(f5);
    }
}
