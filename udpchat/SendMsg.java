package net.udpchat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.ArrayList;

/**
 * @author 25232
 */
public class SendMsg implements Runnable{
    BufferedReader br;
    String msg = "";
    DatagramSocket socket;
    private String toIp="";
    private int outPort;
    private int inPort;
    DatagramPacket packet = null;

    public SendMsg(String toIp, int outPort, int inPort){
        this.toIp = toIp;
        this.outPort = outPort;
        this.inPort = inPort;
        try {
            socket = new DatagramSocket(outPort);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {

        while (true) {

            try {
                msg = br.readLine();
                byte[] bytes = msg.getBytes("UTF-8");
                packet = new DatagramPacket(bytes,0,bytes.length, InetAddress.getByName(toIp), inPort);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                socket.send(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
