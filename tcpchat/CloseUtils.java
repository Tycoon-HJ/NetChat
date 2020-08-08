package net.tcpchat;

import java.io.Closeable;
import java.io.IOException;

public class CloseUtils {
    public static void close(Closeable... targes) {
        for (Closeable target : targes) {
            if (null != target) {
                try {
                    target.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
