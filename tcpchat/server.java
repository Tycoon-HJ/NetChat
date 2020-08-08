package net.tcpchat;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author 25232
 */
public class server {
    //容器用于存放聊天的线程
    private static CopyOnWriteArrayList<Channel> all = new CopyOnWriteArrayList<>();

    public static CopyOnWriteArrayList<Channel> getAll() {
        return all;
    }

    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(9999);
        while (true) {
            Socket socket = serverSocket.accept();
            Channel c = new Channel(socket);
            all.add(c);
            new Thread(c).start();
        }
    }
}
