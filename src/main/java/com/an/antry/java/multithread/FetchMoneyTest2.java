package com.an.antry.java.multithread;

public class FetchMoneyTest2 {
    public static void main(String[] args) {
        Bank2 bank = new Bank2();
        Thread t1 = new MoneyThread2(bank);// 从银行取钱
        Thread t2 = new MoneyThread2(bank);// 从取款机取钱
        t1.start();
        t2.start();
    }
}

class Bank2 {
    private int money = 1000;

    public synchronized int getMoney(int number) {
        if (number < 0) {
            return -1;
        } else if (number > money) {
            return -2;
        } else if (money < 0) {
            return -3;
        } else {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            money -= number;
            System.out.println("Left Money: " + money);
            return number;
        }
    }
}

class MoneyThread2 extends Thread {
    private Bank2 bank;

    public MoneyThread2(Bank2 bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        System.out.println(bank.getMoney(800));
    }
}