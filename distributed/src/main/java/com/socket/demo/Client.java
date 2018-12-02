package com.socket.demo;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author wangyufei
 * @date 2018/10/10
 */
public class Client {

    public static void main(String[] args) throws IOException {
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1",12345);
            socket.getOutputStream().write("hello".getBytes());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            socket.close();
        }
    }
}
