package com.sangeng;

public class Lambda {
    public static void main(String[] args) {
        new Thread(() ->{System.out.println("新线程中方法被执行了");}).start();
    }
}
