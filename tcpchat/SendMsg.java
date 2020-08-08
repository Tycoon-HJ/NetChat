package net.tcpchat;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;


/**
 * @author 25232
 */
public class SendMsg implements Runnable {
    private int port;
    private Socket socket;
    private BufferedReader br;
    private DataOutputStream dos;
    private String msg;

    public SendMsg(Socket socket, int port) {
        this.socket = socket;
        this.port = port;
        br = new BufferedReader(new InputStreamReader(System.in));

    }

    @Override
    public void run() {
        while (true) {
            try {
                dos = new DataOutputStream(socket.getOutputStream());
                msg = br.readLine();
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
                e.printStackTrace();
                CloseUtils.close(dos, socket);
            }

        }
    }
}
