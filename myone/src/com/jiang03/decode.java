package com.jiang03;

public class decode {
    public static void main(String[] args) throws Exception{
        String s ="姜东";

        byte[] bytes = s.getBytes();

        String s1 = new String(bytes, "utf-8");

        System.out.println(s1);

    }
}
