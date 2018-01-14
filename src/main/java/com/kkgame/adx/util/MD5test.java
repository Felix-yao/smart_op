package com.kkgame.adx.util;


public class MD5test {
	
        public static void main(String[] args)
        {
            String name = "kk";
            MD5Code code = new MD5Code();
            System.out.println(code.getMD5ofStr(name));
            System.out.println(code.getMD5ofStr(name).length());
            System.out.println(code.getMD5ofStr(name).equals(code.getMD5ofStr("kk")));
        }
}
