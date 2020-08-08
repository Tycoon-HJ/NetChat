package net.udpchat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;

/**
 * @author ahia
 */
public class Client {
    public static void main(String[] args) throws Exception {
        InetAddress host = InetAddress.getByName("localhost");
        String msg = "";
        DatagramSocket socket = new DatagramSocket(9999);
        while (true) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            msg = br.readLine();
            DatagramPacket packet = new DatagramPacket(msg.getBytes(), msg.length(), host, 7777);
            socket.send(packet);
        }

    }
}
