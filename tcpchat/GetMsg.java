package net.tcpchat;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class GetMsg implements Runnable {
    private Socket socket;
    private DataInputStream dis;

    public GetMsg(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        while (true) {
            try {
                dis = new DataInputStream(socket.getInputStream());
                System.out.println(dis.readUTF());
            } catch (IOException e) {
                e.printStackTrace();
                CloseUtils.close(dis, socket);
            }

        }
    }
}
