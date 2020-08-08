package net.tcpchat;

import java.net.Socket;

/**
 * @author 25232
 */
public class client {
    public static void main(String[] args) throws Exception{
      Socket socket = new Socket("127.0.0.1",9999);
      new Thread(new SendMsg(socket,9999)).start();
      new Thread(new GetMsg(socket)).start();

    }
}
