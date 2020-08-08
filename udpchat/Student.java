package net.udpchat;

public class Student {
    public static void main(String[] args) {
        new Thread(new SendMsg("localhost",7878,9999)).start();
        new Thread(new Receive(8888,"学生")).start();
    }
}
