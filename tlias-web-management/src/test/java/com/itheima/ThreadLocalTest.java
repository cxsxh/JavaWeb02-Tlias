package com.itheima;

public class ThreadLocalTest {
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        threadLocal.set("hello");
        System.out.println(threadLocal.get());
        threadLocal.set("1");
        System.out.println(threadLocal.get());
    }
}
