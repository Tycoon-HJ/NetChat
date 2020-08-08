package net.udpchat;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @author 25232
 */
public class Receive implements Runnable {
    private int inPort;
    private String From;
    DatagramSocket socket;
    private String receive="";
    public Receive(int inPort, String from) {
        this.inPort = inPort;
        From = from;
        try {
            socket= new DatagramSocket(inPort);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        while (true) {
            byte[] data = new byte[1024];
            DatagramPacket packet = new DatagramPacket(data, 0,data.length);
            try {
                socket.receive(packet);
                byte[] bytes = packet.getData();
                receive = new String(bytes,0,bytes.length);
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println(From+":"+receive);
        }
    }
}
