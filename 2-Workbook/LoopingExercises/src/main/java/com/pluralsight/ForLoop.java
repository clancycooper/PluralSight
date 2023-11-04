package com.pluralsight;

public class ForLoop {
    public static void main(String[] args) throws InterruptedException {

        for (int countdown = 10; countdown >= 1; countdown--) {
            System.out.println(countdown);
            Thread.sleep(1000);
        }
        System.out.println("Launch!");
    }
}
