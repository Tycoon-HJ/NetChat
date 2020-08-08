package net.udpchat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;


/**
 * @author ahia
 */
public class Server {
    public static void main(String[] args) throws Exception {

        DatagramSocket socket = new DatagramSocket(7777);
        while (true) {
            byte[] data = new byte[1024];
            DatagramPacket packet = new DatagramPacket(data, data.length);
            socket.receive(packet);
            System.out.println(new String(data, 0, data.length));
        }
    }
}
