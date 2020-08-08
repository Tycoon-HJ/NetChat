package net.udpchat;

/**
 * @author 25232
 */
public class Teacher {
    public static void main(String[] args) {
        new Thread(new SendMsg("localhost",7777,8888)).start();
        new Thread(new Receive(9999,"老师")).start();
    }
}
