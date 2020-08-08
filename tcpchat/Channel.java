package net.tcpchat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author ahai
 */
public class Channel implements Runnable{
    private DataInputStream dis;
    private DataOutputStream dos;
    private String receive="";
    private Socket socket;
    private CopyOnWriteArrayList<Channel> all;

    public Channel(Socket socket) {
        this.socket=socket;
        try {
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());
            SendMsg("欢迎来到聊天室");
        } catch (IOException e) {
            e.printStackTrace();
            CloseUtils.close(dos,dis,socket);
        }
    }

    @Override
    public void run() {
        while(true){
            String msg= ReceiveMsg();
            SendOtherMsg(msg);
        }

    }
    public void SendMsg(String msg){
        try {
            dos.writeUTF(msg);
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
            CloseUtils.close(dos,dis,socket);
        }
    }
    public String ReceiveMsg(){
        try {
            receive=dis.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
            CloseUtils.close(dos,dis,socket);
        }
        return receive;
    }
    public void SendOtherMsg(String msg){
        all=server.getAll();
        for (Channel other : all) {
            if (other == this) {
                continue;
            }else {
                other.SendMsg(msg);
            }
        }
    }
}
